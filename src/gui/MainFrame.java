package gui;/*2ndYearProject
  gui
  Created by David
  14:56   06/03/2015
  Software Development 3
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame implements ActionListener {

  ImageIcon logo;
  JLabel logoLabel;
  JPanel northPanel, centerPanel, southPanel, main;
  JButton help;
  JButton browse, search;


  public MainFrame(){

    this.setTitle("DGA Computers");
    //this.setLayout();
    this.setSize(1000, 650);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(98, 169, 221));



    //logoLabel = new JLabel();
    //logoLabel = new JLabel(new ImageIcon(loc));
    //this.add(logoLabel, BorderLayout.PAGE_START);


    browse = new JButton(new ImageIcon("src/res/images/UI Elements/product150.png"));
    search = new JButton(new ImageIcon("src/res/images/UI Elements/search150.png"));
    help = new JButton("HELP", new ImageIcon("src/res/images/UI Elements/help64.png"));


    GridBagLayout bl = new GridBagLayout();


    main = new JPanel(new BorderLayout());
    main.setMaximumSize(new Dimension(800,600));
    northPanel = new JPanel(new GridLayout(1,1));
    centerPanel = new JPanel(bl);
    southPanel = new JPanel();

    ImageIcon tvIcon = new ImageIcon("src/res/images/UI Elements/banner.png");
    JLabel northLabel = new JLabel(tvIcon);

    northPanel.setBackground(new Color(98, 169, 221));
    northPanel.add(northLabel);

    centerPanel.setBackground(new Color(98, 169, 221));
    centerPanel.add(browse, getConstraints(0,0,1,1, GridBagConstraints.WEST));
    centerPanel.add(search, getConstraints(1,0,1,1, GridBagConstraints.EAST));

    southPanel.setBackground(new Color(98, 169, 221));
    southPanel.add(help);


    main.add(northPanel, BorderLayout.NORTH);
    main.add(centerPanel, BorderLayout.CENTER);
    main.add(southPanel, BorderLayout.SOUTH);

    this.add(main);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  private GridBagConstraints getConstraints(int gridx, int gridy,
                                            int gridwidth, int gridheight, int anchor)
  {
    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(0, 50, 0, 50);
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
