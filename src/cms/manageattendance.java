package cms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manageattendance extends JFrame implements ActionListener {
    JButton em3, dsgt, ds, dlcoa, cg;

    manageattendance() {
        setSize(400, 300);

        em3 = new JButton("Manage Attendance For EM3");
        em3.setBounds(50, 20, 300, 20);
        em3.addActionListener(this);
        add(em3);

        dsgt = new JButton("Manage Attendance For DSGT");
        dsgt.setBounds(50, 60, 300, 20);
        dsgt.addActionListener(this);
        add(dsgt);

        ds = new JButton("Manage Attendance For DS");
        ds.setBounds(50, 100, 300, 20);
        ds.addActionListener(this);
        add(ds);

        dlcoa = new JButton("Manage Attendance For DLCOA");
        dlcoa.setBounds(50, 140, 300, 20);
        dlcoa.addActionListener(this);
        add(dlcoa);

        cg = new JButton("Manage Attendance For CG");
        cg.setBounds(50, 180, 300, 20);
        cg.addActionListener(this);
        add(cg);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == em3) {
            new loopRunner();
        }
        if (ae.getSource() == dsgt) {
            new loopRunner2();
        }
        if (ae.getSource() == ds) {
            new loopRunner3();
        }
        if (ae.getSource() == dlcoa) {
            new loopRunner4();
        }
        if (ae.getSource() == cg) {
            new loopRunner5();
        }
    }

    public static void main(String[] args) {
        new manageattendance();
    }
}