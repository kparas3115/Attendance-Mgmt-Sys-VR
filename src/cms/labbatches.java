package cms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class labbatches extends JFrame implements ActionListener {

    JButton B1, B2, B3;

    labbatches() {
        setSize(400, 300);

        B1 = new JButton("Batch B1");
        B1.setBounds(50, 20, 300, 50);
        B1.addActionListener(this);
        add(B1);

        B2 = new JButton("Batch B2");
        B2.setBounds(50, 100, 300, 50);
        B2.addActionListener(this);
        add(B2);

        B3 = new JButton("Batch B3");
        B3.setBounds(50, 180, 300, 50);
        B3.addActionListener(this);
        add(B3);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,400,300);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == B1) {
            new managelab();
        }
        if (ae.getSource() == B2) {
            new managelab();
        }
        if (ae.getSource() == B3) {
            new managelab();

        }
    }

    public static void main(String[] args) {
        new labbatches();
    }
}