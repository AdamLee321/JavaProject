package gui;

import database.operations.ReportOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Year;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class ReportEmployee extends JFrame {

    private JFrame re;
    private JButton employee, year, month, week, okButton, members, product, sales;
    private JLabel jLabel1; //Graph
    private JPanel north, jPanel1, jPanel2, jPanel3, south;//Container ,Personnel, calender, range, graph
    private JTextField jTextField1; // Search

    public ReportEmployee() {

        re = new JFrame();
        re.setTitle("Reports");
        re.setLayout(new BorderLayout());
        re.setSize(500, 500);
        re.setLocationRelativeTo(null); //Sets the screen to appear in the center
        re.setResizable(true);


        //NORTH PANEL
        north = new JPanel(new BorderLayout());
        north.setBackground(new Color(98, 169, 221));

        jPanel1 = new JPanel(new FlowLayout());
        jPanel1.setBackground(new Color(98, 169, 221));
        jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Personnel"));
        //north.add(jPanel1, BorderLayout.NORTH); //Places the panel inside the north panel
        //Sales Button;
        sales = new JButton("Sales");
        jPanel1.add(sales);
        jPanel1.setForeground(Color.GRAY);
        sales.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                //SALES ACTION
            }
        });

        //Employee Button
        employee = new JButton("Employee");
        jPanel1.add(employee);
        employee.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                //EMPLOYEE ACTION
            }
        });

        //Product Button
        product = new JButton("Product");
        jPanel1.add(product);
        jPanel1.setBackground(new Color(98, 169, 221));
        product.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                //PRODUCT ACTION
            }
        });

        //Members Button
        members = new JButton("Members");
        jPanel1.add(members);
        members.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MEMBERS ACTION
            }
        });
        north.add(jPanel1, BorderLayout.NORTH);//Places the panel inside the north panel

        jPanel2 = new JPanel(new FlowLayout());
        jPanel2.setBackground(new Color(98, 169, 221));
        jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Calender"));
        //Week Button
        week = new JButton("Week");
        jPanel2.add(week);
        week.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //WEEK ACTION
            }
        });
        //Month Button
        month = new JButton("Month");
        jPanel2.add(month);
        month.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MONTH ACTION
            }
        });
        //Year Button
        year = new JButton("Year");
        jPanel2.add(year);
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //YEAR ACTION
            }
        });
        north.add(jPanel2, BorderLayout.CENTER);

        jPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel3.setBackground(new Color(98, 169, 221));
        jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Range"));
        //TextField
        jTextField1 = new JTextField("Emp id");
        jTextField1.setColumns(15);// Sets the column width of the Textfield
        jPanel3.add(jTextField1);
        //OK BUTTON
        okButton = new JButton("Ok");
        jPanel3.add(okButton);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //OK ACTION
            }
        });
        north.add(jPanel3,BorderLayout.SOUTH);

        //SOUTH
        south = new JPanel(new BorderLayout());
        south.setBackground(new Color(98, 169, 221));
        jLabel1 = new JLabel("GRAPH"); //Graph displayed here
        south.add(jLabel1 ,BorderLayout.CENTER);

        re.add(north, BorderLayout.NORTH);
        re.add(south, BorderLayout.CENTER);
        re.setVisible(true);






    }
}

