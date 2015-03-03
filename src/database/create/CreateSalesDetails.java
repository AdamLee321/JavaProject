package database.create;

import java.sql.*;

/**
 * Created by User on 02/03/2015.
 */
public class CreateSalesDetails {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateEmployee(Connection connIn) {
        conn = connIn;
    }

}
