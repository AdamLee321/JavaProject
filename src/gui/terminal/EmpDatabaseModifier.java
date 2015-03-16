package gui.terminal;

import database.SQLExceptionHandler;

import java.sql.*;
import java.util.ArrayList;

public class EmpDatabaseModifier {

    // Holding area for data modifications
    private static ArrayList<Object> ELNUpdates = new ArrayList();
    private static ArrayList<Object> EFNUpdates = new ArrayList();
    private static ArrayList<Object> rowsToInsert = new ArrayList();
    private static ArrayList<Object> rowsToDelete = new ArrayList();

    final static int NOROWID = -1;
    private static int maxRowId = NOROWID;

    // Are the users making any changes to the table data?
    public static boolean hasTableUpdates() {
        return (rowsToInsert.size() > 0 ||
                rowsToDelete.size() > 0 ||
                ELNUpdates.size() > 0 ||
                EFNUpdates.size() > 0);
    }

    // Remove record from the records to be inserted arraylist
    public static void removeAddToInsert(int rowNum) {
        for (int i = 0; i < rowsToInsert.size(); i++) {
            if (((ObjectToIntMap)rowsToInsert.get(i)).intVal == rowNum) {
                rowsToInsert.remove(i);
                return;
            }
        }
    }

    // Change row numbers to adjust for insert arraylist changes
    public static void changeRowNumbers(int deletedRowNum) {
        for (int i = 0; i < rowsToInsert.size(); i++) {
            ObjectToIntMap rowInsert = (ObjectToIntMap)rowsToInsert.get(i);
            if (rowInsert.intVal > deletedRowNum)
                rowInsert.intVal--;
        }
    }

    /*// Update the table with the arraylist information
    public static void doTableUpdates(Connection conn) {
        try {
            if (rowsToInsert.size() > 0)
                doRowInsert(conn);
            if (rowsToDelete.size() > 0)
                doRowDelete(conn);
            if (ELNUpdates.size() > 0)
                doEmpLastNameUpdate(conn);
            if (EFNUpdates.size() > 0)
                doEmpFirstNameUpdate(conn);
        }
        catch (SQLException ex) {
            SQLExceptionHandler.handleException(ex, conn);
        }
    }*/

    // Update the lastname field
    private static void doEmpLastNameUpdate(Connection conn) throws SQLException {
        String query = "UPDATE Employee SET lastname = ? WHERE empID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        while(ELNUpdates.size() > 0) {
            ObjectToIntMap update = (ObjectToIntMap)ELNUpdates.get(0);
            stmt.setString(1, (String)update.obj);
            stmt.setInt(2, update.intVal);
            stmt.executeUpdate();
            ELNUpdates.remove(0);
            conn.commit();
        }
        stmt.close();
    }

    // Update the firstname field
    private static void doEmpFirstNameUpdate(Connection conn) throws SQLException {

        String query = "UPDATE Employee SET firstname = ? WHERE empID = ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        while (EFNUpdates.size() > 0) {
            ObjectToIntMap update = (ObjectToIntMap)EFNUpdates.get(0);
            stmt.setString(1, (String)update.obj);
            stmt.setInt(2, update.intVal);
            stmt.executeUpdate();
            EFNUpdates.remove(0);
            conn.commit();
        }
        stmt.close();
    }

    // Insert a row into the table
    /*private static void doRowInsert(Connection conn) throws SQLException
    {
        String sql = "INSERT INTO Employee VALUES(?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        while (rowsToInsert.size() > 0) {
            EmpRow row = (EmpRow)((ObjectToIntMap)rowsToInsert.get(0)).obj;
            stmt.setInt(1, getNewRowId(conn));

            stmt.setString(2, row.EmpLastName);
            stmt.setString(3, row.EmpFirstName);
            stmt.executeUpdate();
            rowsToInsert.remove(0);
            conn.commit();
        }
        stmt.close();
    }*/

    // Delete a row from the table
    private static void doRowDelete(Connection conn) throws SQLException {
        String sql = "DELETE FROM Employee WHERE empID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        while (rowsToDelete.size() > 0) {
            stmt.setObject(1, rowsToDelete.get(0));
            stmt.executeUpdate();
            rowsToDelete.remove(0);
            conn.commit();
        }
        stmt.close();
    }

    // Get a new Row Id (Id) number for a new record
    private static int getNewRowId(Connection conn) throws SQLException {
        if (maxRowId == NOROWID) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(empID) FROM  employee");
            if (rs.next())
                maxRowId = rs.getInt(1);
            else
                maxRowId = -1;
            rs.close();
            stmt.close();
        }
        return ++maxRowId;
    }

    // Add a record to the insert arraylist
    public static void addToInsert(ObjectToIntMap rowInsert) {
        rowsToInsert.add(rowInsert);
    }

    // Add an entry to the lastname arraylist
    public static void add2ELNUpdates(ObjectToIntMap lastNameUpdate) {
        ELNUpdates.add(lastNameUpdate);
    }

    // Add an entry to the firstname arraylist
    public static void add2EFNUpdates(ObjectToIntMap firstNameUpdate) {
        EFNUpdates.add(firstNameUpdate);
    }

    // Add a record to the delete arraylist
    public static void addToDelete(int rowId) {
        rowsToDelete.add(new Integer(rowId));
    }
}
