package gui.employee;

import database.operations.EmployeeOperations;
import gui.UIElements;
import gui.admin.AdminMain;
import model.Employee;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class EmployeeMain implements ActionListener {

    private JPanel empMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewSalesButton, backButton;
    private JTextField searchField;
    private JComboBox empTypes;
    private JPanel northPanel, managePanel, searchPanel, southPanel, centerPanel;
    private JTable tblEmployee;
    private JScrollPane tblScroll;

    AdminMain am;  // declare for usage with JDialogs as parent
    EmployeeOperations eo;
    Employee e;

    String[] eempTypes = {"All", "Sales", "Management"};  // this just a placeholder, real info will be populated from DB

    public JPanel getEmployeeMain(){

    // setup the frame

        empMain = new JPanel(new BorderLayout());
        //empMain.getContentPane().setBackground(new Color(98, 169, 221));

// NORTH PANEL

        northPanel = new JPanel(new GridBagLayout());
        //northPanel.setBackground(new Color(98, 169, 100));

    // manage employees panel

        managePanel = new JPanel(new FlowLayout());
        //managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Employees")); // set anonymous titled, etched border

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        addButton.addActionListener(this);
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 26));
        editButton.setIcon(new ImageIcon(UIElements.edit16));
        editButton.addActionListener(this);
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 26));
        deleteButton.setIcon(new ImageIcon(UIElements.delete16));
        managePanel.add(deleteButton);

        northPanel.add(managePanel, getConstraints(0,0,1,1,1,0,0, GridBagConstraints.CENTER));

    // search employees panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Employees")); // set anonymous titled, etched border

        searchField = new JTextField(19);
        searchPanel.add(searchField);

        empTypes = new JComboBox(new DefaultComboBoxModel<String>(eempTypes));

        searchPanel.add(empTypes);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 26));
        searchButton.setIcon(new ImageIcon(UIElements.search16));
        searchPanel.add(searchButton);

        // add all the above to northPanel
        northPanel.add(searchPanel, getConstraints(1,0,1,1,1,0,0,GridBagConstraints.CENTER));

        // add northPanel to main
        empMain.add(northPanel, BorderLayout.NORTH);

// CENTER PANEL - table panel

        centerPanel = new JPanel(new FlowLayout());

        tblEmployee = new JTable();
       // DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}});
     //   String titles[] = {"Title 1", "Title 2", "Title 3", "Title 4"};
     //   tblEmployee.setModel(tblModel,titles[]);
//        tblScroll.setViewportView(tblEmployee);
                centerPanel.add(tblEmployee);

        empMain.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(new Color(98, 169, 221));

    // bottom buttons

        viewSalesButton = new JButton("View Sales");
        viewSalesButton.setPreferredSize(new Dimension(150, 26));
        viewSalesButton.setIcon(new ImageIcon(UIElements.open16));
        viewSalesButton.addActionListener(this);
        southPanel.add(viewSalesButton);

        empMain.add(southPanel, BorderLayout.SOUTH);

    // return to AdminMain
        return empMain;
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        // add button
        if (e.getSource().equals(addButton)) {
            EmployeeAddEdit eae = new EmployeeAddEdit(am,0);
        } // edit button
        else if (e.getSource().equals(editButton)){
            EmployeeAddEdit eae = new EmployeeAddEdit(am,1);
        }
        else if (e.getSource().equals(viewSalesButton)){
            SalesView sv = new SalesView();
        }
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