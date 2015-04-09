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
    private JTextArea toolsUsed;
    private JPanel northPanel, centerPanel, southPanel, mainBigPanel;
    private Border paddingBorder = BorderFactory.createEmptyBorder(20,50,50,20);  // set the border inside the grid to move details away from the edges

    public About(){

        // setup the jdialog
        about = new JDialog();
        about.setTitle("DGA Computers");
        about.getContentPane().setBackground(UIElements.getColour());
        about.setLayout(new GridLayout());
        about.setSize(500, 400);
        about.setResizable(true);
        about.setLocationRelativeTo(null);
        about.getContentPane().setBounds(20,20,20,20);
        about.setModal(true);

        mainBigPanel = new JPanel(new BorderLayout());
        mainBigPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "About",2,2)); // set anonymous, titled, centered, etched border
        mainBigPanel.setBackground(UIElements.getColour());

// NORTH PANEL

        northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        northPanel.setBorder(paddingBorder);

        devPic = new JLabel(new ImageIcon(UIElements.person128));
        northPanel.add(devPic);

        mainBigPanel.add(devPic, BorderLayout.NORTH);

// CENTER PANEL

        centerPanel = new JPanel(new GridLayout(4,1));
        centerPanel.setBackground(UIElements.getColour());
        centerPanel.setBorder(paddingBorder);

        progNameLabel = new JLabel("Application Name: DGA Computers");
        centerPanel.add(progNameLabel);

        versionNumLabel = new JLabel("Application Version: 1.0b");
        centerPanel.add(versionNumLabel);

        devsLabel = new JLabel("Developed By: ");
        centerPanel.add(devsLabel);

//        thanksLabel = new JLabel("Thanks To: Our lecturers @ ITT, <\b> StackOverflow community, YouTube");
        thanksLabel = new JLabel("<html><p> <b>This text is bold</b>Some verrrry long text  Some verrrry long  Some verrrry long text dsa ads oiosi o</p>");
        centerPanel.add(thanksLabel);

        toolsUsed = new JTextArea("wefewfewfwe");
        toolsUsed.setEditable(false);
        toolsUsed.setOpaque(true);
        toolsUsed.setBackground(UIElements.getColour());
        centerPanel.add(toolsUsed);

        mainBigPanel.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(UIElements.getColour());

        closeButton = new JButton("Close");
        closeButton.setIcon(new ImageIcon(UIElements.remove16));
        closeButton.setPreferredSize(new Dimension(100, 28));
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