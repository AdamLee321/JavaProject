package gui.admin;

import gui.StartWindow;
import gui.UIElements;
import gui.UIPrompts;
import gui.employee.EmployeeMain;
import gui.member.MemberMain;
import gui.product.ProductMain;
import gui.report.ManScreen;
import gui.report.ReportEmployee;
import model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 10/03/2015)
*/

public class AdminMain extends JFrame implements ActionListener {

    private JFrame am;
    private JMenuBar menu;
    private JMenu mFile, mManage, mHelp;
    private JMenuItem miExit, miLogOut, miEmployee, miMember, miProduct, miReport, miOptions, miHelp, miAbout, miSystemColour;
    private JLabel lblMainLogo;
    private JPanel pnlOuterNorth, pnlOuterSouth, pnlOuterCenter, pnlInnerNorth, pnlInnerCenter;
    private JButton btnEmployee, btnMember, btnProduct, btnReport, btnOptions, btnLogout;

    private boolean displayarea = true;
    private EmployeeMain em;
    private Employee admin;

    public AdminMain(Employee admin) {

        am = new JFrame();
        am.setTitle("DGA Administration");
        am.setSize(810, 700);
        am.setLocationRelativeTo(null);
        am.setResizable(false);
        am.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        am.setLayout(new BorderLayout());
        am.getContentPane().setBackground(UIElements.getColour());
        am.addWindowListener(new WindowAdapter() { // add window listener for when clicking X to close the window
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                UIPrompts.exitProgram();
            }
        });

        this.admin = admin;

        // add menu bar to the frame
        menu = new JMenuBar();
        am.setJMenuBar(menu);

        // file menu and its menu items
        mFile = new JMenu("File");
        menu.add(mFile);

        miLogOut = new JMenuItem("Log Out");
        miLogOut.setPreferredSize(new Dimension(120,25));
        miLogOut.setIcon(new ImageIcon(UIElements.logout16));
        mFile.add(miLogOut);
        miLogOut.addActionListener(this);

        mFile.add(new JSeparator()); // separator - anonymous object, because won't need to reference anywhere else

        miExit = new JMenuItem("Exit");
        miExit.setPreferredSize(new Dimension(0,25));
        miExit.setIcon(new ImageIcon(UIElements.remove16));
        mFile.add(miExit);
        miExit.addActionListener(this);

        // manage menu and its menu items
        mManage = new JMenu("Manage");
        menu.add(mManage);

        miEmployee = new JMenuItem("Employees");
        miEmployee.setPreferredSize(new Dimension(120,25)); // this menuItem controls the width (longest word) for all the rest of the menuItems in the Manage menu, so can set the rest to 0, does not matter anywya
        miEmployee.setIcon(new ImageIcon(UIElements.person16));
        miEmployee.addActionListener(this);
        mManage.add(miEmployee);

        miMember = new JMenuItem("Members");
        miMember.setPreferredSize(new Dimension(0,25));
        miMember.setIcon(new ImageIcon(UIElements.person16));
        miMember.addActionListener(this);
        mManage.add(miMember);

        miProduct = new JMenuItem("Products");
        miProduct.setPreferredSize(new Dimension(0,25));
        miProduct.setIcon(new ImageIcon(UIElements.product16));
        miProduct.addActionListener(this);
        mManage.add(miProduct);

        mManage.addSeparator(); // can do a separator this way

        miReport = new JMenuItem("Report");
        miReport.setPreferredSize(new Dimension(0,25));
        miReport.setIcon(new ImageIcon(UIElements.report16));
        miReport.addActionListener(this);
        mManage.add(miReport);

        mManage.add(new JSeparator()); // or this way

        miSystemColour = new JMenuItem("System Colour");
        miSystemColour.setPreferredSize(new Dimension(100,25));
        miSystemColour.setIcon(new ImageIcon(UIElements.info16));
        miSystemColour.addActionListener(this);
        mManage.add(miSystemColour);

        mManage.addSeparator();

        miOptions = new JMenuItem("Options");
        miOptions.setPreferredSize(new Dimension(100,25));
        miOptions.setIcon(new ImageIcon(UIElements.info16));
        miOptions.addActionListener(this);
        mManage.add(miOptions);

        // help menu and its items
        mHelp = new JMenu("Help");
//        mHelp.setPreferredSize(new Dimension(50,20));

        menu.add(mHelp);

        miHelp = new JMenuItem("View Help");
        miHelp.setPreferredSize(new Dimension(120,25));
        miHelp.setIcon(new ImageIcon(UIElements.info16));
        miHelp.addActionListener(this);
        mHelp.add(miHelp);

        mHelp.add(new JSeparator());

        miAbout = new JMenuItem("About");
        miAbout.setPreferredSize(new Dimension(120,25));
        miAbout.setIcon(new ImageIcon(UIElements.info16));
        miAbout.addActionListener(this);
        mHelp.add(miAbout);

// OUTER NORTH - logo

        pnlOuterNorth = new JPanel(new GridBagLayout());
        pnlOuterNorth.setBackground(Color.BLACK);
        lblMainLogo = new JLabel();
        lblMainLogo.setIcon(new ImageIcon(UIElements.banner));
        pnlOuterNorth.add(lblMainLogo);
        am.add(pnlOuterNorth, BorderLayout.NORTH);  // add to frame

// OUTER CENTER - buttons and interchangeable panels

        pnlOuterCenter = new JPanel(new BorderLayout());

