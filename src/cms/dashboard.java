package cms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JButton  SE , TE , logout;
    dashboard(){
        setSize(1450 ,800);

        mb = new JMenuBar();
        mb.setBounds(0,0,150 , 750);
        mb.setLayout(new GridLayout(3, 1,40 ,40 ));
        mb.setBackground(Color.blue);
        mb.setBackground(Color.getColor("green"));

        SE = new JButton("SE AIML");
        SE.addActionListener(this);
        mb.add(SE);

        TE = new JButton("TE AIML");
        TE.addActionListener(this);
        mb.add(TE);

        logout = new JButton("Log Out");
        mb.add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/AMS.jpg"));
        JLabel i3 = new JLabel(i1);
        i3.setBounds(-10,-120,1600,1000);
        add(i3);

        add(mb);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==SE){
            new option();
        }
        if(ae.getSource()==TE){
            new option();
        }
        if(ae.getSource()==logout){
            new login();
        }
    }

    public static void main(String[] args) {

        new dashboard();

    }
}
