package database;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLExceptionHandler {
    public static void handleException(SQLException se, Connection conn)
    {
        // If error and connected, rollback changes
        try {
            if (conn != null)
                conn.rollback();
        }
        catch (SQLException se2) {}

        // Print SQL error details
        System.out.println ("\nSQLException\n");
        while (se != null) {
            System.out.println("SQL State: " + se.getSQLState ());
            System.out.println("Message: " + se.getMessage ());
            System.out.println ("Error Code: " + se.getErrorCode ());
            se = se.getNextException ();
            System.out.println ("");
        }
    }
}
