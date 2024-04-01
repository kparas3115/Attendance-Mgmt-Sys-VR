
import datetime
import wikipedia
import speech_recognition as sr
import os
import pyttsx3
import webbrowser
import smtplib

engine = pyttsx3.init('sapi5')
voices = engine.getProperty('voices')
engine.setProperty('voice',voices[0].id)

def speak(audio):
    engine.say(audio)
    engine.runAndWait()

def wishMe():
    hour = int(datetime.datetime.now().hour)
    if hour>=0 and hour<12:
        speak("Good Morning")
    elif hour>=12 and hour<18:
        speak("Good Afternoon")
    else:
        speak("Good Evening")
    speak("AMS AI on this side! How may I help you?")

def takeCommand():
    r = sr.Recognizer()
    with sr.Microphone() as source:
     print("Listening...")
     r.pause_threshold = 1
     audio = r.listen(source)

    try:
        print("Understanding...")
        query = r.recognize_google(audio, language="en-in")
        print(f"User said: {query}\n")

    except Exception as e:
            print("Please Say Again")
            return "None"
    return query

if __name__ == '__main__':
        wishMe()
        while True:
            query = takeCommand().lower()

            # task execution logic
            if 'wikipedia' in query:
                speak('Searching Wikipedia...')
                query = query.replace("wikipedia", "")
                results = wikipedia.summary(query, sentences=2)
                speak("According to Wikipedia...")
                print(results)
                speak(results)

            elif 'thank you' in query:
                speak("Your Welcome! Any More Info you would like to have?")

            elif 'youtube' in query:
                webbrowser.open("youtube.com")

            elif 'google' in query:
                webbrowser.open("google.com")

            elif 'instagram' in query:
                webbrowser.open("instagram.com")

            elif 'the time' in query:
                strTime = datetime.datetime.now().strftime("%H:%M:%S")
                speak(f"The Time is {strTime}")

            elif 'code' in query:
                codepath = "C:\\Users\paras\AppData\Local\Programs\Microsoft VS Code\Code.exe"
                os.startfile(codepath)


            elif 'good' in query:
                speak("Thank you! Up For More!")

            elif 'music' in query:
                webbrowser.open("spotify.com")

            elif 'gmail' in query:
                webbrowser.open("gmail.com")

            elif 'attendance' in query:
                
