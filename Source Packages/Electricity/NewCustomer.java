package Electricity;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCustomer extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l11;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;

    public NewCustomer() {
        setLocation(450,200);
        setSize(700, 500);
        //setSize(1400, 1400);

        JPanel panel = new JPanel();
        /*
         * this one works with changing background color
         */
        getContentPane().setBackground(new Color(173, 216, 230));
        panel.setLayout(null);
        //panel.setOpaque(true);
        panel.setBackground(Color.GREEN);
        panel.setBackground(new Color(173, 216, 230));
        //panel.setBackground(new Color(250, 250, 70));


        JLabel title = new JLabel("New Customer");
        title.setBounds(180, 10, 200,26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        panel.add(title); //added das Label ins Panel

        l1 = new JLabel("Customer Name");
        l1.setBounds(100,80,100,20);

        t1 = new JTextField();
        t1.setBounds(240,80,200,20);
        panel.add(l1);
        panel.add(t1);




    }


    public static void main(String[] args) {
        new NewCustomer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}