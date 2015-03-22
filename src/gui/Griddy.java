package gui;

import java.awt.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 17/03/2015)
*/

// GridBagPOWER!!!

public class Griddy {

    // return GridBagConstraints for GridBagLayout

    public static GridBagConstraints getConstraints(int gridx,int gridy,int gridwidth,int gridheight,int ipadxIn,int ipadyIn,int weightxIn,int weightyIn,int topInsetIn,int leftInsetIn,int rightInsetIn,int bottomInsetIn,int fillIn,int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx; // position x
        c.gridy = gridy; // position y
        c.gridwidth = gridwidth; // width of the cell
        c.gridheight = gridheight; // height of the cell
        c.ipadx = ipadxIn; // 0
        c.ipady = ipadyIn; // 0
        c.weightx = weightxIn;  // 0 - when centered (only component) push it all the way to the edges
        c.weighty = weightyIn;  // 0
        c.insets = new Insets(topInsetIn, leftInsetIn, bottomInsetIn, rightInsetIn);  // insets = control individual indents of components, usually 5 all around
        c.fill = fillIn;  // vertical, horizontal, both - fill the cell, ex... GridBagConstraints.HORIZONTAL
        c.anchor = anchor; // east, west, center position in the cell, ex... GridBagConstraints.EAST
        return c;
    }
}
