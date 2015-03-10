package gui;

import database.operations.ReportOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class ReportEmployee extends JFrame implements ActionListener{

    public class ReportEmployee {

    private MainFrame mf;
    private JButton employee,year,month,week,okButton,members,product,sales;
    private JLabel jLabel1; //Graph
    private JPanel jPanel1; //Personnel Panel
    private JPanel jPanel2; //Calender
    private JPanel jPanel3; //Range
    private Connection conn;
    private ReportOperations ro;
    private JPanel mainPanel;
    private JTextField jTextField1;

    public JPanel getMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(98,168,221));
        return mainPanel;
    }

    /*public ReportEmployee(MainFrame mf, Connection conn, ReportOperations ro) {
        this.mf = mf;
        this.conn = conn;
        this.ro = ro;

    }*/

    public JPanel getjPanel1() {
        jPanel3 = new JPanel(new GridBagLayout());
        jPanel3.setBackground(new Color(98, 168, 221));

        employee = new JButton("Employee");
        employee.setVerticalTextPosition(SwingConstants.BOTTOM);
        employee.setHorizontalTextPosition(SwingConstants.CENTER);
        employee.addActionListener((ActionListener) this);

        members = new JButton("Members");
        members.setVerticalTextPosition(SwingConstants.BOTTOM);
        members.setHorizontalTextPosition(SwingConstants.CENTER);
        members.addActionListener((ActionListener) this);

        product = new JButton("Product");
        product.setVerticalTextPosition(SwingConstants.BOTTOM);
        product.setHorizontalTextPosition(SwingConstants.CENTER);
        product.addActionListener((ActionListener) this);

        sales = new JButton("Sales");
        sales.setVerticalTextPosition(SwingConstants.BOTTOM);
        sales.setHorizontalTextPosition(SwingConstants.CENTER);
        sales.addActionListener((ActionListener) this);

        //Need to add to grid bag constraints

        return jPanel1;
    }

    public JPanel getjPanel2() {
        jPanel2 = new JPanel(new GridBagLayout());
        jPanel2.setBackground(new Color(98, 168, 221));

        week = new JButton("Week");
        week.setVerticalTextPosition(SwingConstants.BOTTOM);
        week.setHorizontalTextPosition(SwingConstants.CENTER);
        week.addActionListener((ActionListener) this);

        month = new JButton("Month");
        month.setVerticalTextPosition(SwingConstants.BOTTOM);
        month.setHorizontalTextPosition(SwingConstants.CENTER);
        month.addActionListener((ActionListener) this);

        year = new JButton("Year");
        year.setVerticalTextPosition(SwingConstants.BOTTOM);
        year.setHorizontalTextPosition(SwingConstants.CENTER);
        year.addActionListener((ActionListener) this);

        //Need to add to grid bag constraints

        return jPanel2;
    }

    public JPanel getjPanel3() {
        jPanel1 = new JPanel(new GridBagLayout());
        jPanel1.setBackground(new Color(98, 168, 221));

        okButton = new JButton("Ok");
        okButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        okButton.setHorizontalTextPosition(SwingConstants.CENTER);
        okButton.addActionListener((ActionListener) this);

        jTextField1 = new JTextField();
        //

        //Need to add to grid bag constraints

        return jPanel3;
    }




    private void salesActionPerformed(ActionEvent e) {
        //Void for now
    }

    private void productActionPerformed(ActionEvent e) {
        //Void for now
    }

    private void membersActionPerformed(ActionEvent e) {
        //Void for now
    }
    private void okButtonActionPerformed(ActionEvent e) {
        //Void for now
    }

    private void weekActionPerformed(ActionEvent e) {
        //Void for now
    }

    private void monthActionPerformed(ActionEvent e) {
        //Void for now
    }

    private void yearActionPerformed(ActionEvent e) {
        //Void for now
    }

    public ReportEmployee(ReportOperations ro){

        this.ro = ro;
    }

}
