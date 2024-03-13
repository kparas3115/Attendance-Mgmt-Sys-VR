package cms;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class attendance extends JFrame implements ActionListener {
    JButton add , defaulters , refresh;
    JTable t1;
    JScrollPane sp1;

    attendance(){
        setSize(1280 , 720);
        sp1 =new JScrollPane();
        sp1.setBounds(550 ,80 , 400 , 300 );
        this.add(sp1);

        t1 = new JTable();
        sp1.setViewportView(t1); //fill table and view table on the sql port
        displayOriginal();

        add = new JButton("Add / Update");
        add.setBounds(70 , 80 , 120 , 50);
        this.add(add);

        defaulters = new JButton("Defaulters");
        defaulters.setBounds(70 , 180 , 120 , 50);
        defaulters.addActionListener(this);
        this.add(defaulters);

        refresh = new JButton();
        refresh.setBounds(900 , 390 , 40 , 40);
        refresh.addActionListener(this);
        add(refresh);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(-20,0,1280,720);
        add(i3);

        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    void displayOriginal(){
        try{
            connector c = new connector();
            String str = "select name , prn , attendance from stud_details";
            ResultSet rs = c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs)); //jar file o/p
        }catch(Exception e) {
            System.out.println(e);

        }
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==defaulters){
            connector c = new connector();
            try{
                String str = "select name , prn , attendance from stud_details where attendance < 75; ";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                System.out.println(e);
            }
        }

        if(ae.getSource()==refresh){
            displayOriginal();
        }
    }

    public static void main(String[] args) {
        new attendance();
    }
}
