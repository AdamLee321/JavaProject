package gui.admin;

import gui.Griddy;
import gui.UIElements;

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
    private JLabel nameLabel, surnameLabel, contactLabel, emailLabel, newPassLabel, repeatPassLabel, currPassLabel;
    private JTextField nameField, surnameField, contactField, emailField;
    private JPasswordField newPassField, repeatPassField, currPassField;
    private JButton cancelButton, okButton;
    private JPanel fieldsPanel, buttonsPanel;

    public AdminOptions(JFrame parent) {

        // setup JDialog - border layout

        adminOps = new JDialog(parent, true);
        adminOps.setTitle("Administrator Options");
        adminOps.setLayout(new BorderLayout());
        adminOps.setSize(400, 335);
        adminOps.setResizable(true);
        adminOps.setLocationRelativeTo(null);
        adminOps.getContentPane().setBackground(UIElements.getColour());  // there is really no point of this, it's hidden behind to panels (fieldsPanel, buttonsPanel)

        // fields panel - gridbag layout - center on JDialog

        fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBackground(UIElements.getColour());

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Edit");
        fieldsPanel.setBorder(titled);

        // name
        nameLabel = new JLabel("Admin Name");
        fieldsPanel.add(nameLabel, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        nameField = new JTextField();
        fieldsPanel.add(nameField, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        // surname
        surnameLabel = new JLabel("Admin Surname");
        fieldsPanel.add(surnameLabel, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        surnameField = new JTextField(15);
        fieldsPanel.add(surnameField, Griddy.getConstraints(1, 1, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        // contact
        contactLabel = new JLabel("Admin Phone");
        fieldsPanel.add(contactLabel, Griddy.getConstraints(0, 2, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        contactField = new JTextField(15);
        fieldsPanel.add(contactField, Griddy.getConstraints(1, 2, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        // email
        emailLabel = new JLabel("Admin Email");
        fieldsPanel.add(emailLabel, Griddy.getConstraints(0, 3, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        emailField = new JTextField(15);
        fieldsPanel.add(emailField, Griddy.getConstraints(1, 3, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        // current pass
        currPassLabel = new JLabel("Current Password");
        fieldsPanel.add(currPassLabel, Griddy.getConstraints(0, 4, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        currPassField = new JPasswordField(15);
        fieldsPanel.add(currPassField, Griddy.getConstraints(1, 4, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        // new password
        newPassLabel = new JLabel("New Password");
        fieldsPanel.add(newPassLabel, Griddy.getConstraints(0, 5, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        newPassField = new JPasswordField(15);
        fieldsPanel.add(newPassField, Griddy.getConstraints(1, 5, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        // repeat new password
        repeatPassLabel = new JLabel("Repeat New Password");
        fieldsPanel.add(repeatPassLabel, Griddy.getConstraints(0, 6, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        repeatPassField = new JPasswordField(15);
        fieldsPanel.add(repeatPassField, Griddy.getConstraints(1, 6, 1, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        adminOps.add(fieldsPanel, BorderLayout.CENTER);

        // buttons panel - flow layout - south on JDialog

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonsPanel.setBackground(UIElements.getColour());

        cancelButton = new JButton("Cancel");
        cancelButton.setIcon(new ImageIcon(UIElements.cancel6));
        cancelButton.setPreferredSize(new Dimension(100, 26));
        cancelButton.addActionListener(this);
        buttonsPanel.add(cancelButton);

        okButton = new JButton("OK");
        okButton.setIcon(new ImageIcon(UIElements.save16));
        okButton.setPreferredSize(new Dimension(100, 26));
        okButton.addActionListener(this);
        buttonsPanel.add(okButton);

        adminOps.add(buttonsPanel, BorderLayout.SOUTH);

        // turns the lights on

        adminOps.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(cancelButton)) {
            adminOps.dispose();
        } else if (e.getSource().equals(okButton)) {

        }
    }
}