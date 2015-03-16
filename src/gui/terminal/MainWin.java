package gui.terminal;

import database.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainWin extends JFrame {

    private productTable table;

    public MainWin() throws SQLException {
        setTitle("Employee JTable");
        table = new productTable();
        JPanel buttonPanel = new JPanel();

        // Define our Insert Button and its functionality
        JButton insertButton = new JButton("Insert Row");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductTableModel model = (ProductTableModel)table.getModel();
                int rowNum = model.insertRow();

                table.scrollRectToVisible(table.getCellRect(rowNum, 0, true));
                table.setRowSelectionInterval(rowNum, rowNum);

                table.editCellAt(rowNum, 0);
                DefaultCellEditor cellEditor = (DefaultCellEditor) table.getCellEditor();
                JComponent cell = (JComponent)cellEditor.getComponent();
                cell.requestFocus();
            }
        });

        // Add the Insert Button
        buttonPanel.add(insertButton);

        // Define our Delete Button and its functionality
        JButton deleteButton = new JButton("Delete Row");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.isEditing())
                    table.getCellEditor().stopCellEditing();

                ProductTableModel model = (ProductTableModel)table.getModel();
                int rowNum = table.getSelectionModel().getMinSelectionIndex();
                table.scrollRectToVisible(table.getCellRect(rowNum, 0, true));
                model.deleteRow(rowNum);
                table.scrollRectToVisible(table.getCellRect(rowNum, 0, true));
            }
        });

        // Add the Delete Button
        buttonPanel.add(deleteButton);

        // Add Button and Scrollareas to the main canvas
        add("North", table.scrollPane);
        add("South", buttonPanel);

        // If Window is closed, do any pending updates
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (table.isEditing())
                    table.getCellEditor().stopCellEditing();
                if (EmpDatabaseModifier.hasTableUpdates())
                    //EmpDatabaseModifier.doTableUpdates(ConnectionDB.getConn());
                System.exit(0);
            }
        });

        setSize(400,500);
        setVisible(true);
    }
}
