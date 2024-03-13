package cms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pb3 extends JFrame {
    public pb3() {
        String[] subjects = {"EM III", "DLCOA", "CG", "DS"};
        JFrame frame = new JFrame("Attendance Management System");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

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
        SwingUtilities.invokeLater(() -> {
            pb3 pb = new pb3();
            pb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

    public static void showAttendanceOptions(String subject) {
        JFrame optionsFrame = new JFrame("Manage Attendance for " + subject);
        optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        optionsFrame.setSize(400, 500);
        optionsFrame.setLayout(new BorderLayout());

        JPanel optionsPanel = new JPanel(new CustomGridLayout(0, 3, 0, 5));

        // Modify the student names for roll numbers 24 to 46
        String[] studentNames = new String[23];
        for (int i = 24; i <= 46; i++) {
            studentNames[i - 24] = "Roll Number " + i;

            JLabel nameLabel = new JLabel(studentNames[i - 24]);
            JRadioButton presentRadioButton = new JRadioButton("Present");
            JRadioButton absentRadioButton = new JRadioButton("Absent");

            ButtonGroup group = new ButtonGroup();

            group.add(presentRadioButton);
            group.add(absentRadioButton);

            optionsPanel.add(nameLabel);
            optionsPanel.add(presentRadioButton);
            optionsPanel.add(absentRadioButton);

            final String currentStudentName = studentNames[i - 24];

            presentRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implement code to mark the student as present for the selected subject
                    System.out.println("Marked Present for " + subject + " - " + currentStudentName);
                }
            });

            absentRadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Implement code to mark the student as absent for the selected subject
                    System.out.println("Marked Absent for " + subject + " - " + currentStudentName);
                }
            });
        }

        optionsFrame.add(new JScrollPane(optionsPanel), BorderLayout.CENTER);
        optionsFrame.setVisible(true);
    }

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