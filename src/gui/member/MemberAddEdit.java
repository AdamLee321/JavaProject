package gui.member;

import gui.DateGen;
import gui.UIElements;
import gui.admin.AdminMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/03/2015)
*/

public class MemberAddEdit {

    private JDialog memberAdd;
    private JPanel picturePanel, pictureButtonsPanel, detailsPanel, buttonsPanel;
    private JLabel profilePictureLabel, memberIdLabel, memberFNameLabel, memberLNameLabel, memberStreetLabel, memberCityLabel, memberCountyLabel, memberDOB, memberEmailLabel, memberPointsLabel;
    private JTextField memberIdField, memberFNameField, memberLNameField, memberStreetField, memberCityField, memberCountyField, memberEmailField, memberPointsField;
    private JComboBox<String> birthDayCBox, birthMonthCBox, birthYearCBox;;
    private JButton addButton, removeButton, cancelButton, previewButton, okButton;

    private DateGen dg;
    private AdminMain am;  // used for JDialogs as parent

    public MemberAddEdit(JFrame parent, int choice){

    // setup the jdialog

        memberAdd = new JDialog(parent, true);
        memberAdd.setTitle("Add New Member");
        memberAdd.setLayout(new BorderLayout());
        memberAdd.setSize(450, 560);
        memberAdd.setResizable(false);
        memberAdd.setLocationRelativeTo(null);

    // picture panel + picture buttons  panel inside it

        picturePanel = new JPanel(new BorderLayout());
        picturePanel.setBackground(new Color(98, 169, 221));
        picturePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Profile Picture",2,2)); // set anonymous titled, etched border, centered title

        // profile picture
        profilePictureLabel = new JLabel(new ImageIcon(UIElements.person128));
        picturePanel.add(profilePictureLabel, BorderLayout.NORTH);

        // buttons panel
        pictureButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));  // alignment, hgap, vgap
        pictureButtonsPanel.setBackground(new Color(98, 169, 221));

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        pictureButtonsPanel.add(addButton);

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(100, 26));
        removeButton.setIcon(new ImageIcon(UIElements.minus16));
        pictureButtonsPanel.add(removeButton);

        picturePanel.add(pictureButtonsPanel, BorderLayout.SOUTH);

        // add picture panel to the main JDialog
        memberAdd.add(picturePanel, BorderLayout.NORTH);

    // detailsPanel - GridBagLayout

        detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(new Color(98, 169, 221));

        // ID
        memberIdLabel = new JLabel("Member ID");
        detailsPanel.add(memberIdLabel, getConstraints(0,0,1,1,0,15,5,GridBagConstraints.WEST));
        memberIdField = new JTextField();
        detailsPanel.add(memberIdField, getConstraints(1,0,1,1,1,15,15,GridBagConstraints.CENTER));

        // Name
        memberFNameLabel = new JLabel("Member Name");
        detailsPanel.add(memberFNameLabel, getConstraints(0,1,1,1,0,15,5,GridBagConstraints.WEST));
        memberFNameField = new JTextField();
        detailsPanel.add(memberFNameField, getConstraints(1,1,1,1,1,15,15,GridBagConstraints.CENTER));

        // Surname
        memberLNameLabel = new JLabel("Member Surname");
        detailsPanel.add(memberLNameLabel, getConstraints(0,2,1,1,0,15,5,GridBagConstraints.WEST));
        memberLNameField = new JTextField();
        detailsPanel.add(memberLNameField, getConstraints(1,2,1,1,1,15,15,GridBagConstraints.CENTER));

        // Email
        memberEmailLabel = new JLabel("Member Email");
        detailsPanel.add(memberEmailLabel, getConstraints(0,3,1,1,0,15,5,GridBagConstraints.WEST));
        memberEmailField = new JTextField();
        detailsPanel.add(memberEmailField, getConstraints(1,3,1,1,1,15,15,GridBagConstraints.CENTER));

        // DOB

        dg = new DateGen();  // this needs DateGen class, to get correct days, months and years

        memberDOB = new JLabel("Date Of Birth");
        detailsPanel.add(memberDOB, getConstraints(0,4,1,1,0,15,5,GridBagConstraints.WEST));

        birthYearCBox = new JComboBox<String>(new DefaultComboBoxModel<String>(dg.getPastCentury()));
        // can either directly pass the parameters as displayed above, or do separately as displayed below
        // birthYearCBox = new JComboBox<String>()
        // birthYearCBox.setModel(new DefaultComboBoxModel<String>(dg.getPastCentury()));
        birthYearCBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                birthDayCBox.setModel(new DefaultComboBoxModel<String>(dg.getMonthDays(birthMonthCBox.getSelectedIndex() + 1, Integer.parseInt(birthYearCBox.getSelectedItem().toString()))));
            }
        });

        birthMonthCBox = new JComboBox<String>(new DefaultComboBoxModel<String>(dg.getMonths()));
        birthMonthCBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                birthDayCBox.setModel(new DefaultComboBoxModel<String>(dg.getMonthDays(birthMonthCBox.getSelectedIndex() + 1, Integer.parseInt(birthYearCBox.getSelectedItem().toString()))));
            }
        });

        birthDayCBox = new JComboBox<String>(dg.getMonthDays(birthMonthCBox.getSelectedIndex() + 1, Integer.parseInt(birthYearCBox.getSelectedItem().toString())));

            // add day, month, year comboboxes to details panel
        detailsPanel.add(birthYearCBox, getConstraints(1, 4, 1, 1, 0, 125, 140, GridBagConstraints.WEST));
        detailsPanel.add(birthMonthCBox, getConstraints(1, 4, 1, 1, 0, 65, 200, GridBagConstraints.WEST));
        detailsPanel.add(birthDayCBox, getConstraints(1, 4, 1, 1, 0, 15, 260, GridBagConstraints.WEST));

        // Street
        memberStreetLabel = new JLabel("Member Street");
        detailsPanel.add(memberStreetLabel, getConstraints(0,5,1,1,0,15,5,GridBagConstraints.WEST));
        memberStreetField = new JTextField();
        detailsPanel.add(memberStreetField, getConstraints(1,5,1,1,1,15,15,GridBagConstraints.CENTER));

        // City
        memberCityLabel = new JLabel("Member City");
        detailsPanel.add(memberCityLabel, getConstraints(0,6,1,1,0,15,5,GridBagConstraints.WEST));
        memberCityField = new JTextField();
        detailsPanel.add(memberCityField, getConstraints(1,6,1,1,1,15,15,GridBagConstraints.CENTER));

        // County
        memberCountyLabel = new JLabel("Member County");
        detailsPanel.add(memberCountyLabel, getConstraints(0,7,1,1,0,15,5,GridBagConstraints.WEST));
        memberCountyField = new JTextField();
        detailsPanel.add(memberCountyField, getConstraints(1,7,1,1,1,15,15,GridBagConstraints.CENTER));

        // Points
        memberPointsLabel = new JLabel("Member Points");
        detailsPanel.add(memberPointsLabel, getConstraints(0,8,1,1,0,15,5,GridBagConstraints.WEST));
        memberPointsField = new JTextField();
        detailsPanel.add(memberPointsField, getConstraints(1,8,1,1,1,15,15,GridBagConstraints.CENTER));

        memberAdd.add(detailsPanel, BorderLayout.CENTER);

    // bottom, buttons panel - FlowLayout, added to main's South border

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));  // layout, horizontal padding, vertical padding
        buttonsPanel.setBackground(new Color(98, 169, 221));

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 26));
        cancelButton.setIcon(new ImageIcon(UIElements.cancel6));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberAdd.setVisible(false);  // close the window, aka lights off
            }
        });
        buttonsPanel.add(cancelButton);

        previewButton = new JButton("Preview");
        previewButton.setPreferredSize(new Dimension(100, 26));
        previewButton.setIcon(new ImageIcon(UIElements.person16));
        previewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberPreview mp = new MemberPreview(am);
            }
        });
        buttonsPanel.add(previewButton);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(100, 26));
        okButton.setIcon(new ImageIcon(UIElements.save16));
        buttonsPanel.add(okButton);

        memberAdd.add(buttonsPanel, BorderLayout.SOUTH);

        // choice - add(clean fields) or edit(populate fields (1))
        if (choice == 1) {
            memberFNameField.setText("Luigi");
            memberCityField.setText("Mario Land");
        }

// turns the lights on

        memberAdd.setVisible(true);
    }

    // return GridBagConstraints for GridBagLayout

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int weightxIn, int leftHorInsetIn, int rightHorInsetIn, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, leftHorInsetIn, 5, rightHorInsetIn);  // horInsets are parameters to control individual indents of components
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