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

    //Declaration
    private Button employee;
    private Button sales;
    private Button product;
    private Button members;
    private Button okButton;
    private Button week;
    private Button month;
    private Button year;
    private JLabel jLabel1; //Graph
    private JPanel jPanel1; //Personnel Panel
    private JPanel jPanel2; //Calender
    private JPanel jPanel3; //Range
    private ReportOperations ro;
    private JPanel mainPanel;
    private JTextField jTextField1;

    public JPanel getMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(98,168,221));
        return mainPanel;
    }

    public JPanel getjPanel1(){
        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(98,168,221));
        return jPanel1;
    }

    //Button Actions
    private void employeeActionPerformed(ActionEvent e) {
        //Void for now
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
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