        // INNER NORTH - buttons
        pnlInnerNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlInnerNorth.setBackground(UIElements.getColour());
        pnlInnerNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "System Control")); // set anonymous titled, etched border);

        btnEmployee = new JButton("Employees");
        btnEmployee.setPreferredSize(new Dimension(150, 40));
        btnEmployee.setIcon(new ImageIcon(UIElements.person32));
        btnEmployee.setToolTipText("View Employee Information");
        btnEmployee.addActionListener(this);
        pnlInnerNorth.add(btnEmployee);

        btnMember = new JButton("Members");
        btnMember.setPreferredSize(new Dimension(150, 40));
        btnMember.setIcon(new ImageIcon(UIElements.person32));
        btnMember.setToolTipText("View Member Information");
        btnMember.addActionListener(this);
        pnlInnerNorth.add(btnMember);

        btnProduct = new JButton("Products");
        btnProduct.setPreferredSize(new Dimension(150, 40));
        btnProduct.setIcon(new ImageIcon(UIElements.product32));
        btnProduct.setToolTipText("View Product Information");
        btnProduct.addActionListener(this);
        pnlInnerNorth.add(btnProduct);

        btnReport = new JButton("Report");
        btnReport.setPreferredSize(new Dimension(150, 40));
        btnReport.setIcon(new ImageIcon(UIElements.report32));
        btnReport.setToolTipText("View Reports");
        btnReport.addActionListener(this);
        pnlInnerNorth.add(btnReport);

        btnOptions = new JButton("Options");
        btnOptions.setPreferredSize(new Dimension(150, 40));
        btnOptions.setIcon(new ImageIcon(UIElements.info32));
        btnOptions.setToolTipText("View System Options");
        btnOptions.addActionListener(this);
        pnlInnerNorth.add(btnOptions);

        pnlOuterCenter.add(pnlInnerNorth, BorderLayout.NORTH);

        // INNER CENTER - interchangeable panels
        pnlInnerCenter = new JPanel(new GridLayout());

        // starter panel - this appears by default when the program starts
        em = new EmployeeMain();  // have to do this (init EM twice) in order to set something visible when the program starts
        pnlInnerCenter.add(em.getEmployeeMain()); // get employee panel
        btnEmployee.setForeground(Color.RED);

        pnlOuterCenter.add(pnlInnerCenter, BorderLayout.CENTER);
        am.add(pnlOuterCenter, BorderLayout.CENTER);  // add outer center to frame

// OUTER SOUTH

        pnlOuterSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlOuterSouth.setBackground(UIElements.getColour());
        pnlOuterSouth.setBorder(BorderFactory.createEtchedBorder()); // set anonymous titled, etched border);

        btnLogout = new JButton("Log Out");
        btnLogout.setPreferredSize(new Dimension(100,40));
        btnLogout.setIcon(new ImageIcon(UIElements.logout16));
        btnLogout.setToolTipText("Log Out Of The Administration Window");
        btnLogout.addActionListener(this);
        pnlOuterSouth.add(btnLogout);
        am.add(pnlOuterSouth, BorderLayout.SOUTH);  // add outer south to frame

        // switch the lights on
        am.setVisible(true);
    }

// METHODS

    // log out of the system (put this in a method because need to reuse (access) with the colour changing)
    public void logout(){
        am.dispose();
        new StartWindow();
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e) {
        // Employees Menu Item and Button ACTIONS
        if (e.getSource().equals(miEmployee) || e.getSource().equals(btnEmployee)) {
            em = new EmployeeMain();
            btnEmployee.setForeground(Color.RED);
            btnMember.setForeground(null);
            btnProduct.setForeground(null);
            if (displayarea) {
                pnlInnerCenter.removeAll();
            }
            pnlInnerCenter.add(em.getEmployeeMain());
            displayarea = true;
            am.setVisible(true);
        } // Member Menu Item and Button ACTIONS
        else if (e.getSource().equals(miMember) || e.getSource().equals(btnMember)) {
            MemberMain me = new MemberMain();
            btnEmployee.setForeground(null);
            btnMember.setForeground(Color.RED);
            btnProduct.setForeground(null);
            if (displayarea) {
                pnlInnerCenter.removeAll();
            }
            pnlInnerCenter.add(me.getMemberMain());
            displayarea = true;
            am.setVisible(true);
        } // Product Menu Item and Button ACTIONS
        else if (e.getSource().equals(miProduct) || e.getSource().equals(btnProduct)) {
            ProductMain pm = new ProductMain();
            btnEmployee.setForeground(null);
            btnMember.setForeground(null);
            btnProduct.setForeground(Color.RED);
            if (displayarea) {
                pnlInnerCenter.removeAll();
            }
            pnlInnerCenter.add(pm.getProductMain());
            displayarea = true;
            am.setVisible(true);
        } // Report Menu Item and Button ACTIONS
        else if (e.getSource().equals(miReport) || e.getSource().equals(btnReport)){
             new ManScreen();
        } // Options Menu Item and Button ACTIONS
        else if (e.getSource().equals(miOptions) || e.getSource().equals(btnOptions)){
            new AdminOptions(AdminMain.this, admin); // can also write AdminMain.this
        }
        else if (e.getSource().equals(miSystemColour)){
            UIPrompts.changeSystemColor(this);
        }
         // Help Button
        else if (e.getSource().equals(miHelp)){
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("src/res/AdminManual.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Cannot open file", "No supported application", JOptionPane.ERROR_MESSAGE);
                }
            }
        } // About Button
        else if (e.getSource().equals(miAbout)){
            new About();
        } // Logout Menu Item and Button ACTIONS
        else if (e.getSource().equals(miLogOut) || e.getSource().equals(btnLogout) ){
            logout();
        } // Exit menuItem
        else if (e.getSource().equals(miExit) || e.getSource().equals(WindowConstants.EXIT_ON_CLOSE)){
            UIPrompts.exitProgram();
        }
    }
}