package Electricity;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeterInfo extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    Choice c1, c2, c3, c4, c5;
    JButton b1, b2;
    MeterInfo(String meter) {
        setLocation(600,200);
        setSize(700,500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(173,216,230));

        l11 = new JLabel(meter);
        l11.setBounds(240,80,200,20);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        new MeterInfo("").setVisible(true);
    }
}