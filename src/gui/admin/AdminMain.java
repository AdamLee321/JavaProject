package gui.admin;

import gui.StartWindow;
import gui.UIElements;
import gui.employee.EmployeeMain;
import gui.member.MemberMain;
import gui.product.ProductMain;
import gui.sale.Discount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 10/03/2015)
*/

public class AdminMain extends JFrame implements ActionListener {

    private JFrame am;
    private JMenuBar menu;
    private JMenu fileMenu, manageMenu, helpMenu;
    private JMenuItem exitMI, logOutMI, empMI, memIM, prodMI, reportMI, optionsMI, helpMI, aboutMI;
    private JSeparator fileSep, manageSep1, manageSep2;
    private JLabel mainLogo;
    private JPanel outerNorth, outerSouth, outerCenter, innerNorth, innerCenter;
    private JButton empButton, memButton, prodButton, reportButton, optButton, logoutButton;

    private boolean displayarea = true;
    private EmployeeMain em;

    public AdminMain() {

        am = new JFrame();
        am.setTitle("DGA Administration");
        am.setSize(800, 700);
        am.setLocationRelativeTo(null);
        am.setResizable(false);
        am.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        am.setLayout(new BorderLayout());
        am.getContentPane().setBackground(UIElements.getColour());

        // add menu bar to the frame
        menu = new JMenuBar();
        am.setJMenuBar(menu);

        // file menu and its menu items
        fileMenu = new JMenu("File");
        menu.add(fileMenu);

        logOutMI = new JMenuItem("Log Out");
        logOutMI.setIcon(new ImageIcon(UIElements.logout16));
        fileMenu.add(logOutMI);
        logOutMI.addActionListener(this);

        fileSep = new JSeparator();
        fileMenu.add(fileSep);

        exitMI = new JMenuItem("Exit");
        exitMI.setIcon(new ImageIcon(UIElements.remove16));
        fileMenu.add(exitMI);
        exitMI.addActionListener(this);

        // manage menu and its menu items
        manageMenu = new JMenu("Manage");
        menu.add(manageMenu);

        empMI = new JMenuItem("Employees");
        empMI.setIcon(new ImageIcon(UIElements.person16));
        empMI.addActionListener(this);
        manageMenu.add(empMI);

        memIM = new JMenuItem("Members");
        memIM.setIcon(new ImageIcon(UIElements.person16));
        memIM.addActionListener(this);
        manageMenu.add(memIM);

        prodMI = new JMenuItem("Products");
        prodMI.setIcon(new ImageIcon(UIElements.product16));
        prodMI.addActionListener(this);
        manageMenu.add(prodMI);

        manageSep1 = new JSeparator();
        manageMenu.add(manageSep1);

        reportMI = new JMenuItem("Report");
        reportMI.setIcon(new ImageIcon(UIElements.report16));
        reportMI.addActionListener(this);
        manageMenu.add(reportMI);

        manageSep2 = new JSeparator();
        manageMenu.add(manageSep2);

        optionsMI = new JMenuItem("Options");
        optionsMI.setIcon(new ImageIcon(UIElements.info16));
        optionsMI.addActionListener(this);
        manageMenu.add(optionsMI);

        // help menu and its items
        helpMenu = new JMenu("Help");
        menu.add(helpMenu);

        helpMI = new JMenuItem("View Help");
        helpMI.setIcon(new ImageIcon(UIElements.info16));
        helpMI.addActionListener(this);
        helpMenu.add(helpMI);

        aboutMI = new JMenuItem("About");
        aboutMI.setIcon(new ImageIcon(UIElements.info16));
        aboutMI.addActionListener(this);
        helpMenu.add(aboutMI);

// OUTER NORTH - logo

        outerNorth = new JPanel(new GridBagLayout());
        outerNorth.setBackground(UIElements.getColour());
        mainLogo = new JLabel();
        mainLogo.setIcon(new ImageIcon(UIElements.banner));
        mainLogo.setBackground(UIElements.getColour());
        outerNorth.add(mainLogo);
        am.add(outerNorth, BorderLayout.NORTH);  // add to frame

// OUTER CENTER - buttons and interchangeable panels

        outerCenter = new JPanel(new BorderLayout());

        // INNER NORTH - buttons
        innerNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        innerNorth.setBackground(UIElements.getColour());
        innerNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "System Control")); // set anonymous titled, etched border);

        empButton = new JButton("Employees");
        empButton.setPreferredSize(new Dimension(150, 40));
        empButton.setIcon(new ImageIcon(UIElements.person32));
        empButton.addActionListener(this);
        innerNorth.add(empButton);

        memButton = new JButton("Members");
        memButton.setPreferredSize(new Dimension(150, 40));
        memButton.setIcon(new ImageIcon(UIElements.person32));
        memButton.addActionListener(this);
        innerNorth.add(memButton);

        prodButton = new JButton("Products");
        prodButton.setPreferredSize(new Dimension(150, 40));
        prodButton.setIcon(new ImageIcon(UIElements.product32));
        prodButton.addActionListener(this);
        innerNorth.add(prodButton);

        reportButton = new JButton("Report");
        reportButton.setPreferredSize(new Dimension(150, 40));
        reportButton.setIcon(new ImageIcon(UIElements.report32));
        reportButton.addActionListener(this);
        innerNorth.add(reportButton);

        optButton = new JButton("Options");
        optButton.setPreferredSize(new Dimension(150, 40));
        optButton.setIcon(new ImageIcon(UIElements.info32));
        optButton.addActionListener(this);
        innerNorth.add(optButton);

        outerCenter.add(innerNorth, BorderLayout.NORTH);

        // INNER CENTER - interchangeable panels
        innerCenter = new JPanel(new GridLayout());

        // starter panel - this appears by default when the program starts
        em = new EmployeeMain();  // have to do this (init EM twice) in order to set something visible when the program starts
        innerCenter.add(em.getEmployeeMain()); // get employee panel
        empButton.setForeground(Color.RED);

        outerCenter.add(innerCenter, BorderLayout.CENTER);
        am.add(outerCenter, BorderLayout.CENTER);  // add outer center to frame

// OUTER SOUTH

        outerSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outerSouth.setBackground(UIElements.getColour());
        outerSouth.setBorder(BorderFactory.createEtchedBorder()); // set anonymous titled, etched border);
        logoutButton = new JButton("Log Out");
        logoutButton.setIcon(new ImageIcon(UIElements.logout16));
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
            Soon sosoon = new Soon();
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
            StartWindow sw = new StartWindow();
            am.dispose();
        } // Exit menuItem
        else if (e.getSource().equals(exitMI)){
            System.exit(0);
        }
    }
}