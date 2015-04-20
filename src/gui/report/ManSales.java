package gui.report;

import gui.UIElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.MessageFormat;

/**
 * Created by Adam Lee on 06/03/2015.
 */

public class ManSales extends JFrame{

    private Connection conn = null;
    //private PreparedStatement pstmt = null;
    private Statement stmt = null;
    private ResultSet rset;
    private JButton print, back;
    private JPanel south;

    public ManSales(){

        try {
            String queryString = "SELECT * FROM sales AND salesdetails";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(queryString);
            System.out.println("Sales JTable");
            while (rset.next()) {
                System.out.println(rset.getInt(1) + " " + rset.getString(2)
                        + " " + rset.getString(3) + " " + rset.getString(4)
                        + " " + rset.getString(5) + " " + rset.getString(6)
                        + " " + rset.getString(7) + " " + rset.getString(8)
                        + " " + rset.getString(9) + " " + rset.getString(10));
            }
        }catch (Exception e) {
            System.out.println(e);
        }

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
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ex) {
                frame.dispose();
            }
        });

        //JTable properties

        //headers for the table
        String[] columns = new String[] {
                "Sale ID" , "Make", "Model" , "Qty" , "Price" , "Date" , "Time" , "Sale Discount" , "Sale Amount" , "EmpID"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {1, "Dell", "zyu87", 40, 249.99, "24-MAR-94", "16:00", "null" , 9999.60, 1 },
                {2, "Toshiba", "Ba123" ,40, 249.99, "24-MAR-94", "16:00", "null" , 9999.60, 1 },
                {3, "Samsung", "X001",40, 249.99, "24-MAR-94", "16:00", "null" , 9999.60, 1 },
        };

        //create table with data

        final JTable table = new JTable(data, columns)
        {
            public boolean isCellEditable(int dataInfo, int columns)
            {
                return false; //To stop anyone editing the sales information.
            }
        };

        table.setBackground(new Color(98, 169, 221));
        //add the table to the frame
        frame.add(new JScrollPane(table));

        //Print ActionEvent
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MessageFormat header = new MessageFormat("Report Print"); //Header of Page
                MessageFormat footer = new MessageFormat("Page{0,number,integer}"); //Footer of Page including Number of Page
                try{
                    table.print(JTable.PrintMode.NORMAL, header, footer);
                }catch(java.awt.print.PrinterException e){
                    System.err.format("Cannot print &s&n", e.getMessage());
                }
            }
        });

        //Display the window.
        frame.pack();
        frame.getContentPane();
        frame.add(south, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}
