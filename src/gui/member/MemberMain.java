package gui.member;

import database.operations.EmployeeOperations;
import gui.Griddy;
import gui.UIElements;
import gui.admin.AdminMain;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class MemberMain implements ActionListener {

    private JPanel memberMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewOrdersButton;
    private JTextField searchField;
    private JPanel northPanel, managePanel, searchPanel, southPanel, centerPanel;
    private JTable memTable;
    private MemberTableModel memTableModel;

    private AdminMain am;  // declare for usage with JDialogs as parent. No need to initialize
    private EmployeeOperations eo;
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
        managePanel.add(deleteButton);

        northPanel.add(managePanel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

    // search members panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Members")); // set anonymous titled, etched border

        searchField = new JTextField(29);
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

        memTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,"hello");
            }
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

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addButton)){
            MemberAddEdit mae = new MemberAddEdit(am,0,this);
        } // edit member
        else if (e.getSource().equals(editButton)){
            MemberAddEdit mae = new MemberAddEdit(am,1,this);
        }
        else if (e.getSource().equals(viewOrdersButton)){
            OrderView ov = new OrderView();
        }
    }
}