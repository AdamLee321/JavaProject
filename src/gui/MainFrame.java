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
  JPanel northPanel;
  String loc = "/res/images/banner.png";
  JFrame f;

  public MainFrame(){
    f = new JFrame();
    f.setTitle("DGA Computers");
    f.setLayout(new BorderLayout());
    f.setSize(1000, 650);
    f.setResizable(true);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    //f.getContentPane().setBackground(new Color(98, 169, 221));
    f.setVisible(true);


    //logoLabel = new JLabel();
    //logoLabel = new JLabel(new ImageIcon(loc));
    //this.add(logoLabel, BorderLayout.PAGE_START);


    northPanel = new JPanel();
    ImageIcon tvIcon = new ImageIcon("src/res/images/banner.png");
    JLabel northLabel = new JLabel(" F", tvIcon,
            SwingConstants.LEFT);
    northLabel.setHorizontalTextPosition(SwingConstants.LEADING);
    northPanel.setBackground(Color.white);
    northPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    northPanel.add(northLabel);
    f.add(northPanel, BorderLayout.NORTH);
  }
}
