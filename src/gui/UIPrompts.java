package gui;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 10/03/2015)
*/

import database.ConnectionDB;

import javax.swing.*;
import java.sql.SQLException;

public class UIPrompts {

    public static void exitProgram(){ // object(frame), main text of the dialog, dialog window name, type of dialog, type of message, icon, arrayofoptions(buttons), default selected option from arrayofoptions (ex... options[1])
        Object[] options = {"  Yes  ","  No  "}; // choices for closing dialog - these are buttons that appear on the dialog
        int choice = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the application?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, null);
        if (choice == 0)
            System.exit(0);
            ConnectionDB.closeDB();
    }
}