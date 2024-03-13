package cms;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class addDetails extends JFrame implements ActionListener {
    int x = 80;
    int txtX = 250;
    int txtWidth = 200;
    int txtHeight = 40;
    Font font = new Font("Tahoma",Font.BOLD,20);
    JButton addData;
    JDateChooser dob ;
    JTextField Name ;
    JTextField Address ;
    JTextField Contact ;
    JComboBox bldGrp;
    JComboBox batch;
    JRadioButton male;

    JRadioButton female;

    addDetails() {
        setSize(600, 700);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(x, 70, 150, 40);
        l1.setFont(font);
        add(l1);


        JLabel l3 = new JLabel("D.O.B");
        l3.setBounds(x, 190, 150, 40);
        l3.setFont(font);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(x, 250, 150, 40);
        l4.setFont(font);
        add(l4);

        JLabel l5 = new JLabel("Address");
        l5.setBounds(x, 310, 150, 40);
        l5.setFont(font);
        add(l5);

        JLabel l6 = new JLabel("Contact");
        l6.setBounds(x, 370, 150, 40);
        l6.setFont(font);
        add(l6);

        JLabel l7 = new JLabel("Blood Group");
        l7.setBounds(x, 430, 150, 40);
        l7.setFont(font);
        add(l7);

        JLabel l8 = new JLabel("Batch");
        l8.setBounds(x, 490, 150, 40);
        l8.setFont(font);
        add(l8);



         Name = new JTextField();
        Name.setBounds(txtX, 70, txtWidth, txtHeight);
       add(Name);

//        PRNNumber = new JTextField();
//        PRNNumber.setBounds(txtX, 130, txtWidth, txtHeight);
//       add(PRNNumber);

       Address = new JTextField();
        Address.setBounds(txtX, 310, txtWidth, txtHeight);
       add(Address);

        Contact = new JTextField();
        Contact.setBounds(txtX, 370, txtWidth, txtHeight);
       add(Contact);

        dob = new JDateChooser();
        dob.setBounds(txtX , 190 , txtWidth , txtHeight);
       add(dob);

        ButtonGroup btn = new ButtonGroup();
        male = new JRadioButton("Male");
        male.setBounds(txtX,250, txtWidth / 2, txtHeight);
        btn.add(male);
       add(male);

      female = new JRadioButton("Female");
        female.setBounds(txtX+120, 250, txtWidth / 2, txtHeight);
        btn.add(female);
        add(female);

        String[] arr = {"Select","A+", "A-", "B+", "B-", "AB+", "O+", "O-"};
         bldGrp = new JComboBox(arr);
        bldGrp.setBounds(txtX, 430, txtWidth, txtHeight);
        add(bldGrp);
        
        
        

        String[] arr1 = {"B1", "B2", "B3"};
        batch = new JComboBox(arr1);
        batch.setBounds(txtX, 490, txtWidth, txtHeight);
        add(batch);
//        
//        
//        String[] arr1 = {"Select","CS", "IT", "AIDS", "AIML", "CSE-IOT", "ECS", "EXTC" , "MECH" , "PPT"};
//        Branch = new JComboBox(arr1);
//        Branch.setBounds(txtX, 490, txtWidth, txtHeight);
//        add(Branch);

//        String[] arr2 = {"Select","FE","SE", "TE", "BE"};
//        Year = new JComboBox(arr2);
//        Year.setBounds(txtX, 550, txtWidth, txtHeight);
//        add(Year);

        addData = new JButton("Add Data");
        addData.setBounds(400,610,100,40);
        addData.addActionListener(this);
        add(addData);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,-100,600,900);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addData) {
            String name = this.Name.getText();
//            String PRN = this.PRNNumber.getText();
            String address = this.Address.getText();
            String contact = this.Contact.getText();


            //for storing date

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
            String dob = dateFormat.format(this.dob.getDate());

            String gender = null;
            if (this.male.isSelected()) {
                gender = "Male";
            } else if (this.female.isSelected()) {
                    gender = "Female";
                }
                String bldgrp = (String) this.bldGrp.getSelectedItem();//explicit conversion convert object data type to string
                String batch = (String) this.batch.getSelectedItem();
//                String year = (String) Year.getSelectedItem();
                connector c = new connector();
                //insertion query
                String str = "insert into stud_details(name,gender,address,contact,batch,dob,bldGrp) values('" + name + "','" + gender + "','" + address + "','" + contact + "','" + batch + "','" + dob + "','" + bldgrp + "');";

                try {
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Data Added Successfully");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }



    public static void main(String[] args) {
        new addDetails();
    }
}
