package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class ReportSales   extends JFrame {

    private JFrame re;
    private JButton employee, year, month, week, okButton, members, product, sales;
    private JLabel jLabel1; //Graph
    private JPanel jPanel1, jPanel2, jPanel3;//Personnel, calender, range
    private JPanel mainPanel;
    private JTextField jTextField1; // Search

    public ReportSales() {

        re = new JFrame();
        re.setTitle("View Reports");
        re.setSize(800,700);
        re.setLocationRelativeTo(null);
        re.setLayout(new BorderLayout());
        re.getContentPane().setBackground(new Color(98, 169, 221));
        re.setVisible(true);

        employee = new JButton("Employee");
        employee.setPreferredSize(new Dimension(150, 40));
        employee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        year = new JButton("Year");
        year.setPreferredSize(new Dimension(150, 40));
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        month = new JButton("Month");
        month.setPreferredSize(new Dimension(150, 40));
        month.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        week = new JButton("Week");
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
