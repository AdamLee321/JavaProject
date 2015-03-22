package gui.member;


/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/03/2015)
*/

import gui.UIElements;
import gui.admin.AdminMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class OrderView extends JDialog implements MouseListener, ActionListener  {

    JPanel pnlNorth, pnlCenter, pnlSouth;
    JButton btnSearch, btnView, btnBack;
    JTextField tfSearch;
    String textFieldTip = "Type in the order number...";

    public OrderView(){

        this.setTitle("Order History");
        this.setLayout(new BorderLayout()); // tip: border(don't indicate position), grid or gridbag layouts will stretch a component to the whole screen
        this.setSize(580,650);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(98, 169, 221));
        this.setLocationRelativeTo(null);

// NORTH

        pnlNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10)); // center and add padding
        pnlNorth.setBorder(BorderFactory.createEtchedBorder()); // set empty etched border
        pnlNorth.setBackground(new Color(98, 169, 221));

        tfSearch = new JTextField(30);
        tfSearch.setText(textFieldTip); // set initial text field search
        tfSearch.setForeground(Color.GRAY); // set initial colour to gray
        tfSearch.addMouseListener(this);
        pnlNorth.add(tfSearch);

        btnSearch = new JButton("Search", new ImageIcon(UIElements.search16)); // initialize the search button, add a add and icon
        btnSearch.setPreferredSize(new Dimension(100, 26));
        pnlNorth.add(btnSearch);

        btnView = new JButton("View", new ImageIcon(UIElements.open16));
        btnView.setPreferredSize(new Dimension(100, 26));
        btnView.addActionListener(this);
        pnlNorth.add(btnView);

        this.add(pnlNorth, BorderLayout.NORTH);

// CENTER

        pnlCenter = new JPanel();

        this.add(pnlCenter, BorderLayout.CENTER);

// SOUTH

        pnlSouth = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlSouth.setBorder(BorderFactory.createEtchedBorder());
        pnlSouth.setBackground(new Color(98, 169, 221));

        btnBack = new JButton("Back", new ImageIcon(UIElements.cancel6)); // initialize the search button, add a add and icon);
        btnBack.setPreferredSize(new Dimension(100, 26));
        btnBack.addActionListener(this);
        pnlSouth.add(btnBack);

        this.add(pnlSouth, BorderLayout.SOUTH);

// turns the lights on
        this.setVisible(true);
    }

// BUTTON ACTIONS

    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        if(e.getSource().equals(tfSearch)){
            if (tfSearch.getText().equals(textFieldTip)) {
                tfSearch.setText("");
                tfSearch.setForeground(null); // reset colour to black
            }
            tfSearch.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {}
                @Override
                public void focusLost(FocusEvent e) { // set the textFieldTip to be visible in text field on focus loss
                    if (tfSearch.getText().equals("")){
                        tfSearch.setText(textFieldTip);
                        tfSearch.setForeground(Color.GRAY);
                    }
                }
            });
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(btnBack)){
            this.dispose();
        }
    }


}
