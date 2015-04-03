package gui.member;

import database.operations.EmployeeOperations;
import database.operations.MemberOperations;
import gui.Griddy;
import gui.UIElements;
import gui.admin.AdminMain;
import model.Member;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TableModelEvent;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class MemberMain implements ActionListener, MouseListener {

    private JPanel memberMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewOrdersButton;
    private JTextField searchField;
    private JPanel northPanel, managePanel, searchPanel, southPanel, centerPanel;
    private JTable memTable;
    private MemberTableModel memTableModel;
    private String textFieldTip = "type your search query...";
    private AdminMain am;  // declare for usage with JDialogs as parent. No need to initialize
    private EmployeeOperations eo;
    private int row = 0;
  //  Employee e;

    public JPanel getMemberMain(){

    // setup the frame

        memberMain = new JPanel();
        memberMain.setLayout(new BorderLayout());
        //memberMain.getContentPane().setBackground(new Color(98, 169, 221));

// NORTH PANEL

        northPanel = new JPanel(new GridBagLayout());
        //northPanel.setBackground(new Color(98, 169, 100));

    // manage members panel

        managePanel = new JPanel(new FlowLayout());
        //managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Members")); // set anonymous titled, etched border

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

    // search members panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Members")); // set anonymous titled, etched border

        searchField = new JTextField(29);
        searchField.setText(textFieldTip); // set initial text field search
        searchField.setForeground(Color.GRAY); // set initial colour to gray
        searchField.addMouseListener(this);
        searchPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 28));
        searchButton.setIcon(new ImageIcon(UIElements.search16));
        searchPanel.add(searchButton);

        // add all the above to northPanel
        northPanel.add(searchPanel, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

        // add northPanel to main
        memberMain.add(northPanel, BorderLayout.NORTH);

// CENTER PANEL - results table panel
        memTableModel = new MemberTableModel();
        displayMembers();
        memTable = new JTable(memTableModel);
        memTable.addMouseListener(this);

        memTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) { // double click event
                    e.consume();
                    JOptionPane.showMessageDialog(null, "hello");
                }
            }
//            public void
        });
//        memTable.setRowHeight(50);

//        int tableWidth = 50;
//        int columnCount = memTableModel.columnModel.getColumnCount();
//        for (int i = 0; i < columnCount; i++)
//            tableWidth += memTableModel.columnModel.getColumn(i).getWidth();



//        memTable.setFillsViewportHeight(true); - fill out the height of the table

        JScrollPane scroll = new JScrollPane(memTable);
        scroll.setBorder(new BevelBorder(BevelBorder.LOWERED));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        centerPanel = new JPanel(new GridLayout());
        centerPanel.add(scroll);

        memberMain.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(UIElements.getColour());

    // bottom buttons

        viewOrdersButton = new JButton("View Orders");
        viewOrdersButton.setPreferredSize(new Dimension(150, 28));
        viewOrdersButton.setIcon(new ImageIcon(UIElements.open16));
        viewOrdersButton.addActionListener(this);
        southPanel.add(viewOrdersButton);

        memberMain.add(southPanel, BorderLayout.SOUTH);

    // return to AdminMain
        return memberMain;
    }

// DISPLAY MEMBER LIST

    public void displayMembers(){
        memTableModel.emptyArray(); // clear object array (rows) so it does not keep duplicating entries to the table on every call
        memTableModel.getMainList();
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
        }
        else if (e.getSource().equals(memTable)){
            row = memTable.getSelectedRow()+1;
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addButton)){
            MemberAddEdit mae = new MemberAddEdit(am,0,this,null);
        } // edit member
        else if (e.getSource().equals(editButton)){
            // search
            MemberOperations mo = new MemberOperations();
            Member m = mo.getMemberById(row);
            if (row != 0){
                new MemberAddEdit(am,1,this,m);
            }
            else {
                JOptionPane.showMessageDialog(null,"Please Select The Member First","Member Not Selected",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (e.getSource().equals(viewOrdersButton)){
            OrderView ov = new OrderView();
        }
        else if (e.getSource().equals(editButton)){

        }
        else if (e.getSource().equals(deleteButton)){
            Object[] options = {"Yes","No"};
            int choice = JOptionPane.showOptionDialog(am, "Are You Sure?", "Delete Member",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,options,null);
            if (choice == 0){

                JOptionPane.showMessageDialog(am,"Member Deleted");
            } else {

            }
        }
    }
}