package Electricity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {

    public Project(String meter, String user) {
        System.out.println(meter.toString());
        System.out.println(user.toString());
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}