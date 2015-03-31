package gui;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

import database.operations.ProductOperations;
import gui.terminal.TerminalMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

  public class StartWindow extends JFrame implements ActionListener {

    private ProductOperations po;
    public static TerminalMode mf;
    private JLabel logoLabel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel main;
    private JButton terminal, login, help;
    private GridBagLayout bl;
    private boolean displayArea = false;


    public StartWindow() {
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

      bl = new GridBagLayout();

      main = new JPanel(new BorderLayout());
      main.setMaximumSize(new Dimension(800, 600));

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

    public JPanel getCenterPanel() {
      centerPanel = new JPanel(bl);

      terminal = new JButton("TERMINAL MODE", new ImageIcon(UIElements.shoppingCart150));
      terminal.setPreferredSize(new Dimension(400,150));
      terminal.addActionListener(this);

      login = new JButton("         LOG IN          ", new ImageIcon(UIElements.login150));
      login.setPreferredSize(new Dimension(400,150));
      login.addActionListener(this);

      centerPanel.setBackground(UIElements.getColour());
      centerPanel.add(terminal, Griddy.getConstraints(0, 0, 1, 1, 10, 10, 1, 0, 25, 0, 0, 0, 0, GridBagConstraints.CENTER));
      centerPanel.add(login, Griddy.getConstraints(0, 1, 1, 1, 10, 10, 1, 0, 25, 0, 0, 25, 0, GridBagConstraints.CENTER));

      displayArea = true;

      return centerPanel;
    }

    // South Panel with help button
    public JPanel getMinSouthPanel() {
      southPanel = new JPanel(bl);
      southPanel.setBackground(UIElements.getColour());
      southPanel.add(help, Griddy.getConstraints(0, 0, 1, 1, 10, 10, 0, 0, 20, 0, 0, 20, 0, GridBagConstraints.CENTER));

      return southPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource().equals(terminal)) {
        TerminalMode tm = new TerminalMode();
        TerminalMode.setMf(tm);
        this.dispose();
      } else if (e.getSource().equals(login)) {
        new AuthenticationPopUp(this);
      } else if (e.getSource().equals(help)) {
        //setToProductView();
      }
    }
  }

