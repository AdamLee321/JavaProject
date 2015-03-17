package database.operations;

import database.ConnectionDB;
import model.Product;

import java.sql.*;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductOperations {
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    public ProductOperations(){
        this.conn = ConnectionDB.getConn();
    }

    public ResultSet searchProducts(String keyword, String category){
        String sql = " ";
        if (category.equals("All")){
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, "+
                  // Blob prodPic,\n" +
                  "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodDesc " +
                  "like '%" +keyword +"%'";
            System.out.println(sql);

        }
        else {
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY," +
                  "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodDesc " +
                  "like '%" + keyword + "%' AND prodType = '" + category +"'";
            System.out.println(sql);
        }

        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in Statement");
        }
        return rset;
    }

    public ResultSet productCategory(String category){
        String sql = new String();
        if (category.equals("All")){
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, "+
                    // Blob prodPic,\n" +
                    "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT";
        }
        else
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY," +
                "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodType =" +
                "'" + category + "'";

        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
        }catch(SQLException sqlE){
            System.out.println("Error in category query");
        }
        return rset;
    }

    public Product productByID(int id){
        Product p = null;
        String sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY," +
                "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodId = '"+id+"'";
        System.out.println(sql);

        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                 p = new Product(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getDouble(5),
                        rset.getInt(6),
                        //rset.getBlob(7),
                        rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10),
                        rset.getString(11), rset.getString(12), rset.getString(13));
            }

        }catch(SQLException sqlE){
            System.out.println("Error in ResultSet to product Conversion");
        }
        return p;
    }
}
