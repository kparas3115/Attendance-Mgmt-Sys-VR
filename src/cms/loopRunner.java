 package cms;

import cms.connector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class loopRunner extends JFrame implements ActionListener {
    JLabel rollNo;
    JButton present, absent;
    ResultSet rs;

    String sub;
    int localrollCount = 1, totalRollsFromDb = 0 , i =1;

    loopRunner(){


//        switch(batch){
//            case "B1" : localrollCount = 1;
//            break;
//            case "B2" : localrollCount = 3;
//            break;
//            case "B3" : localrollCount = 4;
//            break;
//
//
//        }

        setSize(500,500);

        String query = "select rollno from stud_details;";
        connector c = new connector();
        try{
            rs = c.s.executeQuery(query);

            while (rs.next()) {
                totalRollsFromDb++;
            }


            rollNo = new JLabel(String.valueOf(localrollCount)); //explicit conversion for int value to string
            rollNo.setBounds(200,80,250,250);
            rollNo.setFont(new Font("Tahoma", Font.BOLD, 68));
            add(rollNo);


            present = new JButton("Present");
            present.setBounds(50,380, 150,50);
            present.setBackground(Color.green);
            present.addActionListener(this);
            add(present);

            absent = new JButton("Absent");
            absent.setBounds(300,380,150,50);
            absent.setBackground(Color.RED);
            absent.addActionListener(this);
            add(absent);


        }catch (Exception e){
            System.out.println(e);
        }


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        connector c = new connector(); //baatcheet karne kaa tareeka
        if(ae.getSource()==present){

            String query = "update stud_details set em3 = em3+1 where rollno = '"+localrollCount+"'";

            try{
                c.s.executeUpdate(query);

                localrollCount++;

                i++;

            }catch (Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource()==absent){
            localrollCount++;
        }
        rollNo.setText(String.valueOf(localrollCount));
    }

    public static void main(String[] args) {
        new loopRunner();
    }
}