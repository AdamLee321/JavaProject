package gui;/*2ndYearProject
  gui
  Created by David
  14:56   06/03/2015
  Software Development 3
*/

import database.operations.ProductOperations;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;


public class MainFrame extends JFrame implements ActionListener {

  private Connection conn;
  ProductOperations po;

  JLabel logoLabel;
  JPanel northPanel, centerPanel, southPanel, main;
  JButton browse, search,help;
  GridBagLayout bl;
  private boolean displayarea = false;


  public MainFrame(Connection conn){
    this.conn = conn;
    po = new ProductOperations(conn);

    this.setTitle("DGA Computers");
    //this.setLayout();
    this.setSize(1000, 650);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(98, 169, 221));


    help = new JButton("HELP", new ImageIcon("src/res/images/UI Elements/help64.png"));
    help.addActionListener(this);

    bl = new GridBagLayout();

    main = new JPanel(new BorderLayout());
    main.setMaximumSize(new Dimension(800,600));
    northPanel = new JPanel(new GridLayout(1,1));
    southPanel = new JPanel();

    logoLabel = new JLabel(new ImageIcon("src/res/images/UI Elements/banner.png"));

    northPanel.setBackground(new Color(98, 169, 221));
    northPanel.add(logoLabel);

    southPanel.setBackground(new Color(98, 169, 221));
    southPanel.add(help);


    main.add(northPanel, BorderLayout.NORTH);
    main.add(getCenterPanel(), BorderLayout.CENTER);
    main.add(southPanel, BorderLayout.SOUTH);

    this.add(main);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(search)){
      System.out.println("search");
      ProductSearch c = new ProductSearch(po);
      if(displayarea){
        main.remove(centerPanel);
      }
      centerPanel = c.getSearch();
      main.add(centerPanel, BorderLayout.CENTER);

      displayarea = true;
      centerPanel.setVisible(true);
      this.setVisible(true);
    }

    else if(e.getSource().equals(browse)){
      System.out.println("Browse");
      ProductCategories c = new ProductCategories();
      if(displayarea){
        main.remove(centerPanel);
      }
      centerPanel = c.getCategories();
      main.add(centerPanel, BorderLayout.CENTER);

      displayarea = true;
      centerPanel.setVisible(true);
      this.setVisible(true);
    }
    else if(e.getSource().equals(help)){
      System.out.println("help");
      ProductResults c = new ProductResults(po);
      if(displayarea){
        main.remove(centerPanel);
      }
      centerPanel = c.getResults("All");
      main.add(centerPanel, BorderLayout.CENTER);

      displayarea = true;
      centerPanel.setVisible(true);
      this.setVisible(true);
    }

  }

  public JPanel getCenterPanel(){
    centerPanel = new JPanel(bl);

    browse = new JButton(new ImageIcon("src/res/images/UI Elements/product150.png"));
    browse.addActionListener(this);

    search = new JButton(new ImageIcon("src/res/images/UI Elements/search150.png"));
    search.addActionListener(this);

    centerPanel.setBackground(new Color(98, 169, 221));
    centerPanel.add(browse, getConstraints(0,0,1,1, GridBagConstraints.WEST, 0,75,0,75));
    centerPanel.add(search, getConstraints(1,0,1,1, GridBagConstraints.EAST, 0,75,0,75));

    displayarea = true;

    return centerPanel;
  }

  private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                            int nIns, int wIns, int sIns, int eIns)
  {
    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(nIns, wIns, sIns, eIns);
    c.ipadx = 10;
    c.ipady = 10;
    c.gridx = gridx;
    c.gridy = gridy;
    c.gridwidth = gridwidth;
    c.gridheight = gridheight;
    c.anchor = anchor;
    return c;
  }
}
