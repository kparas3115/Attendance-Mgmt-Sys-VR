package cms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class managelab extends JFrame implements ActionListener {
    JButton em3, ds, dlcoa, cg;

    managelab() {
        setSize(400, 300);

        em3 = new JButton("Manage Attendance For EM3");
        em3.setBounds(50, 20, 300, 20);
        em3.addActionListener(this);
        add(em3);

        ds = new JButton("Manage Attendance For DS");
        ds.setBounds(50, 60, 300, 20);
        ds.addActionListener(this);
        add(ds);

        dlcoa = new JButton("Manage Attendance For DLCOA");
        dlcoa.setBounds(50, 100, 300, 20);
        dlcoa.addActionListener(this);
        add(dlcoa);

        cg = new JButton("Manage Attendance For CG");
        cg.setBounds(50, 140, 300, 20);
        cg.addActionListener(this);
        add(cg);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == em3) {
            new loopRunner6();
        }
        if (ae.getSource() == ds) {
            new loopRunner7();
        }
        if (ae.getSource() == dlcoa) {
            new loopRunner8();
        }
        if (ae.getSource() == cg) {
            new loopRunner9();
        }
    }

    public static void main(String[] args) {
        new managelab();
    }
}
