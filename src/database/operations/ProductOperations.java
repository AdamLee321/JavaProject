package database.operations;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductOperations {
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    public ProductOperations(Connection conn){
        this.conn = conn;
    }

    public ResultSet searchProducts(String keyword, String category){
        String sql = " ";
        if (category.equals("All")){
            sql = "SELECT * FROM PRODUCTS WHERE prodDesc = '%" +keyword +"%'";
        }
        else {
            sql = "SELECT * FROM PRODUCTS WHERE prodDesc like '%" + keyword + "%' AND prodType = '" + category +"'";
        }
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in Statement");
        }
        return rset;
    }
}
