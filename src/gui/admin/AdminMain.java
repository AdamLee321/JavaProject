package gui.admin;

import gui.employee.EmployeeMain;
import gui.member.MemberMain;
import gui.product.ProductMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 10/03/2015)
*/

public class AdminMain extends JFrame {

    JFrame am;
    JMenuBar menu;
    JMenu fileMenu, manageMenu, helpMenu;
    JMenuItem exitMI, logOutMI, empMI, memIM, prodMI, reportMI, optionsMI, helpMI, aboutMI;
    JSeparator fileSep, manageSep1, manageSep2;
    JLabel mainLogo;
    JPanel outerNorth, outerSouth, outerCenter, innerNorth, dynCenter;
    JButton empButton, memButton, prodButton, reportButton, optButton, logoutButton;

    private boolean displayarea = false;
    private static JPanel currentdisplayPanel;

    public AdminMain() {

        am = new JFrame();
        am.setTitle("Administration");
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
        fileMenu.add(logOutMI);

        fileSep = new JSeparator();
        fileMenu.add(fileSep);

        exitMI = new JMenuItem("Exit");
        fileMenu.add(exitMI);
        exitMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                am.setVisible(false);
            }
        });

        // manage menu and its menu items
        manageMenu = new JMenu("Manage");
        menu.add(manageMenu);

        empMI = new JMenuItem("Employees");
        manageMenu.add(empMI);
        empMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeMain em = new EmployeeMain();
                dynCenter = em.getEmployeeMain();
                dynCenter.setBackground(Color.GRAY);
                outerCenter.add(dynCenter, BorderLayout.CENTER);
                am.add(outerCenter, BorderLayout.CENTER);
                am.setVisible(true);
                displayarea = true;
            }
        });

        memIM = new JMenuItem("Members");
        manageMenu.add(memIM);

        prodMI = new JMenuItem("Products");
        manageMenu.add(prodMI);

        manageSep1 = new JSeparator();
        manageMenu.add(manageSep1);

        reportMI = new JMenuItem("Report");
        manageMenu.add(reportMI);

        manageSep2 = new JSeparator();
        manageMenu.add(manageSep2);

        optionsMI = new JMenuItem("Options");
        manageMenu.add(optionsMI);

        // help menu and its items
        helpMenu = new JMenu("Help");
        menu.add(helpMenu);

        helpMI = new JMenuItem("View Help");
        helpMenu.add(helpMI);

        aboutMI = new JMenuItem("About");
        helpMenu.add(aboutMI);

        // OUTER NORTH - logo
        outerNorth = new JPanel();
        outerNorth.setBackground(new Color(98, 169, 221));
        mainLogo = new JLabel();
        mainLogo.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\newBanner.png"));
        //mainLogo.setVerticalAlignment(SwingConstants.TOP);
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
        empButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\32\\save.png"));
        empButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeMain em = new EmployeeMain();
                dynCenter = em.getEmployeeMain();
                dynCenter.setBackground(Color.GRAY);
                outerCenter.add(dynCenter, BorderLayout.CENTER);
                am.add(outerCenter, BorderLayout.CENTER);
                am.setVisible(true);
                if (displayarea){
                    currentdisplayPanel.remove(dynCenter);
                    displayarea = true;
                    currentdisplayPanel = dynCenter;
                }
            }
        });
        innerNorth.add(empButton);

        memButton = new JButton("Members");
        memButton.setPreferredSize(new Dimension(150, 40));
        memButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\32\\save.png"));
        memButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberMain mm = new MemberMain(AdminMain.this);
                JDialog md = mm.getMemberMain();
                md.setVisible(true);
            }
        });

        innerNorth.add(memButton);

        prodButton = new JButton("Products");
        prodButton.setPreferredSize(new Dimension(150, 40));
        prodButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\32\\save.png"));
        prodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductMain pm = new ProductMain();
                dynCenter = pm.getProductMain();
                dynCenter.setBackground(Color.GRAY);
                outerCenter.add(dynCenter, BorderLayout.CENTER);
                am.add(outerCenter, BorderLayout.CENTER);
                am.setVisible(true);
                if (displayarea){
                    currentdisplayPanel.remove(dynCenter);
                    displayarea = true;
                    currentdisplayPanel = dynCenter;
                }
            }
        });
        innerNorth.add(prodButton);

        reportButton = new JButton("Report");
        reportButton.setPreferredSize(new Dimension(150, 40));
        reportButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\32\\save.png"));
        innerNorth.add(reportButton);

        optButton = new JButton("Options");
        optButton.setPreferredSize(new Dimension(150, 40));
        optButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\32\\save.png"));
        optButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminOptions ao = new AdminOptions(AdminMain.this);
            }
        });
        innerNorth.add(optButton);

        outerCenter.add(innerNorth, BorderLayout.NORTH);

        am.add(outerCenter, BorderLayout.CENTER);  // add to frame

        // OUTER SOUTH

        outerSouth = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outerSouth.setBackground(new Color(98, 169, 221));
        outerSouth.setBorder(BorderFactory.createEtchedBorder()); // set anonymous titled, etched border);
        logoutButton = new JButton("Log Out");
        outerSouth.add(logoutButton);
        am.add(outerSouth, BorderLayout.SOUTH);

        am.setVisible(true);
    }

// needs button.addActionListener(this);{

    }
/*
            } else if (e.getSource().equals(memButton)) {
                MembersMain mm = new MemberMain();

                if (displayarea) {
                    currentdisplayPanel.removeAll();
                    displayarea = true;
                    currentdisplayPanel = addPanel;
                }
            }*/