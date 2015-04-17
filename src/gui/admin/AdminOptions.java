package gui.admin;

import gui.FormValidator;
import gui.Griddy;
import gui.PasswordGenerator;
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
    private JLabel lblName, lblSurname, lblContact, lblUsername, lblPassword, lblRepeatpass, lblCurrentPassword;
    private JTextField tfName, tfSurname, tfContact, tfUsername;
    private JPasswordField pfNewPassword, pfRepeatPassword, pfCurrentPassword;
    private JButton btnCancel, btnOK, btnLog;
    private JPanel pnlMain, pnlButtons, pnlAdminName, pnlAdminUsername, pnlAdminPassword;
    private JFrame am;
    private Employee admin;

    public AdminOptions(JFrame parent, Employee admin) {

        this.admin = admin;

        // setup JDialog - border layout

        adminOps = new JDialog(parent, true);
        adminOps.setTitle("Administrator Options");
        adminOps.setLayout(new BorderLayout());
        adminOps.setSize(380, 400);
        adminOps.setResizable(true);
        adminOps.setLocationRelativeTo(null);
        adminOps.getContentPane().setBackground(UIElements.getColour());  // there is really no point of this, it's hidden behind to panels (pnlMain, pnlButtons)

        // fields panel - gridbag layout - center on JDialog

        pnlMain = new JPanel(new GridBagLayout());
        pnlMain.setBackground(UIElements.getColour());

//        Border etched = BorderFactory.createEtchedBorder();
//        Border titled = BorderFactory.createTitledBorder(etched, "Edit Details", 2, 2);
//        pnlMain.setBorder(titled);

// ADMIN NAME PANEL

        pnlAdminName = new JPanel(new GridBagLayout());
        pnlAdminName.setBackground(UIElements.getColour());
        pnlAdminName.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "")); // set anonymous titled, etched border

        // name
        lblName = new JLabel("First Name");
        pnlAdminName.add(lblName, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        tfName = new JTextField();
        tfName.setText(admin.getEmpFName());
        pnlAdminName.add(tfName, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // surname
        lblSurname = new JLabel("Last Name");
        pnlAdminName.add(lblSurname, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        tfSurname = new JTextField();
        pnlAdminName.add(tfSurname, Griddy.getConstraints(1, 1, 1, 1, 0, 0, 0, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        tfSurname.setText(admin.getEmpLName());

        pnlMain.add(pnlAdminName, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 1, 0, 5, 5, 5, 5, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

// ADMIN USER NAME

        pnlAdminUsername = new JPanel(new GridBagLayout());
        pnlAdminUsername.setBackground(UIElements.getColour());
        pnlAdminUsername.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "")); // set anonymous titled, etched border

        // username
        lblUsername = new JLabel("Username");
        pnlAdminUsername.add(lblUsername, Griddy.getConstraints(0, 2, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        tfUsername = new JTextField();
        tfUsername.setText(admin.getEmpUsername());
        pnlAdminUsername.add(tfUsername, Griddy.getConstraints(1, 2, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        pnlMain.add(pnlAdminUsername, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

// ADMIN PASSWORD

        pnlAdminPassword = new JPanel(new GridBagLayout());
        pnlAdminPassword.setBackground(UIElements.getColour());
        pnlAdminPassword.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "")); // set anonymous titled, etched border

        // current pass
        lblCurrentPassword = new JLabel("Current Password");
        pnlAdminPassword.add(lblCurrentPassword, Griddy.getConstraints(0, 3, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        pfCurrentPassword = new JPasswordField(15);
        pnlAdminPassword.add(pfCurrentPassword, Griddy.getConstraints(1, 3, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // new password
        lblPassword = new JLabel("New Password");
        pnlAdminPassword.add(lblPassword, Griddy.getConstraints(0, 4, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        pfNewPassword = new JPasswordField();
        pnlAdminPassword.add(pfNewPassword, Griddy.getConstraints(1, 4, 1, 1, 0, 0, 0, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // repeat new password
        lblRepeatpass = new JLabel("Repeat New Password");
        pnlAdminPassword.add(lblRepeatpass, Griddy.getConstraints(0, 5, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        pfRepeatPassword = new JPasswordField();
        pnlAdminPassword.add(pfRepeatPassword, Griddy.getConstraints(1, 5, 1, 1, 0, 0, 0, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        pnlMain.add(pnlAdminPassword, Griddy.getConstraints(0, 2, 1, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // log button
        btnLog = new JButton("View System Log");
        btnLog.setIcon(new ImageIcon(UIElements.report16));
        btnLog.setPreferredSize(new Dimension(50, 40));
        btnLog.addActionListener(this);
        pnlMain.add(btnLog, Griddy.getConstraints(0, 3, 2, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // separator
        pnlMain.add(new JSeparator(), Griddy.getConstraints(0, 4, 2, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        adminOps.add(pnlMain, BorderLayout.CENTER);

        // buttons panel - flow layout - south on JDialog

        pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        pnlButtons.setBackground(UIElements.getColour());

        btnCancel = new JButton("Cancel");
        btnCancel.setIcon(new ImageIcon(UIElements.cancel6));
        btnCancel.setPreferredSize(new Dimension(100, 28));
        btnCancel.addActionListener(this);
        pnlButtons.add(btnCancel);

        btnOK = new JButton("OK");
        btnOK.setIcon(new ImageIcon(UIElements.save16));
        btnOK.setPreferredSize(new Dimension(100, 28));
        btnOK.addActionListener(this);
        pnlButtons.add(btnOK);

        adminOps.add(pnlButtons, BorderLayout.SOUTH);

        this.am = parent;
        // turns the lights on

        adminOps.setVisible(true);
    }

// METHODS

    public boolean newPasswordsMatch() {
        if (new String(pfNewPassword.getPassword()).equals(new String(pfRepeatPassword.getPassword()))) {
            System.out.println("success!");
            return true;
        } else {
            return false;
        }
    }

    public boolean passwordValid() {
        String storedPass = admin.getEmpPassword();
        String matchPass = PasswordGenerator.hashPassword(new String(pfCurrentPassword.getPassword())); // have to use new String because a String is a character array and hashPassword requires a char array
        if (storedPass.equals(matchPass)) {
            System.out.println("true");
            return true;
        } else {
            return false;
        }
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnCancel))
            adminOps.dispose();
        else if (e.getSource().equals(btnLog))
            new Log(adminOps);
        else if (e.getSource().equals(btnOK)) {
            // change just the username. needs password
            if (!tfUsername.getText().equals(admin.getEmpUsername()) || !tfName.getText().equals(admin.getEmpFName()) || !tfSurname.getText().equals(admin.getEmpLName())) {
                if (FormValidator.isEmptyPassField(pfCurrentPassword.getPassword())) {
                    JOptionPane.showMessageDialog(null, "Enter the current password to save changes", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
//                } else if () {

//                }
                    if (FormValidator.isEmptyPassField(pfCurrentPassword.getPassword()) || FormValidator.isEmptyPassField(pfNewPassword.getPassword())) {
                        JOptionPane.showMessageDialog(null, "New password fields are empty", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
                        if (!newPasswordsMatch()) {
                            JOptionPane.showMessageDialog(null, "New passwords don't match", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            } else if (!passwordValid()) {
                JOptionPane.showMessageDialog(null, "Password does not match", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
            } else {
                adminOps.dispose();
            }
            if(e.getSource().equals(btnLog)) {
                new Log(adminOps);
            }
        }
    }
}