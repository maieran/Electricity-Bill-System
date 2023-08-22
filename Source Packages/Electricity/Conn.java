package Electricity;

import java.sql.*;

public class Conn{
    Connection c;
    Statement s;
    string;
    try {
        Class.forName("com.mysql.jdbc.Driver"):
        c = DriverManager.getConnection("jdbc:mysql:///ebs","root", "YourPasswordHere");
        s = c.createStatement();
    } catch(Exception e){
        System.out.println(e);
    }
}