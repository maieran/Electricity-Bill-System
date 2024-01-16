package Electricity;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Conn{
    Connection connection;
    Statement statement;
    public Conn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String propertyFile = "../../db_properties/ebs_user_pw.txt";
            String[] credentials = readCredentialsFromFile(propertyFile);

            if (credentials != null && credentials.length == 2)
            {
                String rootUser = credentials[0];
                String password = credentials[1];

                connection = DriverManager.getConnection("jdbc:mysql:///ebs",rootUser, password);
                statement = connection.createStatement();
            } else {
                System.out.println("Error reading credentials from property file");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private String[] readCredentialsFromFile(String propertyFile) {
        String[] credentials = new String[2];
        int i = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(propertyFile))){
            String credentialLine;
            while ((credentialLine = bufferedReader.readLine()) != null) {
                credentials[i] = credentialLine;
                i++;
            }
            return credentials;
        } catch (FileNotFoundException e) {
            System.err.println("Error: Not a file or file cannot be found");
        } catch (IOException e) {
            System.err.println("Error: File cannot be read");
        }
        return null;
    }
}