package gui.employee;

import gui.UIElements;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/03/2015)
*/

public class EmployeePreview implements ActionListener {

    private JDialog empPreview;
    private JLabel profilePictureLabel, emdIdLabel, empNameLabel, empAddress, empDOB, empEmailLabel, empUsernameLabel, empPasswordLabel, empPositionLabel, empSalaryLabel, empDeptIdLabel;
    private JButton backButton, printButton;
    private JPanel detailsPanel, topPanel, buttonsPanel;
    private Border paddingBorder;

    public EmployeePreview(JFrame parent){

    // setup the jdialog

        empPreview = new JDialog(parent, true);
        empPreview.setTitle("Employee");
        empPreview.setLayout(new BorderLayout());
        empPreview.setSize(260, 490);
        empPreview.setResizable(false);
        empPreview.setLocationRelativeTo(null);

    // setup top panel, which will hold the profile picture + all the details panel (grid) with a titled, etched border surrounding them

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(UIElements.getColour());
        topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Profile Preview",2,2)); // set anonymous titled, etched border, centered title

        // profile picture
        profilePictureLabel = new JLabel(new ImageIcon(UIElements.person128));
        topPanel.add(profilePictureLabel);

        // details panel, Grid
        detailsPanel = new JPanel(new GridLayout(10,1,0,10)); // rows, cols, hgap, vgap
        paddingBorder = BorderFactory.createEmptyBorder(0,20,0,20);  // set the border inside the grid to move details away from the edges
        detailsPanel.setBorder(paddingBorder);
        detailsPanel.setBackground(UIElements.getColour());

        emdIdLabel = new JLabel("1");
        detailsPanel.add(emdIdLabel);

        empNameLabel = new JLabel("John Smith");
        detailsPanel.add(empNameLabel);

        empDOB = new JLabel("31/08/1973");
        detailsPanel.add(empDOB);

        empEmailLabel = new JLabel("Email: j.smith@gmail.com");
        detailsPanel.add(empEmailLabel);

        empAddress = new JLabel("25, Belgard Road, Tallaght, Dublin");
        detailsPanel.add(empAddress);

        empUsernameLabel = new JLabel("j.smith1");
        detailsPanel.add(empUsernameLabel);

        empPasswordLabel = new JLabel("12345678");
        detailsPanel.add(empPasswordLabel);

        empPositionLabel = new JLabel("Sales");
        detailsPanel.add(empPositionLabel);

        empSalaryLabel = new JLabel("25000");
        detailsPanel.add(empSalaryLabel);

        empDeptIdLabel = new JLabel("Sales");
        detailsPanel.add(empDeptIdLabel);

        topPanel.add(detailsPanel);

        // add to main dialog
        empPreview.add(topPanel, BorderLayout.CENTER);

    // setup the buttons panel, which will be on the SOUTH of the empPreview's BorderLayout (below the etched border). Buttons panel will have a simple centered flow layout

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(UIElements.getColour());

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 26));
        backButton.setIcon(new ImageIcon(UIElements.save16));
        backButton.addActionListener(this);
        buttonsPanel.add(backButton);

        printButton = new JButton("Print");
        printButton.setPreferredSize(new Dimension(100, 26));
        printButton.setIcon(new ImageIcon(UIElements.print16));
        printButton.addActionListener(this);
        buttonsPanel.add(printButton);

        // add to main dialog
        empPreview.add(buttonsPanel, BorderLayout.SOUTH);

        empPreview.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(backButton)){
            empPreview.dispose();
        }
        else if (e.getSource().equals(printButton)){

        }
    }
}

