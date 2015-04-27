package gui.report;

import database.operations.ReportOperations;
import gui.UIElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.MessageFormat;

import net.proteanit.sql.DbUtils;

/**
 * Created by Adam Lee on 06/03/2015.
 */

public class ManSales extends JFrame{

    private JButton print, back;
    private JPanel south;

    private JTable table;
    private ReportTableModel reportTableModel;

    public ManSales() throws SQLException {
        //Set up Frame
        final JFrame frame = new JFrame();
        frame.setTitle("Sales View");
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(700, 700));

        //BUTTONS Panel
        south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.setBackground(new Color(98, 169, 221));
        //Print
        print = new JButton("Print", new ImageIcon(UIElements.print16));
        south.add(print);

        //Back Out
        back = new JButton("Back");
        south.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ex) {
                frame.dispose();
            }
        });

        //JTable properties

        //create table with data
        reportTableModel = new ReportTableModel();
        //UpdateJTable();//empty and update
        table = new JTable(reportTableModel);
        //table.setBackground(new Color(98, 169, 221)); //Table background color
        frame.add(new JScrollPane(table)); //add the table to the frame

        //Print ActionEvent
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MessageFormat header = new MessageFormat("Report Print"); //Header of Page
                MessageFormat footer = new MessageFormat("Page{0,number,integer}"); //Footer of Page including Number of Page
                try {
                    table.print(JTable.PrintMode.NORMAL, header, footer); //table Button needed
                } catch (java.awt.print.PrinterException e) {
                    System.err.format("Cannot print &s&n", e.getMessage());
                }
            }
        });

        //Display the window.
        UpdateJTable();//empty and update
        frame.pack();
        frame.getContentPane();
        frame.add(south, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public void UpdateJTable() throws SQLException {
        //no duplicating
        reportTableModel.queryTableData(); //get updated results
    }
}

