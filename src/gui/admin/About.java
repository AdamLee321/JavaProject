package gui.admin;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 17/03/2015)
*/

import gui.DataProcessor;
import gui.UIElements;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class About implements ActionListener {

    private JDialog about;
    private JButton btnClose;
    private JLabel lblInfo, lblPic;
    private JPanel pnlNorth, pnlCenter, pnlSouth, pnlCanvas;
    private Border paddingBorder = BorderFactory.createEmptyBorder(20,20,20,20);  // set the border inside the grid to move details away from the edges

    public About(){

        // setup the jdialog
        about = new JDialog();
        about.setTitle("DGA Computers");
        about.getContentPane().setBackground(UIElements.getColour());
        about.setLayout(new GridLayout());
        about.setMinimumSize(new Dimension(700, 450));
        about.setResizable(true);
        about.setLocationRelativeTo(null);
        about.getContentPane().setBounds(20,20,20,20);
        about.setModal(true);

        pnlCanvas = new JPanel(new BorderLayout());
        pnlCanvas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "About",2,2)); // set anonymous, titled, centered, etched border
        pnlCanvas.setBackground(UIElements.getColour());

// NORTH PANEL

        pnlNorth = new JPanel(new GridBagLayout());
        pnlNorth.setBackground(UIElements.getColour());
        pnlNorth.setBorder(paddingBorder);

        try {
            lblPic = new JLabel(new ImageIcon(DataProcessor.fitImageString(UIElements.ittLogo, 200, 200)));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image does not exist", "Image Error", JOptionPane.ERROR_MESSAGE);
        }
        pnlNorth.add(lblPic);

        pnlCanvas.add(pnlNorth, BorderLayout.WEST);

// CENTER PANEL

        pnlCenter = new JPanel(new GridLayout());
        pnlCenter.setBackground(UIElements.getColour());
        pnlCenter.setBorder(paddingBorder);

        lblInfo = new JLabel("<html>" +
                "<b>Application Name:</b> DGA Computers<br><br>" +
                "<b>Application Version:</b> 0.9b<br><br>" +
                "<b>Developed By:</b> Group 17 @ IT Tallaght<br><br>" +
                "<b>Tools Used:</b> IntelliJ IDE, Oracle Developer 11gEE, SQLDeveloper, Github<br><br>" +
                "<b>Date:</b> 2015, Semester 2<br><br>" +
                "<b>Notes:</b> This application was developed as a second year, group project for IT-Tallaght Computing course<br><br>" +
                "<b>Special Thanks To:</b> <br><br>" +
                "<ul><li>Our lecturers @ ITT</li><li>Stack Overflow community</li><li>YouTube community</li></ul>" +
                "</html>");
        pnlCenter.add(lblInfo);

        pnlCanvas.add(pnlCenter, BorderLayout.CENTER);

// SOUTH PANEL

        pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlSouth.setBackground(UIElements.getColour());

        btnClose = new JButton("Close");
        btnClose.setIcon(new ImageIcon(UIElements.remove16));
        btnClose.setPreferredSize(new Dimension(100, 28));
        btnClose.addActionListener(this);

        pnlSouth.add(btnClose);

        pnlCanvas.add(pnlSouth, BorderLayout.SOUTH);

        about.add(pnlCanvas);

        // make about window visible
        about.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        about.dispose();
    }
}