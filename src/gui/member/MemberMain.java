package gui.member;

import database.operations.EmployeeOperations;
import database.operations.MemberOperations;
import gui.Griddy;
import gui.UIElements;
import gui.admin.AdminMain;
import model.Member;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class MemberMain implements ActionListener, MouseListener, KeyListener {

    private JPanel memberMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewOrdersButton;
    private JTextField searchField;
    private JPanel northPanel, managePanel, searchPanel, southPanel, centerPanel;
    private JTable memTable;
    private MemberTableModel memTableModel;
    private String textFieldTip = "type your search query...";
    private AdminMain am;  // declare for usage with JDialogs as parent. No need to initialize
    private EmployeeOperations eo;
    MemberOperations mo = new MemberOperations();
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
        searchField.addKeyListener(this);
        searchPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 28));
        searchButton.setIcon(new ImageIcon(UIElements.search16));
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);

        // add all the above to northPanel
        northPanel.add(searchPanel, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

        // add northPanel to main
        memberMain.add(northPanel, BorderLayout.NORTH);

// CENTER PANEL - results table panel

        memTableModel = new MemberTableModel();
        memTable = new JTable(memTableModel);
        displayMembers(); // this must come AFTER the above two lines
        memTable.setFillsViewportHeight(true); // fill out the height of the table
        memTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // don't allow multirow selection

        //        int tableWidth = 50;
//        int columnCount = memTableModel.columnModel.getColumnCount();
//        for (int i = 0; i < columnCount; i++)
//            tableWidth += memTableModel.columnModel.getColumn(i).getWidth();
        memTable.addMouseListener(this);



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

        viewOrdersButton = new JButton("View Purchase History");
        viewOrdersButton.setPreferredSize(new Dimension(200, 28));
        viewOrdersButton.setIcon(new ImageIcon(UIElements.open16));
        viewOrdersButton.addActionListener(this);
        southPanel.add(viewOrdersButton);

        memberMain.add(southPanel, BorderLayout.SOUTH);

    // return to AdminMain
        return memberMain;
    }

//  METHODS

    // display main members list (aka refresh the list)
    public void displayMembers(){

        memTableModel.emptyArray(); // clear object array (rows) so it does not keep duplicating entries to the table on every call
        memTableModel.getMainList();
        memTable.getColumnModel().getColumn(0).setPreferredWidth(10); // id // set width on columns of the JTable
        memTable.getColumnModel().getColumn(1).setPreferredWidth(50); // name // these widths have to be here because on every refresh the width resets to default
        memTable.getColumnModel().getColumn(2).setPreferredWidth(50); // surname
        memTable.getColumnModel().getColumn(3).setPreferredWidth(150); // street
        memTable.getColumnModel().getColumn(4).setPreferredWidth(50); // city
        memTable.getColumnModel().getColumn(5).setPreferredWidth(50); // county
        memTable.getColumnModel().getColumn(6).setPreferredWidth(150); // email
    }

    // open the edit window (created a method because it's used in two places - mouse and action listener
    public void displayEdit() {
        Member m = mo.getMemberById(row);
        if (row != 0) {
            new MemberAddEdit(am, 1, this, m);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select The Member First", "Member Not Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void searchMembers(){
        if (searchField.getText().equals(textFieldTip)){
//                JOptionPane.showMessageDialog(null,"Please Type In The The Search Query","Nothing Typed",JOptionPane.ERROR_MESSAGE);
            displayMembers();
        } else {
            memTableModel.emptyArray();
            memTableModel.searchMainList(searchField.getText());
        }
    }

// BUTTON ACTIONS

    // MOUSE
    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        if(e.getSource().equals(searchField)){ // search text tip actions
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
        else if (e.getSource().equals(memTable)){  // main table actions
            if (e.getClickCount() == 2) { // double click event
                displayEdit();
            }
            row = memTable.getSelectedRow()+1;
        }
    }

    // KEYBOARD

    // have to implement these methods for KeyboardListener
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
    
    public void keyReleased(KeyEvent e){
        if (e.getSource().equals(searchField)){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER) {
                searchMembers();
            }
        }
    }

    // ACTIONEVENT
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addButton)){
            MemberAddEdit mae = new MemberAddEdit(am,0,this,null);
        } // edit member
        else if (e.getSource().equals(editButton)) {
            displayEdit();
        }
        else if (e.getSource().equals(viewOrdersButton)){
            PurchaseHistory ov = new PurchaseHistory();
        }
        else if (e.getSource().equals(searchButton)){
            searchMembers();
        }
        else if (e.getSource().equals(deleteButton)){
            Object[] options = {"Yes","No"};
            memTable.getValueAt(row,2);
            int choice = JOptionPane.showOptionDialog(am, "Are You Sure You Want To Delete : " + memTable.getValueAt(row,1) + " " + memTable.getValueAt(row,2) + " ("+ memTable.getValueAt(row,0) +") ?", "Delete Member",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,options,null);
            if (choice == 0){
                mo.deleteMember(row);
                JOptionPane.showMessageDialog(am,"Member Deleted");
                displayMembers();
            }
        }
    }
}