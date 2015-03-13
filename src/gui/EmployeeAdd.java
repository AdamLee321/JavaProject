package gui;

import gui.DateGen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/03/2015)
*/

public class EmployeeAdd {

    private JDialog employeeAdd;
    private JPanel picturePanel, pictureButtonsPanel, detailsPanel, buttonsPanel;
    private JLabel profilePictureLabel, empIdLabel, empFNameLabel, empLNameLabel, empStreetLabel, empCityLabel, empCountyLabel, empDOB, empEmailLabel, empUsernameLabel, empPasswordLabel, empPositionLabel, empSalaryLabel, empDeptLabel;
    private JTextField empIdField, empFNameField, empLNameField, empStreetField, empCityField, empCountyField, empEmailField, empUsernameField, empPasswordField, empPositionField, empSalaryField, empDeptField;
    private JComboBox<String> birthDayCBox, birthMonthCBox, birthYearCBox;;
    private JButton addButton, removeButton, cancelButton, previewButton, okButton;

    DateGen dg;

    public EmployeeAdd(JFrame parent){

    // setup the jdialog

        employeeAdd = new JDialog(parent, true);
        employeeAdd.setTitle("Add New Employee");
        employeeAdd.setLayout(new BorderLayout());
        employeeAdd.setSize(450, 670);
        employeeAdd.setResizable(false);
        employeeAdd.setLocationRelativeTo(null);

    // picture panel + picture buttons  panel inside it

        picturePanel = new JPanel(new BorderLayout());
        picturePanel.setBackground(new Color(98, 169, 221));
        picturePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Profile Picture",2,2)); // set anonymous titled, etched border, centered title

        // profile picture
        profilePictureLabel = new JLabel(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\128\\user.png"));
        picturePanel.add(profilePictureLabel, BorderLayout.NORTH);

        // buttons panel
        pictureButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));  // alignment, hgap, vgap
        pictureButtonsPanel.setBackground(new Color(98, 169, 221));

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        pictureButtonsPanel.add(addButton);

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(100, 26));
        removeButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        pictureButtonsPanel.add(removeButton);

        picturePanel.add(pictureButtonsPanel, BorderLayout.SOUTH);

        // add picture panel to the main JDialog
        employeeAdd.add(picturePanel, BorderLayout.NORTH);

    // detailsPanel - GridBagLayout

        detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(new Color(98, 169, 221));

        // ID
        empIdLabel = new JLabel("Employee ID");
        detailsPanel.add(empIdLabel, getConstraints(0,0,1,1,0,15,5,GridBagConstraints.WEST));
        empIdField = new JTextField();
        detailsPanel.add(empIdField, getConstraints(1,0,1,1,1,15,15,GridBagConstraints.CENTER));

        // Name
        empFNameLabel = new JLabel("Employee Name");
        detailsPanel.add(empFNameLabel, getConstraints(0,1,1,1,0,15,5,GridBagConstraints.WEST));
        empFNameField = new JTextField();
        detailsPanel.add(empFNameField, getConstraints(1,1,1,1,1,15,15,GridBagConstraints.CENTER));

        // Surname
        empLNameLabel = new JLabel("Employee Surname");
        detailsPanel.add(empLNameLabel, getConstraints(0,2,1,1,0,15,5,GridBagConstraints.WEST));
        empLNameField = new JTextField();
        detailsPanel.add(empLNameField, getConstraints(1,2,1,1,1,15,15,GridBagConstraints.CENTER));

        // Email
        empEmailLabel = new JLabel("Employee Email");
        detailsPanel.add(empEmailLabel, getConstraints(0,3,1,1,0,15,5,GridBagConstraints.WEST));
        empEmailField = new JTextField();
        detailsPanel.add(empEmailField, getConstraints(1,3,1,1,1,15,15,GridBagConstraints.CENTER));

        // DOB
        dg = new DateGen();  // this needs DateGen class, to get correct days, months and years

        empDOB = new JLabel("Date Of Birth");
        detailsPanel.add(empDOB, getConstraints(0,4,1,1,0,15,5,GridBagConstraints.WEST));

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
        detailsPanel.add(birthYearCBox, getConstraints(1, 4, 1, 1, 0, 115, 125, GridBagConstraints.WEST));
        detailsPanel.add(birthMonthCBox, getConstraints(1, 4, 1, 1, 0, 60, 190, GridBagConstraints.WEST));
        detailsPanel.add(birthDayCBox, getConstraints(1, 4, 1, 1, 0, 15, 245, GridBagConstraints.WEST));

        // Street
        empStreetLabel = new JLabel("Employee Street");
        detailsPanel.add(empStreetLabel, getConstraints(0,5,1,1,0,15,5,GridBagConstraints.WEST));
        empStreetField = new JTextField();
        detailsPanel.add(empStreetField, getConstraints(1,5,1,1,1,15,15,GridBagConstraints.CENTER));

        // City
        empCityLabel = new JLabel("Employee City");
        detailsPanel.add(empCityLabel, getConstraints(0,6,1,1,0,15,5,GridBagConstraints.WEST));
        empCityField = new JTextField();
        detailsPanel.add(empCityField, getConstraints(1,6,1,1,1,15,15,GridBagConstraints.CENTER));

        // County
        empCountyLabel = new JLabel("Employee County");
        detailsPanel.add(empCountyLabel, getConstraints(0,7,1,1,0,15,5,GridBagConstraints.WEST));
        empCountyField = new JTextField();
        detailsPanel.add(empCountyField, getConstraints(1,7,1,1,1,15,15,GridBagConstraints.CENTER));

        // Username
        empUsernameLabel = new JLabel("Employee Username");
        detailsPanel.add(empUsernameLabel, getConstraints(0,8,1,1,0,15,5,GridBagConstraints.WEST));
        empUsernameField = new JTextField();
        detailsPanel.add(empUsernameField, getConstraints(1,8,1,1,1,15,15,GridBagConstraints.CENTER));

        // Password
        empPasswordLabel = new JLabel("Employee Password");
        detailsPanel.add(empPasswordLabel, getConstraints(0,9,1,1,0,15,5,GridBagConstraints.WEST));
        empPasswordField = new JTextField();
        detailsPanel.add(empPasswordField, getConstraints(1,9,1,1,1,15,15,GridBagConstraints.CENTER));

        // Position
        empPositionLabel = new JLabel("Employee Position");
        detailsPanel.add(empPositionLabel, getConstraints(0,10,1,1,0,15,5,GridBagConstraints.WEST));
        empPositionField = new JTextField();
        detailsPanel.add(empPositionField, getConstraints(1,10,1,1,1,15,15,GridBagConstraints.CENTER));

        // Salary
        empSalaryLabel = new JLabel("Employee Salary");
        detailsPanel.add(empSalaryLabel, getConstraints(0,11,1,1,0,15,5,GridBagConstraints.WEST));
        empSalaryField = new JTextField();
        detailsPanel.add(empSalaryField, getConstraints(1,11,1,1,1,15,15,GridBagConstraints.CENTER));

        // Department
        empDeptLabel = new JLabel("Employee Department");
        detailsPanel.add(empDeptLabel, getConstraints(0,12,1,1,0,15,5,GridBagConstraints.WEST));
        empDeptField = new JTextField();
        detailsPanel.add(empDeptField, getConstraints(1,12,1,1,1,15,15,GridBagConstraints.CENTER));

        employeeAdd.add(detailsPanel, BorderLayout.CENTER);

    // bottom, buttons panel - FlowLayout, added to main's South border

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));  // layout, horizontal padding, vertical padding
        buttonsPanel.setBackground(new Color(98, 169, 221));

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 26));
        cancelButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeAdd.setVisible(false);  // close the window, aka lights off
            }
        });
        buttonsPanel.add(cancelButton);

        previewButton = new JButton("Preview");
        previewButton.setPreferredSize(new Dimension(100, 26));
        previewButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        buttonsPanel.add(previewButton);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(100, 26));
        okButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        buttonsPanel.add(okButton);

        employeeAdd.add(buttonsPanel, BorderLayout.SOUTH);

// turns the lights on

        employeeAdd.setVisible(true);
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