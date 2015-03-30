package gui.admin;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 17/03/2015)
*/

import gui.UIElements;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About implements ActionListener {

    private JDialog about;
    private JButton closeButton;
    private JLabel progNameLabel, versionNumLabel, devsLabel, devPic, thanksLabel;
    private JPanel northPanel, centerPanel, southPanel, mainBigPanel;
    private Border paddingBorder = BorderFactory.createEmptyBorder(20,50,50,20);  // set the border inside the grid to move details away from the edges

    public About(){

        // setup the jdialog
        about = new JDialog();
        about.setTitle("DGA Computers");
        about.getContentPane().setBackground(new Color(98, 169, 221));
        about.setLayout(new GridLayout());
        about.setSize(500, 400);
        about.setResizable(false);
        about.setLocationRelativeTo(null);
        about.getContentPane().setBounds(20,20,20,20);

        mainBigPanel = new JPanel(new BorderLayout());
        mainBigPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "About",2,2)); // set anonymous, titled, centered, etched border
        mainBigPanel.setBackground(new Color(98, 169, 221));

// NORTH PANEL

        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.setBorder(paddingBorder);

        devPic = new JLabel(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\128\\save.png"));
        northPanel.add(devPic);

        mainBigPanel.add(devPic, BorderLayout.NORTH);


// CENTER PANEL

        centerPanel = new JPanel(new GridLayout(4,1));
        centerPanel.setBackground(new Color(98, 169, 221));
        centerPanel.setBorder(paddingBorder);

        progNameLabel = new JLabel("Application Name: DGA Computers");
        centerPanel.add(progNameLabel);

        versionNumLabel = new JLabel("Application Version: 1.0b");
        centerPanel.add(versionNumLabel);

        devsLabel = new JLabel("Developed By: ");
        centerPanel.add(devsLabel);

        thanksLabel = new JLabel("Special Thanks To: ");
        centerPanel.add(thanksLabel);

        mainBigPanel.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(new Color(98, 169, 221));

        closeButton = new JButton("Close");
        closeButton.setIcon(new ImageIcon(UIElements.remove16));
        closeButton.setPreferredSize(new Dimension(100, 26));
        closeButton.addActionListener(this);

        southPanel.add(closeButton);
        mainBigPanel.add(southPanel, BorderLayout.SOUTH);

        about.add(mainBigPanel);

        // make about window visible
        about.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        about.dispose();
    }
}