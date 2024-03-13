package cms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class starter extends JFrame implements ActionListener {

    JButton login;

    starter() {
        setSize(1280, 720);
        //l1.setBounds(380, -10, 470, 270);
        //l1.setFont(new Font("Tahoma", Font.BOLD, 32));
        //add(l1);

        login = new JButton("LOGIN");
        login.setBounds(1000, 600, 140, 30);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/AMS.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,1280,720);
        add(i3);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){ //if ae's source is login then open login window as per constructor call
           new login();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new starter();
    }
}
