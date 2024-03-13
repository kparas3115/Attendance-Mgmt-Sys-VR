package cms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class option extends JFrame implements ActionListener {
    JButton pa, details;

    option() {
        setSize(400, 300);

        pa = new JButton("Manage Attendance For Theory And Lab");
        pa.setBounds(50, 50, 300, 50);
        pa.addActionListener(this);
        add(pa);

        details = new JButton("Manage Details");
        details.setBounds(50, 140, 300, 50);
        details.addActionListener(this);
        add(details);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,400,300);
        add(i3);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pa) {
            new theorylab();
            setVisible(false); // Hide the current frame
        }

        if (ae.getSource() == details) {
            new addDetails();
            setVisible(false); // Hide the current frame
        }
    }

    public static void main(String[] args) {
        new option();
    }
}
