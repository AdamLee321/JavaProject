package gui.report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import database.ConnectionDB;
import database.operations.ReportOperations;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/*IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17*/


public class ReportEmployee extends JFrame {

    private JFrame re;
    private JButton employee, year, month, day, members, product, sales, print;
    private JPanel north, jPanel1, jPanel2, jPanel3, south;//Container ,Personnel, calender, range, graph
    private JComboBox combo; // Search
    ReportOperations ro;


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
                try{
                    String query = "select saleMonth, count(*) Total from (select saleMonth from sales) group by saleMonth order by total ASC";
                    JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(),query);
                    JFreeChart BarChartObject = ChartFactory.createBarChart("Member Report", "Member ID", "Number of Points ",dataset,PlotOrientation.VERTICAL,true,true,false);
                    BarRenderer rend = null;
                    CategoryPlot p = BarChartObject.getCategoryPlot();
                    rend = new BarRenderer();
                    ChartPanel barPanel = new ChartPanel(BarChartObject);
                    BarChartObject.setBackgroundPaint(new Color(98, 169, 221)); //Background color for the Graph
                    south.removeAll(); //Removes old chart data
                    south.add(barPanel, BorderLayout.CENTER); //Adds the chart panel to the south panel
                    south.validate();//Validates each time the buttons clicked
                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Could not find the query!!");
                }
            }
        });

        //Employee Button
        employee = new JButton("Employee");
        jPanel1.add(employee);
        employee.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "select empid, count(*) Total from (select empid from sales) group by empid order by total desc";
                    JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(),query);
                    JFreeChart BarChartObject = ChartFactory.createBarChart("Employee Sales", "Emp id", "Number of Sales",dataset,PlotOrientation.VERTICAL,true,true,false);
                    BarRenderer renderer = null;
                    CategoryPlot p = BarChartObject.getCategoryPlot();
                    renderer = new BarRenderer();
                    BarChartObject.setBackgroundPaint(new Color(98, 169, 221));
                    ChartPanel barPanel = new ChartPanel(BarChartObject);
                    south.removeAll();
                    south.add(barPanel, BorderLayout.CENTER);
                    south.validate();
                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        //Product Button
        product = new JButton("Product");
        jPanel1.add(product);
        jPanel1.setBackground(new Color(98, 169, 221));
        product.addActionListener(new ActionListener() {    // action
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "SELECT DISTINCT prodMake,prodqty FROM product";
                    JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(),query);
                    JFreeChart BarChartObject = ChartFactory.createBarChart("Product Report", "Products", "Product Quantity ",dataset,PlotOrientation.VERTICAL,true,true,false);
                    BarRenderer renderer = null;
                    CategoryPlot p = BarChartObject.getCategoryPlot();
                    renderer = new BarRenderer();
                    BarChartObject.setBackgroundPaint(new Color(98, 169, 221));
                    ChartPanel barPanel = new ChartPanel(BarChartObject);
                    south.removeAll();
                    south.add(barPanel, BorderLayout.CENTER);
                    south.validate();
                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });

        //Members Button
        members = new JButton("Members");
        jPanel1.add(members);
        members.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String query = "SELECT DISTINCT membernumber,memberpoints FROM member ORDER BY membernumber ASC";
                    JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(),query);
                    JFreeChart BarChartObject = ChartFactory.createBarChart("Member Report", "Member ID", "Number of Points ",dataset,PlotOrientation.VERTICAL,true,true,false);
                    BarRenderer rend = null;
                    CategoryPlot p = BarChartObject.getCategoryPlot();
                    rend = new BarRenderer();
                    ChartPanel barPanel = new ChartPanel(BarChartObject);
                    BarChartObject.setBackgroundPaint(new Color(98, 169, 221));
                    south.removeAll();
                    south.add(barPanel, BorderLayout.CENTER);
                    south.validate();
                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Could not find the query!!");
                }
            }
        });
        north.add(jPanel1, BorderLayout.NORTH);//Places the panel inside the north panel

        jPanel2 = new JPanel(new FlowLayout());
        jPanel2.setBackground(new Color(98, 169, 221));
        jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Calender"));
        //Week Button
        day = new JButton("Day");
        jPanel2.add(day);
        day.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReportDayYear();
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
        //Combobox
        final String top5 = "Top 5 Products";
        final String least5 = "Top 5 Least Purchased";
        final String topMembers = "Top Members";
        String[] queryTitles = new String[] {top5, least5};
        final JComboBox<String> combo = new JComboBox<>(queryTitles);
        combo.setPrototypeDisplayValue("I need it to be this length"); //Insert the widest value here to size the comboBox
        jPanel3.add(combo);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedQuery = (String) combo.getSelectedItem();
                System.out.println("You seleted the book: " + selectedQuery);
                if(topMembers == selectedQuery){
                    try{
                        String query = "SELECT saleYear FROM sales WHERE saleYear = " ;
                        JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(),query);
                        JFreeChart BarChartObject = ChartFactory.createBarChart("Top 5 Products", "Product ID", "Number of Sales per Item ",dataset,PlotOrientation.VERTICAL,true,true,false);
                        BarRenderer rend = null;
                        CategoryPlot p = BarChartObject.getCategoryPlot();
                        rend = new BarRenderer();
                        ChartPanel barPanel = new ChartPanel(BarChartObject);
                        BarChartObject.setBackgroundPaint(new Color(98, 169, 221));
                        south.removeAll();
                        south.add(barPanel, BorderLayout.CENTER);
                        south.validate();
                    } catch (Exception e1){
                        JOptionPane.showMessageDialog(null, "Could not find the query!!");
                    }
                }
                if(top5 == selectedQuery){
                    try{
                        String query = "SELECT * FROM (SELECT prodid, Count(prodid) \"Sold\" FROM sales GROUP BY prodid ORDER BY count(prodid) DESC , prodid ASC) A WHERE rownum <= 5";
                        JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(),query);
                        JFreeChart BarChartObject = ChartFactory.createBarChart("Top 5 Products", "Product ID", "Number of Sales per Item ",dataset,PlotOrientation.VERTICAL,true,true,false);
                        BarRenderer rend = null;
                        CategoryPlot p = BarChartObject.getCategoryPlot();
                        rend = new BarRenderer();
                        ChartPanel barPanel = new ChartPanel(BarChartObject);
                        BarChartObject.setBackgroundPaint(new Color(98, 169, 221));
                        south.removeAll();
                        south.add(barPanel, BorderLayout.CENTER);
                        south.validate();
                    } catch (Exception e1){
                        JOptionPane.showMessageDialog(null, "Could not find the query!!");
                    }
                }
                if(least5 == selectedQuery) {
                    try {
                        String query = "SELECT * FROM (SELECT prodid, Count(prodid) \"Sold\" FROM sales GROUP BY prodid ORDER BY count(prodid) Asc , prodid DESC) A WHERE rownum <= 5";
                        JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(), query);
                        JFreeChart BarChartObject = ChartFactory.createBarChart("Top 5 least Purchased", "Product ID", "Number of Sales per Item ", dataset, PlotOrientation.VERTICAL, true, true, false);
                        BarRenderer rend = null;
                        CategoryPlot p = BarChartObject.getCategoryPlot();
                        rend = new BarRenderer();
                        ChartPanel barPanel = new ChartPanel(BarChartObject);
                        BarChartObject.setBackgroundPaint(new Color(98, 169, 221));
                        south.removeAll();
                        south.add(barPanel, BorderLayout.CENTER);
                        south.validate();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Could not find the query!!");
                    }
                }
                }
        });

        //PRINT BUTTON
        print = new JButton("Print");
        jPanel3.add(print);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                print.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        printWork();
                        }
                });
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

    public void printWork()
    {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName("Print Graph");

        pj.setPrintable(new Printable()
        {
            @Override
            public int print(Graphics pg, PageFormat pf, int pageNum)
            {
                if(pageNum > 0)
                    return Printable.NO_SUCH_PAGE;

                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                south.print(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if(pj.printDialog() == false)
            return;
        try
        {
            pj.print();
        }
        catch(PrinterException xcp)
        {
            xcp.printStackTrace(System.err);
        }
    }
}
