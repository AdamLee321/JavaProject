package gui.admin;

import database.operations.EmployeeOperations;
import gui.*;
import model.Employee;
import javax.swing.*;
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
    private JLabel lblName, lblSurname, lblUsername, lblPassword, lblRepeatpass, lblCurrentPassword;
    private JTextField tfName, tfSurname, tfUsername;
    private JPasswordField pfNewPassword, pfRepeatPassword, pfCurrentPassword;
    private JButton btnCancel, btnOK, btnLog, btnColour;
    private JPanel pnlMain, pnlButtons, pnlAdminName, pnlAdminUsername, pnlAdminPassword;
    private AdminMain am;
    private Employee currentAdmin;
    private EmployeeOperations eo;

    public AdminOptions(AdminMain parent, Employee admin) {

        am = parent;
        eo = new EmployeeOperations();
        this.currentAdmin = eo.getEmployeeOb(admin.getEmpId());

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
        tfName.setText(currentAdmin.getEmpFName());
        pnlAdminName.add(tfName, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // surname
        lblSurname = new JLabel("Last Name");
        pnlAdminName.add(lblSurname, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        tfSurname = new JTextField();
        pnlAdminName.add(tfSurname, Griddy.getConstraints(1, 1, 1, 1, 0, 0, 0, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));
        tfSurname.setText(currentAdmin.getEmpLName());

        pnlMain.add(pnlAdminName, Griddy.getConstraints(0, 0, 2, 1, 0, 0, 1, 0, 5, 5, 5, 5, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

// ADMIN USER NAME

        pnlAdminUsername = new JPanel(new GridBagLayout());
        pnlAdminUsername.setBackground(UIElements.getColour());
        pnlAdminUsername.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "")); // set anonymous titled, etched border

        // username
        lblUsername = new JLabel("Username");
        pnlAdminUsername.add(lblUsername, Griddy.getConstraints(0, 2, 1, 1, 0, 0, 0, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST));
        tfUsername = new JTextField();
        tfUsername.setText(currentAdmin.getEmpUsername());
        pnlAdminUsername.add(tfUsername, Griddy.getConstraints(1, 2, 1, 1, 0, 0, 1, 0, 5, 15, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        pnlMain.add(pnlAdminUsername, Griddy.getConstraints(0, 1, 2, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

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

        pnlMain.add(pnlAdminPassword, Griddy.getConstraints(0, 2, 2, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

// BUTTONS

        // log button
        btnLog = new JButton(" Log  ");
        btnLog.setIcon(new ImageIcon(UIElements.report16));
        btnLog.setPreferredSize(new Dimension(100, 40));
        btnLog.addActionListener(this);
        pnlMain.add(btnLog, Griddy.getConstraints(0, 3, 1, 1, 0, 0, 1, 0, 5, 15, 0, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        // colour button
        btnColour = new JButton("Colour");
        btnColour.setIcon(new ImageIcon(UIElements.edit16));
        btnColour.setPreferredSize(new Dimension(100, 40));
        btnColour.addActionListener(this);
        pnlMain.add(btnColour, Griddy.getConstraints(1, 3, 1, 1, 0, 0, 1, 0, 5, 0, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.EAST));

        // separator
        pnlMain.add(new JSeparator(), Griddy.getConstraints(0, 4, 2, 1, 0, 0, 0, 0, 5, 15, 15, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        adminOps.add(pnlMain, BorderLayout.CENTER);

// BOTTOM BUTTONS

        // flow layout - south on JDialog
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

    // check if new passwords match
    public boolean newPasswordsMatch() {
        return (new String(pfNewPassword.getPassword()).equals(new String(pfRepeatPassword.getPassword()))); // returns either true of false, shorter than if != return false, else return true
    }

    // check if what user enters in "Current Password" matches what's in the database, in other words check to see if the entered admin password is correct
    public void processPass() {

        String storedPass = currentAdmin.getEmpPassword();
        String matchPass = PasswordGenerator.hashPassword(new String(pfCurrentPassword.getPassword())); // have to use new String because a String is a character array and hashPassword requires a char array

        if (FormValidator.isEmptyPassField(pfCurrentPassword.getPassword())) {
            JOptionPane.showMessageDialog(null, "Enter the current password to save changes", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
        } else if (!storedPass.equals(matchPass)) {
            JOptionPane.showMessageDialog(null, "Password does not match", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String adminPass;
            if (FormValidator.isEmptyPassField(pfNewPassword.getPassword())){
                adminPass = currentAdmin.getEmpPassword();
            }
            else {
                currentAdmin.setEmpPassword(PasswordGenerator.hashPassword(new String(pfNewPassword.getPassword())));
                adminPass = PasswordGenerator.hashPassword(new String(pfNewPassword.getPassword()));
            }
            eo.updateAdmin(currentAdmin.getEmpId(), tfName.getText(), tfSurname.getText(), tfUsername.getText(), adminPass);
            JOptionPane.showMessageDialog(null, "Changes saved", "Admin information updated", JOptionPane.INFORMATION_MESSAGE);
            adminOps.dispose();
        }
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnCancel))
            adminOps.dispose();
        else if (e.getSource().equals(btnLog))
            new Log(adminOps);
        else if (e.getSource().equals(btnOK)) {
            if (tfUsername.getText().equals(currentAdmin.getEmpUsername()) && tfName.getText().equals(currentAdmin.getEmpFName()) && tfSurname.getText().equals(currentAdmin.getEmpLName()) && FormValidator.isEmptyPassField(pfNewPassword.getPassword()) && FormValidator.isEmptyPassField(pfRepeatPassword.getPassword())) {
                adminOps.dispose();
            } else {
                if (!tfUsername.getText().equals(currentAdmin.getEmpUsername()) || !tfName.getText().equals(currentAdmin.getEmpFName()) || !tfSurname.getText().equals(currentAdmin.getEmpLName())) {
                    if ((tfUsername.getText().length() > 0) && (tfName.getText().length() > 0) && (tfSurname.getText().length() > 0 )) {
                        if (FormValidator.isEmptyPassField(pfNewPassword.getPassword()) && FormValidator.isEmptyPassField(pfRepeatPassword.getPassword())) {
                            processPass();
                        } else {
                            if (newPasswordsMatch()) {
                                processPass();
                            } else {
                                JOptionPane.showMessageDialog(null, "Sorry, the new passwords don't match", "Invalid password", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Fields cannot be left empty", "Empty fields", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (tfUsername.getText().equals(currentAdmin.getEmpUsername()) && tfName.getText().equals(currentAdmin.getEmpFName()) && tfSurname.getText().equals(currentAdmin.getEmpLName()) || !FormValidator.isEmptyPassField(pfNewPassword.getPassword()) || !FormValidator.isEmptyPassField(pfRepeatPassword.getPassword())) {
                    if (newPasswordsMatch()) {
                        processPass();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry, the new passwords don't match", "Invalid password", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        else if (e.getSource().equals(btnLog)) {
            new Log(adminOps);
        }
        else if (e.getSource().equals(btnColour)){
            UIPrompts.changeSystemColor(am);
            adminOps.dispose();
        }
    }
}