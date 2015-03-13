package gui;
/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportMembers  extends JFrame {

    private JFrame rm;
    private JButton employee, year, month, week, okButton, members, product, sales;
    private JLabel jLabel1; //Graph
    private JPanel jPanel1, jPanel2, jPanel3;//Personnel, calender, range
    private JPanel mainPanel;
    private JTextField jTextField1; // Search

    public ReportMembers() {

        rm = new JFrame();
        rm.setTitle("View Reports");
        rm.setSize(800, 700);
        rm.setLocationRelativeTo(null);
        rm.setLayout(new BorderLayout());
        rm.getContentPane().setBackground(new Color(98, 169, 221));
        rm.setVisible(true);

        jTextField1 = new JTextField();


        employee = new JButton("Employee");
        employee.setPreferredSize(new Dimension(150, 40));
        employee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        year = new JButton("Year");//Year Combo Box
        year.setPreferredSize(new Dimension(150, 40));
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Get combo boxes
            }
        });

        month = new JButton("Month");//Month Year Combo Box
        month.setPreferredSize(new Dimension(150, 40));
        month.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        week = new JButton("Week"); //Week Year Combo Box
        week.setPreferredSize(new Dimension(150, 40));
        week.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });

        okButton = new JButton("Ok");
        okButton.setPreferredSize(new Dimension(150, 40));
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Button Clicked!");
            }
        });

        members = new JButton("Members");
        members.setPreferredSize(new Dimension(150, 40));
        members.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        product = new JButton("Products");
        product.setPreferredSize(new Dimension(150, 40));
        product.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        sales = new JButton("Sales");
        sales.setPreferredSize(new Dimension(150, 40));
        sales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));// personnel Panel
        jPanel1.add(employee);
        jPanel1.add(members);
        jPanel1.add(product);
        jPanel1.add(sales);

        jPanel2 = new JPanel(new GridBagLayout()); //Calender
        jPanel2.add(week);
        jPanel2.add(month);
        jPanel2.add(year);

        jPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Range
        jPanel3.add(jTextField1);
        jPanel3.add(okButton);


    }
}
