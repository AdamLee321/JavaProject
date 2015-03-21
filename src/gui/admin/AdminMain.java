package gui.admin;

import gui.Icons;
import gui.employee.EmployeeMain;
import gui.member.MemberMain;
import gui.product.ProductMain;
import javax.swing.BorderFactory;import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JDialog;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JMenu;import javax.swing.JMenuBar;import javax.swing.JMenuItem;import javax.swing.JPanel;import javax.swing.JSeparator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.lang.Override;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 10/03/2015)
*/

public class AdminMain extends JFrame implements ActionListener {

    JFrame am;
    JMenuBar menu;
    JMenu fileMenu, manageMenu, helpMenu;
    JMenuItem exitMI, logOutMI, empMI, memIM, prodMI, reportMI, optionsMI, helpMI, aboutMI;
    JSeparator fileSep, manageSep1, manageSep2;
    JLabel mainLogo;
    JPanel outerNorth, outerSouth, outerCenter, innerNorth, innerCenter;
    JButton empButton, memButton, prodButton, reportButton, optButton, logoutButton;

    private boolean displayarea = true;
    EmployeeMain em;

    public AdminMain() {

        am = new JFrame();
        am.setTitle("DGA Administration");
        am.setSize(800, 700);
        am.setLocationRelativeTo(null);
        //am.setResiable(false);
        am.setLayout(new BorderLayout());
        am.getContentPane().setBackground(new Color(98, 169, 221));

        // add menu bar to the frame
        menu = new JMenuBar();
        am.setJMenuBar(menu);

        // file menu and its menu items
        fileMenu = new JMenu("File");
        menu.add(fileMenu);

        logOutMI = new JMenuItem("Log Out");
        logOutMI.setIcon(new ImageIcon(Icons.logout16));
        fileMenu.add(logOutMI);
        logOutMI.addActionListener(this);

        fileSep = new JSeparator();
        fileMenu.add(fileSep);

        exitMI = new JMenuItem("Exit");
        exitMI.setIcon(new ImageIcon(Icons.remove16));
        fileMenu.add(exitMI);
        exitMI.addActionListener(this);

        // manage menu and its menu items
        manageMenu = new JMenu("Manage");
        menu.add(manageMenu);

        empMI = new JMenuItem("Employees");
        empMI.setIcon(new ImageIcon(Icons.person16));
        empMI.addActionListener(this);
        manageMenu.add(empMI);

        memIM = new JMenuItem("Members");
        memIM.setIcon(new ImageIcon(Icons.person16));
        memIM.addActionListener(this);
        manageMenu.add(memIM);

        prodMI = new JMenuItem("Products");
        prodMI.setIcon(new ImageIcon(Icons.product16));
        prodMI.addActionListener(this);
        manageMenu.add(prodMI);

        manageSep1 = new JSeparator();
        manageMenu.add(manageSep1);

        reportMI = new JMenuItem("Report");
        reportMI.setIcon(new ImageIcon(Icons.report16));
        reportMI.addActionListener(this);
        manageMenu.add(reportMI);

        manageSep2 = new JSeparator();
        manageMenu.add(manageSep2);

        optionsMI = new JMenuItem("Options");
        optionsMI.setIcon(new ImageIcon(Icons.info16));
        optionsMI.addActionListener(this);
        manageMenu.add(optionsMI);

        // help menu and its items
        helpMenu = new JMenu("Help");
        menu.add(helpMenu);

        helpMI = new JMenuItem("View Help");
        helpMI.addActionListener(this);
        helpMenu.add(helpMI);

        aboutMI = new JMenuItem("About");
        aboutMI.addActionListener(this);
        helpMenu.add(aboutMI);

// OUTER NORTH - logo

        outerNorth = new JPanel();
        outerNorth.setBackground(new Color(98, 169, 221));
        mainLogo = new JLabel();
        mainLogo.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\newBanner.png"));
        mainLogo.setBackground(new Color(98, 169, 221));
        outerNorth.add(mainLogo);
        am.add(outerNorth, BorderLayout.NORTH);  // add to frame

// OUTER CENTER - buttons and interchangeable panels

        outerCenter = new JPanel(new BorderLayout());

        // INNER NORTH - buttons
        innerNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerNorth.setBackground(new Color(98, 169, 221));
        innerNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "System Control")); // set anonymous titled, etched border);

        empButton = new JButton("Employees");
        empButton.setPreferredSize(new Dimension(150, 40));
        empButton.setIcon(new ImageIcon(Icons.person32));
        empButton.addActionListener(this);
        innerNorth.add(empButton);

        memButton = new JButton("Members");
        memButton.setPreferredSize(new Dimension(150, 40));
        memButton.setIcon(new ImageIcon(Icons.person32));
        memButton.addActionListener(this);
        innerNorth.add(memButton);

        prodButton = new JButton("Products");
        prodButton.setPreferredSize(new Dimension(150, 40));
        prodButton.setIcon(new ImageIcon(Icons.product32));
        prodButton.addActionListener(this);
        innerNorth.add(prodButton);

        reportButton = new JButton("Report");
        reportButton.setPreferredSize(new Dimension(150, 40));
        reportButton.setIcon(new ImageIcon(Icons.report32));
        innerNorth.add(reportButton);

        optButton = new JButton("Options");
        optButton.setPreferredSize(new Dimension(150, 40));
        optButton.setIcon(new ImageIcon(Icons.info32));
        optButton.addActionListener(this);
        innerNorth.add(optButton);

        outerCenter.add(innerNorth, BorderLayout.NORTH);

        // INNER CENTER - interchangeable panels
        innerCenter = new JPanel(new GridLayout());

        // starter panel - this appears by default when the program starts
        em = new EmployeeMain();  // have to do this (init EM twice) in order to set something visible when the program starts
        innerCenter.add(em.getEmployeeMain()); // get employee panel

        outerCenter.add(innerCenter, BorderLayout.CENTER);
        am.add(outerCenter, BorderLayout.CENTER);  // add outer center to frame

