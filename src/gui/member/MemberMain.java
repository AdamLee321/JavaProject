package gui.member;

import database.operations.EmployeeOperations;
import gui.admin.AdminMain;
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

public class MemberMain implements ActionListener {

    private JPanel memberMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewOrdersButton;
    private JTextField searchField;
    private JPanel northPanel, managePanel, searchPanel, southPanel, centerPanel;

    AdminMain am;  // declare for usage with JDialogs as parent. No need to initialize
    EmployeeOperations eo;
    Employee e;

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
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        addButton.addActionListener(this);
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 26));
        editButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        editButton.addActionListener(this);
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 26));
        deleteButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        managePanel.add(deleteButton);

        northPanel.add(managePanel, getConstraints(0,0,1,1,1,0,0, GridBagConstraints.CENTER));

    // search members panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Members")); // set anonymous titled, etched border

        searchField = new JTextField(29);
        searchPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 26));
        searchButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        searchPanel.add(searchButton);

        // add all the above to northPanel
        northPanel.add(searchPanel, getConstraints(1,0,1,1,1,0,0,GridBagConstraints.CENTER));

        // add northPanel to main
        memberMain.add(northPanel, BorderLayout.NORTH);

// CENTER PANEL - results table panel
        centerPanel = new JPanel(new FlowLayout());


        memberMain.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(new Color(98, 169, 221));

    // bottom buttons

        viewOrdersButton = new JButton("View Orders");
        viewOrdersButton.setPreferredSize(new Dimension(150, 26));
        viewOrdersButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        southPanel.add(viewOrdersButton);

        memberMain.add(southPanel, BorderLayout.SOUTH);

    // return to AdminMain
        return memberMain;
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addButton)){
            MemberAdd ma = new MemberAdd(am);
        } // edit member
        else if (e.getSource().equals(editButton)){
            MemberEdit me = new MemberEdit(am);
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