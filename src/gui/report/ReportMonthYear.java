package gui.report;

import database.ConnectionDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Adam Lee on 13/03/2015.
 */
public class ReportMonthYear {
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    private JDialog jd2;
    private JComboBox month, year;
    private JButton okButton;
    private JPanel center;

    public ReportMonthYear() {

        jd2 = new JDialog();
        jd2.setLayout(new BorderLayout());
        jd2.setTitle("Please select Month and Year");
        jd2.setSize(300, 100);
        jd2.setLocationRelativeTo(null);

        //JPanel initialisation
        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(98, 169, 221));

        //Combo box creation
        month = new JComboBox();
        SMFillCombo(); // Month comboBox method call
        center.add(month);
        month.setEditable(true);
        System.out.println("Month=" + month.getItemCount());

        month.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + month.getSelectedIndex()
                        + " Selected Month=" + month.getSelectedItem());
            }
        });

        year = new JComboBox();
        SYFillCombo(); // Year comboBox method call
        center.add(year);
        year.setEditable(true);
        System.out.println("Year=" + year.getItemCount());

        year.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + year.getSelectedIndex()
                        + " Selected year=" + year.getSelectedItem());
            }
        });

        //OK Button
        okButton = new JButton("Ok");
        center.add(okButton);

        jd2.add(center, BorderLayout.CENTER);
        jd2.setVisible(true);
    }

    private void SMFillCombo() {
        try { //Order  the month to appear correctly
            String query = "SELECT DISTINCT saleMonth FROM sales\n" +
                    "ORDER BY \n" +
                    "CASE \n" +
                    "  WHEN saleMonth LIKE 'JAN%' THEN 1\n" +
                    "  WHEN saleMonth LIKE 'FEB%' THEN 2\n" +
                    "  WHEN saleMonth LIKE 'MAR%' THEN 3\n" +
                    "  WHEN saleMonth LIKE 'APR%' THEN 4\n" +
                    "  WHEN saleMonth LIKE 'MAY%' THEN 5\n" +
                    "  WHEN saleMonth LIKE 'JUN%' THEN 6\n" +
                    "  WHEN saleMonth LIKE 'JUL%' THEN 7\n" +
                    "  WHEN saleMonth LIKE 'AUG%' THEN 8\n" +
                    "  WHEN saleMonth LIKE 'SEP%' THEN 9\n" +
                    "  WHEN saleMonth LIKE 'OCT%' THEN 10\n" +
                    "  WHEN saleMonth LIKE 'NOV%' THEN 11\n" +
                    "  WHEN saleMonth LIKE 'DEC%' THEN 12\n" +
                    "  ELSE 13\n" +
                    "END,saleMonth";
            stmt = ConnectionDB.getConn().createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                String name = rset.getString("saleMonth"); //Field I want to show in combobox
                month.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void SYFillCombo() {
        try {
            String query = "SELECT DISTINCT saleYear FROM sales";
            stmt = ConnectionDB.getConn().createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                String name = rset.getString("saleYear"); //Field I want to show in combobox
                year.addItem(name);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}
