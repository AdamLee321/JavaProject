package gui.employee;

import database.operations.EmployeeOperations;
import gui.admin.AdminMain;
import model.Employee;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class EmployeeMain {

    private JPanel empMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewOrdersButton, backButton;
    private JTextField searchField;
    private JComboBox empTypes;
    private JPanel northPanel, managePanel, searchPanel, southPanel, tablePanel;
    private JTable tblEmployee;
    private JScrollPane tblScroll;

    AdminMain am;  // declare for usage with JDialogs as parent
    EmployeeOperations eo;
    Employee e;

    String[] eempTypes = {"All", "Sales", "Management"};  // this just a placeholder, real info will be populated from DB

    public JPanel getEmployeeMain(){

    // setup the frame

        empMain = new JPanel();
        empMain.setLayout(new BorderLayout());
        //empMain.getContentPane().setBackground(new Color(98, 169, 221));

// north panel

        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //northPanel.setBackground(new Color(98, 169, 100));

    // manage employees panel

        managePanel = new JPanel(new FlowLayout());
        //managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Employees")); // set anonymous titled, etched border

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeAdd ea = new EmployeeAdd(am);
            }
        });
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 26));
        editButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeEdit ee = new EmployeeEdit(am);
            }
        });
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 26));
        deleteButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        managePanel.add(deleteButton);

        //northPanel.add(managePanel, getConstraints(0,0,1,1,0,0,1,GridBagConstraints.CENTER));
        northPanel.add(managePanel);

    // search employees panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Employees")); // set anonymous titled, etched border

        searchField = new JTextField(19);
        searchPanel.add(searchField);

        empTypes = new JComboBox(new DefaultComboBoxModel<String>(eempTypes));

        searchPanel.add(empTypes);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 26));
        searchButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        searchPanel.add(searchButton);

        // add all the above to northPanel
        northPanel.add(searchPanel);

        // add northPanel to main
        empMain.add(northPanel, BorderLayout.NORTH);

    // results table panel
        tablePanel = new JPanel(new FlowLayout());

        tblEmployee = new JTable();
       // DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}});
     //   String titles[] = {"Title 1", "Title 2", "Title 3", "Title 4"};
     //   tblEmployee.setModel(tblModel,titles[]);
//        tblScroll.setViewportView(tblEmployee);
                tablePanel.add(tblEmployee);

        empMain.add(tablePanel, BorderLayout.CENTER);

// south panel

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(new Color(98, 169, 221));

    // bottom buttons

        viewOrdersButton = new JButton("View Orders");
        viewOrdersButton.setPreferredSize(new Dimension(150, 26));
        viewOrdersButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        southPanel.add(viewOrdersButton);

        empMain.add(southPanel, BorderLayout.SOUTH);

    // return to AdminMain
        return empMain;
    }

    // return GridBagConstraints for GridBagLayout

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int weightxIn, int leftHorInsetIn, int rightHorInsetIn, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, leftHorInsetIn, 5, rightHorInsetIn);
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