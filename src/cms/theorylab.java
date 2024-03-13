package cms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class theorylab extends JFrame implements ActionListener {
    JButton th,lb;

    theorylab() {
        setSize(400, 300);

        th = new JButton("Theory");
        th.setBounds(50, 50, 300, 50);
        th.addActionListener(this);
        add(th);

        lb = new JButton("Lab");
        lb.setBounds(50, 140, 300, 50);
        lb.addActionListener(this);
        add(lb);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,400,300);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == th) {
            new manageattendance();
            setVisible(false); // Hide the current frame
        }

        if (ae.getSource() == lb) {
            new labbatches();
            setVisible(false); // Hide the current frame
        }
    }

    public static void main(String[] args) {
        new theorylab();
    }
}
