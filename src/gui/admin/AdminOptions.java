package gui.admin;

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

public class AdminOptions {

    private JDialog adminOps;
    private JLabel nameLabel, surnameLabel, contactLabel, emailLabel, newPassLabel, repeatPassLabel, currPassLabel;
    private JTextField nameField, surnameField, contactField, emailField;
    private JPasswordField newPassField, repeatPassField, currPassField;
    private JButton cancelButton, okButton;
    private JPanel fieldsPanel, buttonsPanel;

    public AdminOptions(JFrame parent){

    // setup JDialog - border layout

        adminOps = new JDialog(parent, true);
        adminOps.setTitle("Administrator Options");
        adminOps.setLayout(new BorderLayout());
        adminOps.setSize(400, 315);
        adminOps.setResizable(false);
        adminOps.setLocationRelativeTo(null);
        adminOps.getContentPane().setBackground(new Color(98, 169, 221));  // there is really no point of this, it's hidden behind to panels (fieldsPanel, buttonsPanel)

    // fields panel - gridbag layout - center on JDialog

        fieldsPanel = new JPanel(new GridBagLayout());
        fieldsPanel.setBackground(new Color(98, 169, 221));

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Edit");
        fieldsPanel.setBorder(titled);

    // name
        nameLabel = new JLabel("Admin Name");
        fieldsPanel.add(nameLabel, getConstraints(0,0,1,1,0, GridBagConstraints.WEST));
        nameField = new JTextField();
        fieldsPanel.add(nameField, getConstraints(1,0,1,1,1, GridBagConstraints.CENTER));
    // surname
        surnameLabel = new JLabel("Admin Surname");
        fieldsPanel.add(surnameLabel, getConstraints(0,1,1,1,0, GridBagConstraints.WEST));
        surnameField = new JTextField(15);
        fieldsPanel.add(surnameField, getConstraints(1,1,1,1,1, GridBagConstraints.CENTER));
    // contact
        contactLabel = new JLabel("Admin Phone");
        fieldsPanel.add(contactLabel, getConstraints(0,2,1,1,0, GridBagConstraints.WEST));
        contactField = new JTextField(15);
        fieldsPanel.add(contactField, getConstraints(1,2,1,1,1, GridBagConstraints.CENTER));
    // email
        emailLabel = new JLabel("Admin Email");
        fieldsPanel.add(emailLabel, getConstraints(0,3,1,1,0, GridBagConstraints.WEST));
        emailField = new JTextField(15);
        fieldsPanel.add(emailField, getConstraints(1,3,1,1,1, GridBagConstraints.CENTER));
    // current pass
        currPassLabel = new JLabel("Current Password");
        fieldsPanel.add(currPassLabel, getConstraints(0,4,1,1,0, GridBagConstraints.WEST));
        currPassField = new JPasswordField(15);
        fieldsPanel.add(currPassField, getConstraints(1,4,1,1,1, GridBagConstraints.CENTER));
    // new password
        newPassLabel = new JLabel("New Password");
        fieldsPanel.add(newPassLabel, getConstraints(0,5,1,1,0, GridBagConstraints.WEST));
        newPassField = new JPasswordField(15);
        fieldsPanel.add(newPassField, getConstraints(1,5,1,1,1, GridBagConstraints.CENTER));
    // repeat new password
        repeatPassLabel = new JLabel("Repeat New Password");
        fieldsPanel.add(repeatPassLabel, getConstraints(0,6,1,1,0, GridBagConstraints.WEST));
        repeatPassField = new JPasswordField(15);
        fieldsPanel.add(repeatPassField, getConstraints(1,6,1,1,1, GridBagConstraints.CENTER));

        adminOps.add(fieldsPanel, BorderLayout.CENTER);

    // buttons panel - flow layout - south on JDialog

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonsPanel.setBackground(new Color(98, 169, 221));

        cancelButton = new JButton("Cancel");
        cancelButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        cancelButton.setPreferredSize(new Dimension(100, 30));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminOps.setVisible(false);
            }
        });
        buttonsPanel.add(cancelButton);

        okButton = new JButton("OK");
        okButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        okButton.setPreferredSize(new Dimension(100, 30));
        buttonsPanel.add(okButton);

        adminOps.add(buttonsPanel, BorderLayout.SOUTH);

    // turns the lights on

        adminOps.setVisible(true);
    }

    // return GridBagConstraints for GridBagLayout

   private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int weightxIn, int anchor) {
       GridBagConstraints c = new GridBagConstraints();
       c.insets = new Insets(5, 15, 5, 15);
       c.ipadx = 0;
       c.ipady = 0;
       c.gridx = gridx;
       c.gridy = gridy;
       c.gridwidth = gridwidth;
       c.gridheight = gridheight;
       c.weightx = weightxIn;
       c.weighty = 0;
       c.fill = GridBagConstraints.HORIZONTAL;
       c.anchor = anchor;
       return c;
    }
}