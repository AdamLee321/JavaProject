package gui.report;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import database.ConnectionDB;
import database.operations.ReportOperations;
import javafx.scene.chart.CategoryAxisBuilder;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import static javax.swing.JPanel.*;

/*IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17*/


public class ReportEmployee extends JFrame {

    private JFrame re;
    private JButton employee, year, month, day, members, product, sales, print, save;
    private JPanel north, jPanel1, jPanel2, jPanel3, south;//Container ,Personnel, calender, range, graph

    public ReportEmployee() {


        re = new JFrame();
        re.setTitle("Reports");
        re.setLayout(new BorderLayout());
        re.setSize(600, 600);
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
                    String query = "select saleId, saleAmount FROM sales ORDER BY saleAmount DESC";
                    JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(),query);
                    JFreeChart BarChartObject = ChartFactory.createBarChart("Sales Report", "Month", "Number of Sales per Month ",dataset,PlotOrientation.VERTICAL,true,true,false);
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

        //Combobox
        final String top5 = "Top 5 Products";
        final String least5 = "Top 5 Least Purchased";
        final String topemps = "Top Employess";
        final String leastEmps = "Lowest Employees Sales";
        final String topsaleMon = "Top Month for Sales";
        final String pie5 = "Pie Chart";
        String[] queryTitles = new String[] {top5, least5,topemps, leastEmps , topsaleMon};
        final JComboBox<String> combo = new JComboBox<>(queryTitles);
        combo.setPrototypeDisplayValue("I need it to be this length"); //Insert the widest value here to size the comboBox
        jPanel2.add(combo);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedQuery = (String) combo.getSelectedItem();
                System.out.println("You seleted the query: " + selectedQuery);
                if (topsaleMon == selectedQuery) {
                    try {
                        String query = "SELECT * FROM (SELECT saleDate, Count(saleDate) \"Total Sales\" FROM sales GROUP BY saleDate ORDER BY count(saleDate) Desc , saleDate Asc) A WHERE rownum <= 1";
                        JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(), query);
                        JFreeChart BarChartObject = ChartFactory.createBarChart("Highest Month of Sales", "Sale Month", "Number of Sales ", dataset, PlotOrientation.VERTICAL, true, true, false);
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
                if (leastEmps == selectedQuery) {
                    try {
                        String query = "SELECT * FROM (SELECT empid, Count(empid) \"Total Sales\" FROM sales GROUP BY empid ORDER BY count(empid) asc , empid desc) A WHERE rownum <= 5";
                        JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(), query);
                        JFreeChart BarChartObject = ChartFactory.createBarChart("Lowest Employee Sales", "Employee ID", "Number of Sales", dataset, PlotOrientation.VERTICAL, true, true, false);
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
                if (topemps == selectedQuery) {
                    try {
                        String query = "SELECT * FROM (SELECT empid, Count(empid) \"Total Sales\" FROM sales GROUP BY empid ORDER BY count(empid) Desc , empid Asc) A WHERE rownum <= 5";
                        JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(), query);
                        JFreeChart BarChartObject = ChartFactory.createBarChart("Top 5 Employee Sales", "Employee ID", "Number of Sales", dataset, PlotOrientation.VERTICAL, true, true, false);
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
                if (top5 == selectedQuery) {
                    try {
                        String query = "SELECT prodid,qty FROM salesdetails ORDER BY prodid DESC";
                        JDBCCategoryDataset dataset = new JDBCCategoryDataset(ConnectionDB.getConn(), query);
                        JFreeChart BarChartObject = ChartFactory.createBarChart("Top 5 Products", "Product ID", "Number of Sales per Item ", dataset, PlotOrientation.VERTICAL, true, true, false);
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
                if (least5 == selectedQuery) {
                    try {
                        String query = "SELECT prodid,qty FROM salesdetails ORDER BY prodid ASC";
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
                    if (pie5 == selectedQuery) {
                        try {
                            String query = "SELECT  FROM prodid";
                            JDBCCategoryDataset piedataset = new JDBCCategoryDataset(ConnectionDB.getConn(), query);
                            JFreeChart chart = ChartFactory.createPieChart("Pie Chart", (PieDataset) piedataset, true, true, true);
                            //PiePlot p = (PiePlot) chart.getPlot();
                            //p.setForegroundAlpha(Plot.DEFAULT_FOREGROUND_ALPHA);
                            ChartPanel piePanel = new ChartPanel(chart);
                            piePanel.setBackground(new Color(98, 169, 221));
                            south.removeAll();
                            south.add(piePanel, BorderLayout.CENTER);
                            south.validate();
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(null, "Could not find the query!!");
                        }
                    }
                }
            }
        });

        //PRINT BUTTON
        print = new JButton("Print");
        jPanel2.add(print);
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
        north.add(jPanel2, BorderLayout.SOUTH);

        //SAVE BUTTON
        save = new JButton("Save");
        jPanel2.add(save, FlowLayout.RIGHT);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });

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

    private void saveImage() {
        BufferedImage img = new BufferedImage(south.getWidth(), south.getHeight(), BufferedImage.TYPE_INT_RGB);
        south.paint(img.getGraphics());
        try {
            ImageIO.write(img, "png", new File("C://Graph.png"));
            JOptionPane.showMessageDialog(null, "Graph saved as image");
        } catch (Exception e) {
            System.out.println("Graph not saved" + e.getMessage());
        }
    }
}
