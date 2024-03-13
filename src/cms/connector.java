package cms;
import java.sql.*;     //import statement for SQL
public class connector {
    Connection c;      //Connection class object in SQL package
    Statement s;
    connector(){
        String url = "jdbc:mysql://localhost:3306/colmonsys";

        String username = "root";

        String password = "kps@3115";

        try{
            c = DriverManager.getConnection(url,username,password);
            s = c.createStatement();
        }
       catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new connector();     //constructor call
    }
}
