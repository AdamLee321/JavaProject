package gui.admin;

import javax.swing.*;
import java.awt.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 22/03/2015)
*/

// just having some fun...

public class Soon extends JDialog {

    public Soon(){

        this.setTitle("Soon, soon...");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(new GridBagLayout());
        JLabel img = new JLabel(new ImageIcon("src/res/images/soon.png"));
        this.add(img);
        this.setVisible(true);
    }
}
