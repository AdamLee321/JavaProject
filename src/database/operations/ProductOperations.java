package database.operations;

import database.ConnectionDB;
import model.Product;

import java.io.File;
import java.io.FileInputStream;
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
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, " +
                  "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodDesc " +
                  "like '%" +keyword +"%'";
        }
        else {
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, prodPic," +
                  "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodDesc " +
                  "like '%" + keyword + "%' AND prodType = '" + category +"'";
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
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, prodPic," +
                    "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT";
        }
        else
            sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, prodPic," +
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

    public Product productByIDO(int id){
        Product p = null;
        String sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY," +
                "prodPic, prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT WHERE prodId = '"+id+"'";
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            while (rset.next()) {
                 p = new Product(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4),
                         rset.getDouble(5), rset.getInt(6), rset.getBytes(7), rset.getString(8), rset.getString(9),
                         rset.getString(10),rset.getString(11), rset.getString(12), rset.getString(13),
                         rset.getString(14));
            }
        }catch(SQLException sqlE){
            System.out.println("Error in ResultSet to product Conversion");
        }
        return p;
    }

    public ResultSet productByIDR(int id){
        String sql = "SELECT prodId, prodMake, prodModel, prodSalePrice FROM PRODUCT WHERE prodId = '"+id+"'";
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
        }catch(SQLException sqlE){
            System.out.println("Error in ResultSet to product Conversion");
        }
        return rset;
    }

    public int checkQuantity(int id){
        int quantityInStock = 0;
        String sql = "SELECT prodQty FROM product WHERE prodId = '"+id+"'";
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            while (rset.next()){
                quantityInStock = rset.getInt(1);
            }

        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }
        System.out.println(quantityInStock);
        return quantityInStock;
    }

    public boolean checkProduct(int id){
        boolean x = false;
        String sql = "SELECT prodQty FROM product WHERE prodId = '"+id+"'";
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
            x = false;
        }
        System.out.println(x);
        return x;
    }

    public void insertProduct(String make, String model, double salePrice, double costPrice, int qty, File prodPic,
                              String prodType, String cpu, String ram, String os, String storage, String screen,
                              String description){

        String sql = "INSERT INTO Product (prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, " +
                "prodQTY, prodPic, prodType, cpu, ram, operatingSystem, storage, screen, prodDesc) VALUES " +
                "(productSeq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, make);//prodMake
            pstmt.setString(2, model);//prodModel
            pstmt.setDouble(3, salePrice);//prodSalePrice
            pstmt.setDouble(4, costPrice);//prodCostPrice
            pstmt.setInt(5, qty);//prodQTY
            pstmt.setBinaryStream(6, savePic2DB(prodPic));//prodPic
            pstmt.setString(7, prodType);//prodType
            pstmt.setString(8, cpu);//cpu
            pstmt.setString(9, ram);//ram
            pstmt.setString(10, os);//operatingSystem
            pstmt.setString(11, storage);//storage
            pstmt.setString(12, screen);//screen
            pstmt.setString(13, description);//prodDesc
            pstmt.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ResultSet getAllProducts(){
        String sql ="SELECT prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, prodQTY, " +
                "prodType, cpu, ram, OperatingSystem, storage, screen, prodDesc FROM PRODUCT";
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }
        return rset;
    }

    public void updateProduct(String make, String model, double salePrice, double costPrice, int qty, File prodPic,
                              String prodType, String cpu, String ram, String os, String storage, String screen,
                              String description, int id){
        String sql = "Update Product SET prodMake = ?, prodModel = ?, prodSalePrice = ?, prodCostPrice = ?," +
                "prodQTY  = ?, prodPic = ?, prodType = ?, cpu = ?, ram = ?, operatingSystem = ?, storage = ?, screen = ?, " +
                "prodDesc = ? WHERE prodId = ?";
        try{
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, make);//prodMake
            pstmt.setString(2, model);//prodModel
            pstmt.setDouble(3, salePrice);//prodSalePrice
            pstmt.setDouble(4, costPrice);//prodCostPrice
            pstmt.setInt(5, qty);//prodQTY
            pstmt.setBinaryStream(6, savePic2DB(prodPic));//prodPic
            pstmt.setString(7, prodType);//prodType
            pstmt.setString(8, cpu);//cpu
            pstmt.setString(9, ram);//ram
            pstmt.setString(10, os);//operatingSystem
            pstmt.setString(11, storage);//storage
            pstmt.setString(12, screen);//screen
            pstmt.setString(13, description);//prodDesc
            pstmt.setInt(14, id);
            pstmt.execute();
            System.out.println("Successful update");
        }catch(SQLException e){
            System.out.println("fuck");
            System.out.println(e.getMessage());
        }
    }

    public int getNextID(){
        int max = 0;
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT MAX(prodId) FROM product");
            while (rset.next()){
                max = rset.getInt(1);
            }
        }catch (SQLException sqlE){
            System.out.println("Error getting the maximum id");
        }
        return (max +1);
    }

    

    public FileInputStream savePic2DB(File pic) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(pic);
        } catch (Exception e) {
            System.out.println(e);
        }
        return in;
    }
}
