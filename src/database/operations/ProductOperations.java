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
        /*if (category.equals("All")){
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, "+
                                    // Blob prodPic,\n" +
                    "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodDesc like '%" +keyword +"%'";
            System.out.println(sql);
        }
        else {
            sql = "SELECT * FROM PRODUCT WHERE prodDesc like '%" + keyword + "%' AND prodType = '" + category +"'";
            System.out.println(sql);
        }*/
        if (category.equals("All")){
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, "+
                    "FROM PRODUCT WHERE prodDesc like '%" +keyword +"%'";
        }
        else {
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, "+
                    "FROM PRODUCT WHERE prodDesc like '%" + keyword + "%' AND prodType = '" + category +"'";
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
