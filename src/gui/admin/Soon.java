package gui.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 21/03/2015.
 */
public class Soon extends JFrame {

    public Soon(){

        this.setTitle("Soon, soon...");
        this.setSize(500,500);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
