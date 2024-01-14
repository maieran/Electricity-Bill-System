package Electricity;


import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.jar.JarEntry;

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
        //getContentPane().setBackground(new Color(173, 216, 230));
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
        l2 = new JLabel("Meter No");
        l2.setBounds(100, 120,100,20);
        l11 = new JLabel();
        l11.setBounds(240,120,200,20);
        panel.add(l2);
        panel.add(l11);

        l3 = new JLabel("Address");
        l3.setBounds(100,160,200,20);
        t3 = new JTextField();
        t3.setBounds(240,160,200,20);
        panel.add(l3);
        panel.add(t3);

        l4 = new JLabel("State");
        l4.setBounds(100,240,100,20);
        t4 = new JTextField();
        t4.setBounds(240,240,200,20);
        panel.add(l4);
        panel.add(t4);


        l5 = new JLabel("City");
        l5.setBounds(100,200,200,20);
        t5 = new JTextField();
        t5.setBounds(240, 200,200,20);
        panel.add(l5);
        panel.add(t5);

        l6 = new JLabel("Email");
        l6.setBounds(100,280,100,20);
        t6 = new JTextField();
        t6.setBounds(240,280,200,20);
        panel.add(l6);
        panel.add(t6);

        l7 = new JLabel("Phone Number");
        l7.setBounds(100,320,100,20);
        t7 = new JTextField();
        t7.setBounds(240,320,200,20);
        panel.add(l7);
        panel.add(t7);

        b1 = new JButton("Next");
        b1.setBounds(120,390,100,25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390,100,25);

        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);

        panel.add(b1);
        panel.add(b2);
        setLayout(new BorderLayout());

        add(panel, "Center");

        ImageIcon ic1 = new ImageIcon("icon/hicon1.jpg");
        Image i3 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);

        add(l8, "West");
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        Random random = new Random();
        long first = (random.nextLong() % 1000000);
        l11.setText(""+Math.abs(first));

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == b1) {
            String name = t1.getText();
            String meter = l11.getText();
            String address = t3.getText();
            String state = t4.getText();
            String city = t5.getText();
            String email = t6.getText();
            String phone = t7.getText();

            String stmnt1 = "insert into customer value ('"+name+"', '"+meter+"', '"+address+"','"+city+"', '"+state+"', '"+email+"','"+phone+"')";
            String stmnt2 = "insert into login values('"+meter+"', '', '', '', '')";

            try {
                Conn c1 = new Conn();
                c1.s.executeUpdate(stmnt1);
                c1.s.executeUpdate(stmnt2);
                JOptionPane.showMessageDialog(null,"Customer details have been added successfully");
                this.setVisible(false);
                new MeterInfo(meter).setVisible(true);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } else if (event.getSource() == b2) {
            this.setVisible(false);
        }

    }


    public static void main(String[] args) {
        new NewCustomer().setVisible(true);
    }


}