// OUTER SOUTH

        outerSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outerSouth.setBackground(new Color(98, 169, 221));
        outerSouth.setBorder(BorderFactory.createEtchedBorder()); // set anonymous titled, etched border);
        logoutButton = new JButton("Log Out");
        logoutButton.setIcon(new ImageIcon(Icons.logout16));
        logoutButton.addActionListener(this);
        outerSouth.add(logoutButton);
        am.add(outerSouth, BorderLayout.SOUTH);  // add outer south to frame

        // switch the lights on
        am.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        // Employees Menu Item and Button ACTIONS
        if (e.getSource().equals(empMI) || e.getSource().equals(empButton)) {
            em = new EmployeeMain();
            empButton.setForeground(Color.RED);
            memButton.setForeground(null);
            prodButton.setForeground(null);
            if (displayarea) {
                innerCenter.removeAll();
            }
            innerCenter.add(em.getEmployeeMain());
            displayarea = true;
            am.setVisible(true);
        } // Member Menu Item and Button ACTIONS
        else if (e.getSource().equals(memIM) || e.getSource().equals(memButton)) {
            MemberMain me = new MemberMain();
            empButton.setForeground(null);
            memButton.setForeground(Color.RED);
            prodButton.setForeground(null);
            if (displayarea) {
                innerCenter.removeAll();
            }
            innerCenter.add(me.getMemberMain());
            displayarea = true;
            am.setVisible(true);
        } // Product Menu Item and Button ACTIONS
        else if (e.getSource().equals(prodMI) || e.getSource().equals(prodButton)) {
            ProductMain pm = new ProductMain();
            empButton.setForeground(null);
            memButton.setForeground(null);
            prodButton.setForeground(Color.RED);
            if (displayarea) {
                innerCenter.removeAll();
            }
            innerCenter.add(pm.getProductMain());
            displayarea = true;
            am.setVisible(true);
        } // Report Menu Item and Button ACTIONS
        else if (e.getSource().equals(reportMI) || e.getSource().equals(reportButton)){
        } // Options Menu Item and Button ACTIONS
        else if (e.getSource().equals(optionsMI) || e.getSource().equals(optButton)){
            AdminOptions ao = new AdminOptions(AdminMain.this);
        } // Help Button
        else if (e.getSource().equals(helpMI)){

        } // About Button
        else if (e.getSource().equals(aboutMI)){
            About ab = new About();
        } // Logout Menu Item and Button ACTIONS
        else if (e.getSource().equals(logOutMI) || e.getSource().equals(logoutButton) ){
            am.dispose();
        } // Exit menuItem
        else if (e.getSource().equals(exitMI)){
            System.exit(0);
        }
    }
}