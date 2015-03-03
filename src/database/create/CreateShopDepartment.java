package database.create;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/**
 * Created by User on 02/03/2015.
 */

public class CreateShopDepartment {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateShopDepartment(Connection connIn) {

        conn = connIn;
    }

    public void dropShopDepartment() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE shopdepartment");
                System.out.println("ShopDepartment Table Dropped");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createShopDepartment() {
        try {
            // create shopdepartment table
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE shopdepartment(" +
                    "shopId INTEGER," +
                    "deptId INTEGER," +
                    "PRIMARY KEY (shopId, deptId)," +
                    "FOREIGN KEY (shopId) REFERENCES shop(shopId)," +
                    "FOREIGN KEY (deptId) REFERENCES department(deptId))");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
