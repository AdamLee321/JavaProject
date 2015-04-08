package gui.admin;

import gui.FormValidator;
import gui.Griddy;
import gui.UIElements;
import model.Employee;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class AdminOptions implements ActionListener {

    private JDialog adminOps;
    private JLabel nameLabel, surnameLabel, contactLabel, usernameLabel, newPassLabel, repeatPassLabel, currPassLabel;
    private JTextField nameField, surnameField, contactField, usernameField;
    private JPasswordField newPassField, repeatPassField, currPassField;
    private JButton cancelButton, okButton, logButton;
    private JPanel mainPanel, buttonsPanel, adminNamePanel, adminUsernamePanel, adminPasswordPanel;
    private JFrame am;
    private Employee admin;

    public AdminOptions(JFrame parent, Employee admin) {

        this.admin = admin;

        // setup JDialog - border layout

        adminOps = new JDialog(parent, true);
        adminOps.setTitle("Administrator Options");
        adminOps.setLayout(new BorderLayout());
        adminOps.setSize(470, 400);
        adminOps.setResizable(true);
        adminOps.setLocationRelativeTo(null);
        adminOps.getContentPane().setBackground(UIElements.getColour());  // there is really no point of this, it's hidden behind to panels (mainPanel, buttonsPanel)

        // fields panel - gridbag layout - center on JDialog

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(UIElements.getColour());

//        Border etched = BorderFactory.createEtchedBorder();
//        Border titled = BorderFactory.createTitledBorder(etched, "Edit Details", 2, 2);
//        mainPanel.setBorder(titled);

// ADMIN NAME PANEL

        adminNamePanel = new JPanel(new GridBagLayout());
        adminNamePanel.setBackground(UIElements.getColour());
        adminNamePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "")); // set anonymous titled, etched border

        // name
        nameLabel = new JLabel("First Name");
        adminNamePanel.add(nameLabel, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        nameField = new JTextField();
        nameField.setText(admin.getEmpFName());
        adminNamePanel.add(nameField, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // surname
        surnameLabel = new JLabel("Last Name");
        adminNamePanel.add(surnameLabel, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        surnameField = new JTextField();
        adminNamePanel.add(surnameField, Griddy.getConstraints(1, 1, 1, 1, 0, 0, 0, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        surnameField.setText(admin.getEmpLName());

        mainPanel.add(adminNamePanel, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 1, 0, 5, 5, 5, 5, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

// ADMIN USER NAME

        adminUsernamePanel = new JPanel(new GridBagLayout());
        adminUsernamePanel.setBackground(UIElements.getColour());
        adminUsernamePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "")); // set anonymous titled, etched border

        // username
        usernameLabel = new JLabel("Username");
        adminUsernamePanel.add(usernameLabel, Griddy.getConstraints(0, 2, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        usernameField = new JTextField();
        usernameField.setText(admin.getEmpUsername());
        adminUsernamePanel.add(usernameField, Griddy.getConstraints(1, 2, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        mainPanel.add(adminUsernamePanel, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

// ADMIN PASSWORD

        adminPasswordPanel = new JPanel(new GridBagLayout());
        adminPasswordPanel.setBackground(UIElements.getColour());
        adminPasswordPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "")); // set anonymous titled, etched border

        // current pass
        currPassLabel = new JLabel("Current Password");
        adminPasswordPanel.add(currPassLabel, Griddy.getConstraints(0, 3, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        currPassField = new JPasswordField(15);
        adminPasswordPanel.add(currPassField, Griddy.getConstraints(1, 3, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // new password
        newPassLabel = new JLabel("New Password");
        adminPasswordPanel.add(newPassLabel, Griddy.getConstraints(0, 4, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        newPassField = new JPasswordField();
        adminPasswordPanel.add(newPassField, Griddy.getConstraints(1, 4, 1, 1, 0, 0, 0, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // repeat new password
        repeatPassLabel = new JLabel("Repeat New Password");
        adminPasswordPanel.add(repeatPassLabel, Griddy.getConstraints(0, 5, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        repeatPassField = new JPasswordField();
        adminPasswordPanel.add(repeatPassField, Griddy.getConstraints(1, 5, 1, 1, 0, 0, 0, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        mainPanel.add(adminPasswordPanel, Griddy.getConstraints(0, 2, 1, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // log button
        logButton = new JButton("View System Log");
        logButton.setIcon(new ImageIcon(UIElements.report16));
        logButton.setPreferredSize(new Dimension(50,40));
        logButton.addActionListener(this);
        mainPanel.add(logButton, Griddy.getConstraints(0,3,2,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // separator
        mainPanel.add(new JSeparator(), Griddy.getConstraints(0,4,2,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        adminOps.add(mainPanel, BorderLayout.CENTER);

        // buttons panel - flow layout - south on JDialog

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonsPanel.setBackground(UIElements.getColour());

        cancelButton = new JButton("Cancel");
        cancelButton.setIcon(new ImageIcon(UIElements.cancel6));
        cancelButton.setPreferredSize(new Dimension(100, 28));
        cancelButton.addActionListener(this);
        buttonsPanel.add(cancelButton);

        okButton = new JButton("OK");
        okButton.setIcon(new ImageIcon(UIElements.save16));
        okButton.setPreferredSize(new Dimension(100, 28));
        okButton.addActionListener(this);
        buttonsPanel.add(okButton);

        adminOps.add(buttonsPanel, BorderLayout.SOUTH);

        this.am = parent;
        // turns the lights on

        adminOps.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cancelButton)) {
            adminOps.dispose();
        } else if (e.getSource().equals(okButton)) {
            if (FormValidator.isEmptyField(nameField.getText())
                || FormValidator.isEmptyField(surnameField.getText())
                || FormValidator.isEmptyField(usernameField.getText())){
                JOptionPane.showMessageDialog(null, "Please Fill-In All Fields", "Empty Fields", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if (FormValidator.isNumber(nameField.getText()) && FormValidator.isNumber(surnameField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Data For Each Field", "Invalid Data", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else if (e.getSource().equals(logButton)){
            new Log(adminOps);
        }
    }
}