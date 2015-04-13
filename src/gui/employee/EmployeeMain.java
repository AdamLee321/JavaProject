package gui.employee;

import database.operations.EmployeeOperations;
import database.operations.ProductOperations;
import gui.Griddy;
import gui.UIElements;
import gui.admin.AdminMain;
import gui.product.ProductAddEdit;
import gui.product.ProductTableModel;
import model.Employee;
import model.Product;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.lang.String;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class EmployeeMain implements ActionListener, MouseListener {

    private JPanel empMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewSalesButton, backButton;
    private JTextField searchField;
    private JComboBox empTypes;
    private JPanel northPanel, managePanel, searchPanel, southPanel, centerPanel;
    private JTable tblEmployee;
    private JScrollPane tblScroll;

    private String textFieldTip = "type your search query...";

    private AdminMain am;  // declare for usage with JDialogs as parent
    private EmployeeOperations eo;
    private Employee e;

    private JTable employees;
    private EmployeeTableModel employeeTableModel;
    private int selectedRow = -1;
    private int selectedRowId = 0;

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
        addButton.setPreferredSize(new Dimension(100, 28));
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        addButton.addActionListener(this);
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 28));
        editButton.setIcon(new ImageIcon(UIElements.edit16));
        editButton.addActionListener(this);
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 28));
        deleteButton.setIcon(new ImageIcon(UIElements.delete16));
        deleteButton.addActionListener(this);
        managePanel.add(deleteButton);

        northPanel.add(managePanel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

    // search employees panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Employees")); // set anonymous titled, etched border

        searchField = new JTextField(19);
        searchField.setText(textFieldTip); // set initial text field search
        searchField.setForeground(Color.GRAY); // set initial colour to gray
        searchField.addMouseListener(this);
        searchPanel.add(searchField);

        empTypes = new JComboBox(new DefaultComboBoxModel<String>(eempTypes));
        empTypes.setPreferredSize(new Dimension(105,26)); // combo box resized to make all the components fit just perfectly!

        searchPanel.add(empTypes);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 28));
        searchButton.setIcon(new ImageIcon(UIElements.search16));
        searchPanel.add(searchButton);

        // add all the above to northPanel
        northPanel.add(searchPanel, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

        // add northPanel to main
        empMain.add(northPanel, BorderLayout.NORTH);

// CENTER PANEL - table panel

        centerPanel = new JPanel(new GridLayout());
        // results panel
        employeeTableModel = new EmployeeTableModel();
        employees = new JTable(employeeTableModel);
        employees.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        employees.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employees.addMouseListener(this);



        employees.getColumnModel().getColumn(0).setPreferredWidth(27);
        employees.getColumnModel().getColumn(1).setPreferredWidth(120);
        employees.getColumnModel().getColumn(2).setPreferredWidth(100);
        employees.getColumnModel().getColumn(3).setPreferredWidth(90);
        employees.getColumnModel().getColumn(4).setPreferredWidth(90);
        employees.getColumnModel().getColumn(6).setPreferredWidth(120);
        employees.getColumnModel().getColumn(7).setPreferredWidth(100);
        employees.getColumnModel().getColumn(8).setPreferredWidth(95);
//        employees.getColumnModel().getColumn(9).setPreferredWidth(40);

//                // Set the table width, depending upon the width of
//        // the columns
//        int tableWidth = 0;
//        int columnCount = employeeTableModel.columnModel.getColumnCount();
//        for (int i = 0; i < columnCount; i++) {
//            tableWidth += employeeTableModel.columnModel.getColumn(i).getPreferredWidth();
//            System.out.println(employeeTableModel.columnModel.getColumn(i).getPreferredWidth());
//        }

        JScrollPane scrollPane = new JScrollPane(employees);
        scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        //productTableModel.getAllProductsTable();
        refreshList();
        centerPanel.add(scrollPane);

        empMain.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(UIElements.getColour());

    // bottom buttons

        viewSalesButton = new JButton("View Sales History");
        viewSalesButton.setPreferredSize(new Dimension(200, 28));
        viewSalesButton.setIcon(new ImageIcon(UIElements.open16));
        viewSalesButton.addActionListener(this);
        southPanel.add(viewSalesButton);

        empMain.add(southPanel, BorderLayout.SOUTH);
        eo = new EmployeeOperations();
    // return to AdminMain
        return empMain;
    }

    public void refreshList(){
        employeeTableModel.emptyArray();
        employeeTableModel.getAllEmployeesTable();
    }

    // open the edit window (created a method because it's used in two places - mouse and action listener
    public void displayEdit() {
        Employee e = eo.getEmployeeOb(selectedRowId);
        new EmployeeAddEdit(am, 1, this, e);
    }

// BUTTON ACTIONS

    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        if(e.getSource().equals(searchField)){
            if (searchField.getText().equals(textFieldTip)) {
                searchField.setText("");
                searchField.setForeground(null); // reset colour to black
            }
            searchField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {}
                @Override
                public void focusLost(FocusEvent e) { // set the textFieldTip to be visible in text field on focus loss
                    if (searchField.getText().equals("")){
                        searchField.setText(textFieldTip);
                        searchField.setForeground(Color.GRAY);
                    }
                }
            });
        }else if (e.getSource().equals(employees)) {
            selectedRow = employees.getSelectedRow();
            System.out.println(selectedRow);
            selectedRowId = (Integer) employees.getValueAt(employees.getSelectedRow(), 0);
            System.out.println(selectedRowId);
            if (e.getClickCount() == 2) {
                displayEdit();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        // add button
        if (e.getSource().equals(viewSalesButton)){
            SalesHistory sv = new SalesHistory();
        }
        else if (e.getSource().equals(addButton)) {
            EmployeeAddEdit eae = new EmployeeAddEdit(am,0, this, null);
        } // edit button
        else {
            if (selectedRow == -1)
                JOptionPane.showMessageDialog(null, "Select an employee", "Employee not selected", JOptionPane.WARNING_MESSAGE);
            else {
                if (e.getSource().equals(editButton))// edit product
                    displayEdit();
                else if (e.getSource().equals(deleteButton)) {
                    Object[] options = {"Yes", "No"};
                    int choice = JOptionPane.showOptionDialog(empMain, "Are You Sure?", "Delete Employee", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null);
                    if (choice == 0) {
                        eo.deleteEmployee((Integer) employees.getValueAt(employees.getSelectedRow(), 0));
                        JOptionPane.showMessageDialog(empMain, "Employee Deleted");
                        selectedRow = -1;
                        refreshList();
                    }
                }
            }

        }
    }
}