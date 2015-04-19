package gui.report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.scene.chart.CategoryAxisBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/*IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17*/


public class ReportEmployee extends JFrame {

    private JFrame re;
    private JButton employee, year, month, week, okButton, members, product, sales;
    private JPanel north, jPanel1, jPanel2, jPanel3, south;//Container ,Personnel, calender, range, graph
    private JTextField jTextField1; // Search


    public ReportEmployee() {


        re = new JFrame();
        re.setTitle("Reports");
        re.setLayout(new BorderLayout());
        re.setSize(500, 500);
        re.setLocationRelativeTo(null); //Sets the screen to appear in the center
        re.setResizable(true);


        //NORTH PANEL
        north = new JPanel(new BorderLayout());
        north.setBackground(new Color(98, 169, 221));

        jPanel1 = new JPanel(new FlowLayout());
        jPanel1.setBackground(new Color(98, 169, 221));
        jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Personnel"));

        //Sales Button;
        sales = new JButton("Sales");
        jPanel1.add(sales);
        jPanel1.setForeground(Color.GRAY);
        sales.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(100, "Month", "Alien");
                dataset.setValue(80, "Month", "Apple");
                dataset.setValue(40, "Month", "Samsung");
                dataset.setValue(78, "Month", "Dell");
                dataset.setValue(20, "Month", "Toshiba");

                JFreeChart chart = ChartFactory.createBarChart("Sales Chart", "Laptop Names", "Sales", dataset, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p = chart.getCategoryPlot();
                p.setRangeGridlinePaint(Color.BLUE);
                ChartPanel barPanel = new ChartPanel(chart);
                south.removeAll();
                south.add(barPanel, BorderLayout.CENTER);
                south.validate();
            }
        });

        //Employee Button
        employee = new JButton("Employee");
        jPanel1.add(employee);
        employee.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(100, "Employee", "John");
                dataset.setValue(80, "Employee", "Marie");
                dataset.setValue(40, "Employee", "Eoin");
                dataset.setValue(78, "Employee", "Lisa");
                dataset.setValue(20, "Employee", "Brendan");

                JFreeChart chart = ChartFactory.createBarChart("Employee Sales", "Employee Names", "Number of Sales", dataset, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p = chart.getCategoryPlot();
                p.setRangeGridlinePaint(Color.BLUE);
                ChartPanel barPanel = new ChartPanel(chart);
                south.removeAll();
                south.add(barPanel, BorderLayout.CENTER);
                south.validate();
            }
        });

        //Product Button
        product = new JButton("Product");
        jPanel1.add(product);
        jPanel1.setBackground(new Color(98, 169, 221));
        product.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(100, "Employee", "Fuck");
                dataset.setValue(80, "Employee", "this");
                dataset.setValue(40, "Employee", "Project");
                dataset.setValue(78, "Employee", "George");
                dataset.setValue(20, "Employee", "David");

                JFreeChart chart = ChartFactory.createBarChart("Employee Sales", "DickHeads", "Number of Sales", dataset, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p = chart.getCategoryPlot();
                p.setRangeGridlinePaint(Color.BLUE);
                ChartPanel barPanel = new ChartPanel(chart);
                south.removeAll();
                south.add(barPanel, BorderLayout.CENTER);
                south.validate();
            }
        });

        //Members Button
        members = new JButton("Members");
        jPanel1.add(members);
        members.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(100, "Employee", "January");
                dataset.setValue(80, "Employee", "February");
                dataset.setValue(40, "Employee", "March");
                dataset.setValue(78, "Employee", "April");
                dataset.setValue(20, "Employee", "May");

                JFreeChart chart = ChartFactory.createBarChart("New Members Chart", "Months", "New Members", dataset, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p = chart.getCategoryPlot();
                p.setRangeGridlinePaint(Color.BLUE);
                ChartPanel barPanel = new ChartPanel(chart);
                south.removeAll();
                south.add(barPanel, BorderLayout.CENTER);
                south.validate();
            }
        });
        north.add(jPanel1, BorderLayout.NORTH);//Places the panel inside the north panel

        jPanel2 = new JPanel(new FlowLayout());
        jPanel2.setBackground(new Color(98, 169, 221));
        jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Calender"));
        //Week Button
        week = new JButton("Week");
        jPanel2.add(week);
        week.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReportWeekYear();
            }
        });
        //Month Button
        month = new JButton("Month");
        jPanel2.add(month);
        month.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReportMonthYear();
            }
        });
        //Year Button
        year = new JButton("Year");
        jPanel2.add(year);
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReportYear();
            }
        });
        north.add(jPanel2, BorderLayout.CENTER);

        jPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jPanel3.setBackground(new Color(98, 169, 221));
        jPanel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Range"));
        //TextField
        jTextField1 = new JTextField("Search");
        jTextField1.setColumns(15);// Sets the column width of the Textfield
        jPanel3.add(jTextField1);
        jTextField1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                jTextField1.setText(""); //Empties textfield when clicked

            }
            public void focusLost(FocusEvent e) {
            }
        });

        //OK BUTTON
        okButton = new JButton("Ok");
        jPanel3.add(okButton);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //OK ACTION
            }
        });
        north.add(jPanel3, BorderLayout.SOUTH);

        //SOUTH
        south = new JPanel(new BorderLayout());
        south.setBackground(new Color(98, 169, 221));

        //ADDING PANELS TO THE FRAME
        re.add(north, BorderLayout.NORTH);
        re.add(south, BorderLayout.CENTER);
        re.setVisible(true);
    }
}
