package gui.terminal;

import database.ConnectionDB;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ProductTable extends JTable {
    public static JScrollPane scrollPane;
    ProductTableModel tableModel;

    //Set the table height
    protected static final int tableHeight = 200;

    public ProductTable() throws SQLException {
        tableModel = new ProductTableModel();
        this.setModel(tableModel);
        scrollPane = new JScrollPane();
        scrollPane.add(this);

        // Set the table width, depending upon the width of
        // the columns
        int tableWidth = 0;
        int columnCount = tableModel.columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++)
            tableWidth += tableModel.columnModel.getColumn(i).getWidth();

        scrollPane.setPreferredSize(new Dimension(tableWidth, tableHeight));
        scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED));

        // Get the data!
        tableModel.queryTableData(ConnectionDB.getConn());
    }
}
