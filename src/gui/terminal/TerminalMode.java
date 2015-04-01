package gui.terminal;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

import database.operations.ProductOperations;
import gui.Griddy;
import gui.UIElements;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class TerminalMode extends JFrame implements ActionListener {

  private ProductOperations po;
  public static TerminalMode mf;
  private JLabel logoLabel;
  private JPanel centerPanel;
  private JPanel southPanel;
  private JPanel main;
  private JButton browse, search, help, home, back;
  private GridBagLayout bl;
  private boolean displayArea = false;

  private int windowNum;
  String category, keyword;
  int lastSearchType;  // 1 is a keyword and category; 2 is just category
  int lastScreenType; // 1 is categories; 2 is a search


  public TerminalMode(){
    po = new ProductOperations();

    this.setTitle("DGA Computers");
    this.setLayout(new BorderLayout());
    this.setSize(1000, 650);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(UIElements.getColour());


    help = new JButton("HELP", new ImageIcon("src/res/images/UI Elements/help64.png"));
    help.addActionListener(this);

    home = new JButton("HOME", new ImageIcon("src/res/images/UI Elements/home64.png"));
    home.addActionListener(this);

    back = new JButton("BACK", new ImageIcon("src/res/images/UI Elements/backarrow64.png"));
    back.addActionListener(this);

    bl = new GridBagLayout();

    main = new JPanel(new BorderLayout());
    main.setMaximumSize(new Dimension(800,600));

    logoLabel = new JLabel(new ImageIcon(UIElements.banner));

    JPanel northPanel = new JPanel(new GridLayout(1, 1));
    northPanel.setBackground(Color.BLACK);
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

    centerPanel.setBackground(UIElements.getColour());
    centerPanel.add(browse, Griddy.getConstraints(0,0,1,1,10,10,0,0,0,75,75,0,0,GridBagConstraints.WEST));
    centerPanel.add(search, Griddy.getConstraints(1,0,1,1,10,10,0,0,0,75,75,0,0,GridBagConstraints.EAST));

    displayArea = true;

    return centerPanel;
  }


  // South Panel with help button
  public JPanel getMinSouthPanel(){
    southPanel = new JPanel(bl);
    southPanel.setBackground(UIElements.getColour());
    southPanel.add(help, Griddy.getConstraints(0,0,1,1,10,10,0,0,20,0,0,20,0,GridBagConstraints.CENTER));

    return southPanel;
  }


  //South Panel With back, home and help buttons
  public JPanel getFullSouthPanel(){
    southPanel = new JPanel(bl);
    southPanel.setBackground(UIElements.getColour());
    southPanel.add(back, Griddy.getConstraints(0, 0, 1, 1, 10, 10, 0, 0, 20, 0, 0, 20, 0, GridBagConstraints.WEST));
    southPanel.add(home, Griddy.getConstraints(1, 0, 1, 1, 10, 10, 0, 0, 20, 150, 150, 20, 0, GridBagConstraints.WEST));
    southPanel.add(help, Griddy.getConstraints(2,0,1,1,10,10,0,0,20,0,0,20,0,GridBagConstraints.EAST));

    return southPanel;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(search)){
      setToSearch();
      windowNum = 1;
    }
    else if(e.getSource().equals(browse)){
      setToBrowse();
      windowNum = 2;
    }
    else if(e.getSource().equals(home)){
      setToMain();
      windowNum = 0;
    }
    else if(e.getSource().equals(help)){
    }
    else if(e.getSource().equals(back)){
      if (windowNum == 1 || windowNum == 2){  // search window = 1  categories = 2  product results = 3
        setToMain();
      }
      else if (windowNum == 3){
        if (lastScreenType == 1) {
          setToBrowse();
        }
        else if(lastScreenType == 2) {
          setToSearch();
        }
      }
      else if(windowNum == 4){
        if(lastSearchType == 1){
          setToProductResults(category,keyword, lastScreenType);
        }
        else if(lastSearchType == 2){
          setToProductResults(category, lastScreenType);
        }
      }
    }
  }

  //To change the center pane to the search
  public void setToSearch(){
    windowNum = 1;
    ProductSearch c = new ProductSearch();
    removePanels();
    centerPanel = c.getSearch();
    southPanel = getFullSouthPanel();
    changePanels(centerPanel, southPanel);
  }


  //To change the center pane to the browse
  public void setToBrowse(){
    windowNum = 2;
    ProductCategories c = new ProductCategories(po);
    removePanels();
    centerPanel = c.getCategories();
    southPanel = getFullSouthPanel();
    changePanels(centerPanel, southPanel);
  }


  //To change the center pane to the home
  public void setToMain(){
    windowNum = 0;
    removePanels();
    centerPanel = getCenterPanel();
    southPanel = getMinSouthPanel();
    changePanels(centerPanel, southPanel);
  }

  //To change the center pane to the results of a product category picked
  public void setToProductResults(String category, int lastScreen){
    windowNum = 3;
    lastScreenType = lastScreen;
    lastSearchType = 2;
    this.category = category;
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
  public void setToProductResults(String category, String keyword, int lastScreen){
    windowNum = 3;
    lastScreenType = lastScreen;
    lastSearchType = 1;
    this.category = category;
    this.keyword = keyword;
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
    windowNum = 4;
    ProductView pv = new ProductView();
    Product p = po.productByIDO(productId);
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

  public static void setMf(TerminalMode mf) {
    TerminalMode.mf = mf;
  }
}
