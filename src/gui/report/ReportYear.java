package gui.report;

import database.ConnectionDB;
import javafx.scene.control.ComboBox;

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
public class ReportYear {
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    private JDialog jd3;
    private JPanel center;
    private JComboBox year;
    private JButton okButton;

    public ReportYear() {
        jd3 = new JDialog();
        jd3.setLayout(new BorderLayout());
        jd3.setTitle("Please select the year");
        jd3.setSize(300, 100);
        jd3.setLocationRelativeTo(null);

        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(98, 169, 221));

        //Year Combobox
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

        jd3.add(center, BorderLayout.CENTER);
        jd3.setVisible(true);
    }

    public void SYFillCombo(){
        try{
            String query = "SELECT DISTINCT saleYear FROM sales";
            stmt = ConnectionDB.getConn().createStatement();
            rset = stmt.executeQuery(query);
            while(rset.next()){
                String name = rset.getString("saleYear"); //Field I want to show in combobox
                year.addItem(name);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }
}

