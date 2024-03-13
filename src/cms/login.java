package cms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JButton signin , cancel;
    JPasswordField password; //what we insert as a password should be hidden from a third person pov
    JTextField username;

    Font f1 = new Font("Tahoma", Font.BOLD, 20);
    login() {
        setSize(600 , 400);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(100, 80, 150, 50);
        l1.setForeground(Color.BLACK);
        l1.setFont(f1);
        add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(100, 160, 150, 50);
        l2.setForeground(Color.BLACK);
        l2.setFont(f1);
        add(l2);


        username = new JTextField();
        username.setBounds(250, 80, 150, 40);
        username.setFont(f1);
        add(username);

        password = new JPasswordField();
        password.setBounds(250, 160, 150, 40);
        password.setFont(f1);
        add(password);

        signin = new JButton("Sign In");
        signin.setBounds(200,260,120 , 50);
        signin.setFont(f1);
        signin.addActionListener(this);
        add(signin);

        cancel = new JButton("Cancel");
        cancel.setBounds(400 ,260 , 120 , 50);
        cancel.setFont(f1);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(0,0,1280,720);
        add(i3);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==signin){
            String Username = this.username.getText();
            String password = String.valueOf(this.password.getPassword());
            connector c = new connector();
            try{
                String str1 = "select * from login where username = '"+Username+"' and password = '"+password+"';";
                ResultSet rs = c.s.executeQuery(str1);
                if(rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new dashboard();
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Login Credentials");
                }
            }

            catch(Exception e){
                System.out.println(e);
            }
        }

        if (ae.getSource()==cancel){
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
