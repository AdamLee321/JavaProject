package gui.terminal;/*2ndYearProject
  gui
  Created by David
  14:56   06/03/2015
*/

import database.operations.ProductOperations;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class MainFrame extends JFrame implements ActionListener {

  private ProductOperations po;
  public static MainFrame mf;
  private JLabel logoLabel;
  private JPanel centerPanel;
  private JPanel southPanel;
  private JPanel main;
  private JButton browse, search, help, home, back;
  private GridBagLayout bl;
  private boolean displayArea = false;


  public MainFrame(){
    po = new ProductOperations();

    this.setTitle("DGA Computers");
    this.setLayout(new BorderLayout());
    this.setSize(1000, 650);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(98, 169, 221));


    help = new JButton("HELP", new ImageIcon("src/res/images/UI Elements/help64.png"));
    help.addActionListener(this);

    home = new JButton("HOME", new ImageIcon("src/res/images/UI Elements/home64.png"));
    home.addActionListener(this);

    back = new JButton("BACK", new ImageIcon("src/res/images/UI Elements/backarrow64.png"));
    back.addActionListener(this);

    bl = new GridBagLayout();

    main = new JPanel(new BorderLayout());
    main.setMaximumSize(new Dimension(800,600));

    logoLabel = new JLabel(new ImageIcon("src/res/images/UI Elements/banner.png"));

    JPanel northPanel = new JPanel(new GridLayout(1, 1));
    northPanel.setBackground(new Color(98, 169, 221));
    northPanel.add(logoLabel);

    main.add(northPanel, BorderLayout.NORTH);
    main.add(getCenterPanel(), BorderLayout.CENTER);
    main.add(getMinSouthPanel(), BorderLayout.SOUTH);

    this.add(main, BorderLayout.CENTER);
    this.setVisible(true);
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

    displayArea = true;

    return centerPanel;
  }


  // South Panel with help button
  public JPanel getMinSouthPanel(){
    southPanel = new JPanel(bl);
    southPanel.setBackground(new Color(98, 169, 221));
    southPanel.add(help, getConstraints(0,0,1,1,GridBagConstraints.CENTER, 20,0,20,0));

    return southPanel;
  }


  //South Panel With back, home and help buttons
  public JPanel getFullSouthPanel(){
    southPanel = new JPanel(bl);
    southPanel.setBackground(new Color(98, 169, 221));
    southPanel.add(back, getConstraints(0,0,1,1,GridBagConstraints.WEST, 20,0,20,0));
    southPanel.add(home, getConstraints(1,0,1,1,GridBagConstraints.WEST, 20,150,20,150));
    southPanel.add(help, getConstraints(2,0,1,1,GridBagConstraints.EAST, 20,0,20,0));

    return southPanel;
  }

  //For setting the gridbagLayout constraints
  public static GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor,
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

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(search)){
      setToSearch();
    }
    else if(e.getSource().equals(browse)){
      setToBrowse();
    }
    else if(e.getSource().equals(home)){
      setToMain();
    }
    else if(e.getSource().equals(help)){
      //setToProductView();
    }
    else if(e.getSource().equals(back)){
    }
  }

  //To change the center pane to the search
  public void setToSearch(){
    ProductSearch c = new ProductSearch();
    removePanels();
    centerPanel = c.getSearch();
    southPanel = getFullSouthPanel();
    changePanels(centerPanel, southPanel);
  }


  //To change the center pane to the browse
  public void setToBrowse(){
    ProductCategories c = new ProductCategories(po);
    removePanels();
    centerPanel = c.getCategories();
    southPanel = getFullSouthPanel();
    changePanels(centerPanel, southPanel);
  }


  //To change the center pane to the home
  public void setToMain(){
    removePanels();
    centerPanel = getCenterPanel();
    southPanel = getMinSouthPanel();
    changePanels(centerPanel, southPanel);
  }

  //To change the center pane to the results of a product category picked
  public void setToProductResults(String category){
    ProductResults pr = new ProductResults();
    removePanels();
    try{
      centerPanel = pr.getResults(category, "");
    }catch(SQLException se){
      System.out.println(se);
    }

    southPanel = getFullSouthPanel();
    changePanels(centerPanel, southPanel);
  }

  //To change the center pane to the results of a product category picked
  public void setToProductResults(String category, String keyword){
    ProductResults pr = new ProductResults();
    removePanels();
    try{
      centerPanel = pr.getResults(category, keyword);
    }catch(SQLException se){
      System.out.println(se);
    }

    southPanel = getFullSouthPanel();
    changePanels(centerPanel, southPanel);
  }

  public void setToProductView(int productId){
    ProductView pv = new ProductView();
    Product p = po.productByID(productId);
    removePanels();
    centerPanel = pv.getProductView(p);
    southPanel = getFullSouthPanel();
    changePanels(centerPanel, southPanel);
  }

  public void changePanels(JPanel centerPanel, JPanel southPanel){
    main.add(centerPanel, BorderLayout.CENTER);
    main.add(southPanel, BorderLayout.SOUTH);
    displayArea = true;
    this.setVisible(true);
  }

  public void removePanels(){
    if(displayArea){
      main.remove(centerPanel);
      main.remove(southPanel);
    }
  }

  public static void setMf(MainFrame mf) {
    MainFrame.mf = mf;
  }


}
