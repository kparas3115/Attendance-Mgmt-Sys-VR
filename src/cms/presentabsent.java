package cms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class presentabsent extends JFrame {
    presentabsent(){
        String[] subjects = {"EM III", "DSGT", "DLCOA", "CG", "DS"};
        JFrame frame = new JFrame("Attendance Management System");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        
       JLabel titleLabel = new JLabel("Welcome to Attendance Management System");
       titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
       frame.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        for (String subject : subjects) {
            JButton subjectButton = new JButton("Manage Attendance For " + subject);
            subjectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showAttendanceOptions(subject);
                }
            });
            buttonsPanel.add(subjectButton);
        }

        frame.add(buttonsPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        String[] subjects = {"EM III", "DSGT", "DLCOA", "CG", "DS"};
        JFrame frame = new JFrame("Attendance Management System");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // JLabel titleLabel = new JLabel("Welcome to Attendance Management System");
        //titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // frame.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        for (String subject : subjects) {
            JButton subjectButton = new JButton("Manage Attendance For " + subject);
            subjectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showAttendanceOptions(subject);
                }
            });
            buttonsPanel.add(subjectButton);
        }

        frame.add(buttonsPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void showAttendanceOptions(String subject) {
        JFrame optionsFrame = new JFrame("Manage Attendance for " + subject);
        optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        optionsFrame.setSize(400, 500); // Adjusted size for the new layout
        optionsFrame.setLayout(new BorderLayout());

        JPanel optionsPanel = new JPanel(new CustomGridLayout(0, 3, 0, 5));

        String[] studentNames = new String[100];
        for (int i = 0; i < 69; i++) {
            studentNames[i] = "Roll Number  " + (i + 1);

            JLabel nameLabel = new JLabel(studentNames[i]);
            JRadioButton presentRadioButton = new JRadioButton("Present");
            JRadioButton absentRadioButton = new JRadioButton("Absent");

            ButtonGroup group = new ButtonGroup(); // Create a ButtonGroup for each student
            group.add(presentRadioButton);
            group.add(absentRadioButton);

            optionsPanel.add(nameLabel);
            optionsPanel.add(presentRadioButton);
            optionsPanel.add(absentRadioButton);

            int studentIndex = i; // Capture the current student index for the ActionListener

            presentRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add code to mark the student as present for the selected subject
                    System.out.println("Marked Present for " + subject + " - " + studentNames[studentIndex]);
                }
            });

            absentRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add code to mark the student as absent for the selected subject
                    System.out.println("Marked Absent for " + subject + " - " + studentNames[studentIndex]);
                }
            });
        }

        optionsFrame.add(new JScrollPane(optionsPanel), BorderLayout.CENTER); // Use a scroll pane for many students

        optionsFrame.setVisible(true);
    }

    public static void takeAttendance(String subject, String studentName) {
        JFrame attendanceFrame = new JFrame("Take Attendance for " + studentName);
        attendanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        attendanceFrame.setSize(400, 200);
        attendanceFrame.setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel(new FlowLayout());

        JButton presentButton = new JButton("Present");
        JButton absentButton = new JButton("Absent");

        presentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to mark the student as present for the selected subject
                System.out.println("Marked Present for " + subject + " - " + studentName);
            }
        });

        absentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code to mark the student as absent for the selected subject
                System.out.println("Marked Absent for " + subject + " - " + studentName);
            }
        });

        buttonsPanel.add(presentButton);
        buttonsPanel.add(absentButton);

        attendanceFrame.add(buttonsPanel, BorderLayout.CENTER);

        attendanceFrame.setVisible(true);
    }

    // CustomGridLayout class to reduce space between rows
    static class CustomGridLayout extends GridLayout {
        int vgap;

        CustomGridLayout(int rows, int cols, int hgap, int vgap) {
            super(rows, cols);
            this.vgap = vgap;
        }

        public int getVgap() {
            return vgap;
        }
    }
}