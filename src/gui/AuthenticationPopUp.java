package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class AuthenticationPopUp {

    private JDialog auth;
    private JButton cancelButton, okButton;
    private JLabel usernameLabel, passwordLabel, imageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AuthenticationPopUp(JFrame parent) {

        auth = new JDialog(parent, true);
        auth.setTitle("Login");
        auth.setLayout(new GridBagLayout());
        auth.setSize(335, 140);
        auth.setResizable(false);
        auth.setLocationRelativeTo(null);
        auth.getContentPane().setBackground(new Color(98, 169, 221));

        imageLabel = new JLabel(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\64\\user.png"));
        auth.add(imageLabel, getConstraints(0,0,1,3, GridBagConstraints.CENTER));

        usernameLabel = new JLabel("Username");  // label
        auth.add(usernameLabel, getConstraints(1,0,1,1, GridBagConstraints.CENTER));
        usernameField = new JTextField(15);  // field
        auth.add(usernameField, getConstraints(2,0,3,1, GridBagConstraints.WEST));

        passwordLabel = new JLabel("Password");  // label
        auth.add(passwordLabel, getConstraints(1,1,1,1, GridBagConstraints.CENTER));
        passwordField = new JPasswordField(15);  // field
        auth.add(passwordField, getConstraints(2,1,3,1, GridBagConstraints.WEST));

        cancelButton = new JButton("Cancel");
        cancelButton.setToolTipText("Close Window");
        cancelButton.setPreferredSize(new Dimension(78,30));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auth.setVisible(false);
            }
        });
        auth.add(cancelButton, getConstraints(2,2,1,0, GridBagConstraints.CENTER));

        okButton = new JButton("OK");
        okButton.setToolTipText("Enter Your Credentials And Click OK");
        // if fields are empty and somebody clicks OK, then what?
        // mnemonics???
        okButton.setPreferredSize(new Dimension(78, 30));
        auth.add(okButton, getConstraints(3,2,1,0, GridBagConstraints.CENTER));

// turns the lights on

        auth.setVisible(true);
    }

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor)
    {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = anchor;
        return c;
    }
}