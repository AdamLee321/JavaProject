package gui;

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

public class MemberPreview {

    private JDialog memPreview;
    private JLabel profilePictureLabel, memberIdLabel, memberNameLabel, memberAddress, memberDOB, memberEmailLabel, memberPointsLabel;
    private JButton backButton, printButton;
    private JPanel detailsPanel, topPanel, buttonsPanel;
    private Border paddingBorder;

    public MemberPreview(JFrame parent){

    // setup the jdialog

        memPreview = new JDialog(parent, true);
        memPreview.setTitle("Member");
        memPreview.setLayout(new BorderLayout());
        memPreview.setSize(260, 400);
        memPreview.setResizable(false);
        memPreview.setLocationRelativeTo(null);

    // setup top panel, which will hold the profile picture + all the details panel (grid) with a titled, etched border surrounding them

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(new Color(98, 169, 221));
        topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Profile Preview",2,2)); // set anonymous titled, etched border, centered title

        // profile picture
        profilePictureLabel = new JLabel(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\128\\user.png"));
        topPanel.add(profilePictureLabel);

        // details panel, Grid
        detailsPanel = new JPanel(new GridLayout(6,1,0,10)); // rows, cols, hgap, vgap
        paddingBorder = BorderFactory.createEmptyBorder(0,20,0,20);  // set the border inside the grid to move details away from the edges
        detailsPanel.setBorder(paddingBorder);
        detailsPanel.setBackground(new Color(98, 169, 221));

        memberIdLabel = new JLabel("1");
        detailsPanel.add(memberIdLabel);

        memberNameLabel = new JLabel("John Smith");
        detailsPanel.add(memberNameLabel);

        memberDOB = new JLabel("31/08/1973");
        detailsPanel.add(memberDOB);

        memberEmailLabel = new JLabel("Email: j.smith@gmail.com");
        detailsPanel.add(memberEmailLabel);

        memberAddress = new JLabel("25, Belgard Road, Tallaght, Dublin");
        detailsPanel.add(memberAddress);

        memberPointsLabel = new JLabel("234 Points");
        detailsPanel.add(memberPointsLabel);

        topPanel.add(detailsPanel);

        // add to main dialog
        memPreview.add(topPanel, BorderLayout.CENTER);

    // setup the buttons panel, which will be on the SOUTH of the memPreview's BorderLayout (below the etched border). Buttons panel will have a simple centered flow layout

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(new Color(98, 169, 221));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 26));
        backButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memPreview.setVisible(false);
            }
        });
        buttonsPanel.add(backButton);

        printButton = new JButton("Print");
        printButton.setPreferredSize(new Dimension(100, 26));
        printButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        buttonsPanel.add(printButton);

        // add to main dialog
        memPreview.add(buttonsPanel, BorderLayout.SOUTH);

        memPreview.setVisible(true);
    }
}

