package gui;/*2ndYearProject
  gui
  Created by David
  14:56   06/03/2015
  Software Development 3
*/

import javax.swing.*;
import java.awt.*;



public class MainFrame extends JFrame {

  ImageIcon logo;
  JLabel logoLabel;
  JPanel northPanel, southPanel;
  JButton b1, b2, b3;
  String loc = "/res/images/banner.png";


  public MainFrame(){

    this.setTitle("DGA Computers");
    this.setLayout(new BorderLayout());
    this.setSize(1000, 650);
    this.setResizable(true);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(new Color(98, 169, 221));
    this.setVisible(true);


    //logoLabel = new JLabel();
    //logoLabel = new JLabel(new ImageIcon(loc));
    //this.add(logoLabel, BorderLayout.PAGE_START);

    b1 = new JButton("One");
    b2 = new JButton("Two");
    b3 = new JButton("Three");

    northPanel = new JPanel(new GridLayout(1,1));
    southPanel = new JPanel();

    ImageIcon tvIcon = new ImageIcon("src/res/images/banner.png");
    JLabel northLabel = new JLabel(tvIcon);
    //southPanel.setHorizontalTextPosition(SwingConstants.LEADING);
    northPanel.add(northLabel);

    northPanel.setBackground(new Color(98, 169, 221));
    southPanel.setBackground(new Color(98, 169, 221));
    
    southPanel.add(b1);
    southPanel.add(b2);
    southPanel.add(b3);
    this.add(northPanel, BorderLayout.NORTH);
    this.add(southPanel, BorderLayout.CENTER);
  }
}
