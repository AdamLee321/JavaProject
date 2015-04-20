package gui;

import database.operations.EmployeeOperations;
import gui.admin.AdminMain;
import gui.report.ManScreen;
import gui.report.ReportEmployee;
import gui.sale.SaleMain;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
David Lawlor x00107563
*/

public class AuthenticationPopUp {

    private JDialog auth;
    private JButton btnCancel, btnOK;
    private JLabel lblUsername, lblPassword, lblImage;
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private int count = 0;

    public AuthenticationPopUp(final JFrame parent) {

        auth = new JDialog(parent, true);
        auth.setTitle("Login");
        auth.setLayout(new GridBagLayout());
        auth.setSize(450, 200);
        auth.setResizable(false);
        auth.setLocationRelativeTo(null);
        auth.getContentPane().setBackground(UIElements.getColour());

        lblImage = new JLabel(new ImageIcon(UIElements.person128));
        auth.add(lblImage, Griddy.getConstraints(0,0,1,3,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        lblUsername = new JLabel("Username");  // label
        lblUsername.setFont(new Font("Calibri", 0, 18));
        auth.add(lblUsername, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        tfUsername = new JTextField(15);  // field
        tfUsername.setPreferredSize(new Dimension(200,25));
        auth.add(tfUsername, Griddy.getConstraints(2,0,3,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        lblPassword = new JLabel("Password");  // label
        lblPassword.setFont(new Font("Calibri",0, 18));
        auth.add(lblPassword, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        pfPassword = new JPasswordField(15);  // field
        pfPassword.setPreferredSize(new Dimension(200, 25));
        auth.add(pfPassword, Griddy.getConstraints(2,1,3,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        btnCancel = new JButton("Cancel");
        btnCancel.setToolTipText("Close Window");
        btnCancel.setPreferredSize(new Dimension(78,30));
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auth.dispose();
            }
        });
        auth.add(btnCancel, Griddy.getConstraints(2,2,1,0,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pfPassword.getPassword().length == 0 || tfUsername.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(parent, "Please enter a username and a password", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    EmployeeOperations eo = new EmployeeOperations();
                    Employee em = eo.validatePassword(tfUsername.getText(), pfPassword.getPassword());
                    String position = em.getPosition();
                    if (!position.equals("")) {
                        if (position.equals("Sales"))
                            new SaleMain(em);
                        else if (position.equals("Admin"))
                            new AdminMain(em);
                        else if (position.equals("Manager"))
                            new ManScreen();
                        auth.dispose();
                        parent.dispose();
                    }
                    else if(count < 2) {
                        JOptionPane.showMessageDialog(parent, "Incorrect username or password", "ERROR", JOptionPane.ERROR_MESSAGE);
                        count++;
                    }
                    else{
                        new DennisNedry();
                        count = 0;
                    }
                    tfUsername.setText("");
                    pfPassword.setText("");
            }
        }});

        btnOK.setToolTipText("Enter Your Credentials And Click OK");
        btnOK.setPreferredSize(new Dimension(78, 30));
        auth.add(btnOK, Griddy.getConstraints(3,2,1,0,0,0,0,0,5,5,5,5,0,GridBagConstraints.CENTER));

        auth.setVisible(true);
    }
}