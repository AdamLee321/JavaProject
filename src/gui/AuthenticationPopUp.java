package gui;

import database.operations.EmployeeOperations;
import gui.admin.AdminMain;
import gui.admin.Soon;
import gui.report.ReportEmployee;
import gui.sale.SaleMain;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
David Lawlor x00107563
*/

public class AuthenticationPopUp {

    private JDialog auth;
    private JButton cancelButton, okButton;
    private JLabel usernameLabel, passwordLabel, imageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private int count = 0;

    public AuthenticationPopUp(final JFrame parent) {

        auth = new JDialog(parent, true);
        auth.setTitle("Login");
        auth.setLayout(new GridBagLayout());
        auth.setSize(450, 200);
        auth.setResizable(false);
        auth.setLocationRelativeTo(null);
        auth.getContentPane().setBackground(UIElements.getColour());

        imageLabel = new JLabel(new ImageIcon(UIElements.person128));
        auth.add(imageLabel, Griddy.getConstraints(0,0,1,3,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        usernameLabel = new JLabel("Username");  // label
        usernameLabel.setFont(new Font("Calibri", 0, 18));
        auth.add(usernameLabel, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        usernameField = new JTextField(15);  // field
        usernameField.setPreferredSize(new Dimension(200,25));
        auth.add(usernameField, Griddy.getConstraints(2,0,3,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        passwordLabel = new JLabel("Password");  // label
        passwordLabel.setFont(new Font("Calibri",0, 18));
        auth.add(passwordLabel, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        passwordField = new JPasswordField(15);  // field
        passwordField.setPreferredSize(new Dimension(200, 25));
        auth.add(passwordField, Griddy.getConstraints(2,1,3,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        cancelButton = new JButton("Cancel");
        cancelButton.setToolTipText("Close Window");
        cancelButton.setPreferredSize(new Dimension(78,30));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auth.dispose();
            }
        });
        auth.add(cancelButton, Griddy.getConstraints(2,2,1,0,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordField.getPassword().length == 0 || usernameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(parent, "Please enter a username and a password", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    EmployeeOperations eo = new EmployeeOperations();
                    Employee em = eo.validatePassword(usernameField.getText(), passwordField.getPassword());
                    String position = em.getPosition();
                    if (!position.equals("")) {
                        if (position.equals("Sales"))
                            new SaleMain(em);
                        else if (position.equals("Admin"))
                            new AdminMain(em);
                        else if (position.equals("Manager"))
                            new ReportEmployee();
                        auth.dispose();
                        parent.dispose();
                    }
                    else if(count < 2) {
                        JOptionPane.showMessageDialog(parent, "Incorrect username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
                        count++;
                    } else{
                        new DennisNedry();
                        count = 0;
                    }
                    usernameField.setText("");
                    passwordField.setText("");
            }
        }});

        okButton.setToolTipText("Enter Your Credentials And Click OK");
        okButton.setPreferredSize(new Dimension(78, 30));
        auth.add(okButton, Griddy.getConstraints(3,2,1,0,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        auth.setVisible(true);
    }
}