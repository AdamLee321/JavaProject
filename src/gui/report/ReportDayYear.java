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
public class ReportDayYear{
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    private JDialog jd1;
    private JComboBox day, year;
    private JButton okButton;
    private JPanel center;

    public ReportDayYear(){

        jd1 = new JDialog();
        jd1.setLayout(new BorderLayout());
        jd1.setTitle("Please select the Day and Year");
        jd1.setSize(300, 100);
        jd1.setLocationRelativeTo(null);

        //JPanel initialisation
        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(98, 169, 221));

        //Combo box creation
        day = new JComboBox();
        SDFillCombo();
        center.add(day);
        day.setEditable(true);
        System.out.println("day=" + day.getItemCount());

        day.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + day.getSelectedIndex()
                        + " Selected day=" + day.getSelectedItem());
            }
        });

        year = new JComboBox();
        SYFillCombo();
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

        jd1.add(center, BorderLayout.CENTER);
        jd1.setVisible(true);
    }

    private void SDFillCombo() {
        try {
            String query = "SELECT DISTINCT saleDay FROM sales ORDER BY saleDay asc";
            stmt = ConnectionDB.getConn().createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                String name = rset.getString("saleDay"); //Field I want to show in combobox
                day.addItem(name);
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
