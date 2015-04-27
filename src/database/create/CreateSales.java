package database.create;

import java.sql.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 02/03/2015)
*/

public class CreateSales {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateSales(Connection connIn) {

        conn = connIn;
    }

    public void dropSalesTable() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP SEQUENCE saleSeq");
                System.out.println("Sales sequence dropped successfully");
            } catch (SQLException e) {
            }
            try {
                stmt.execute("DROP TABLE sales");
                System.out.println("Sales table dropped successfully\n");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createSalesTable() {
        try {
            // create sales table
            stmt = conn.createStatement();
            String sqlTable = "CREATE TABLE sales(" +
                    "saleId INTEGER," +
                    "empId INTEGER," +
                    "prodId INTEGER," +
                    "saleDay VARCHAR(20)," +
                    "saleMonth VARCHAR(20)," +
                    "saleYear VARCHAR(20)," +
                    "saleTime VARCHAR(20)," +
                    "saleDiscount NUMBER(4,2)," +
                    "saleAmount NUMBER(6,2)," +
                    "PRIMARY KEY (saleId)," +
                    "FOREIGN KEY (empId) references employee(empId) ON DELETE SET NULL" +
                    ")";
            System.out.println("Sales table created successfully");
            stmt.execute(sqlTable);
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            // create sales id sequence
            String sqlSequence = "CREATE SEQUENCE saleSeq INCREMENT BY 1 START WITH 1";
            stmt.execute(sqlSequence);
            System.out.println("Sales sequence created successfully\n");
        } catch (SQLException e){
            System.out.println(e);
        }
        try {
            //
            String sqlData = "INSERT INTO sales(saleId, empId, prodId, saleDay,saleMonth, saleYear, saleTime, saleDiscount, saleAmount)" +
                    "VALUES(saleSeq.nextVal,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

            pstmt.setInt(1,3);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "02");
            pstmt.setString(4, "JANUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "10:15");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 269.99);
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "06");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "14:08");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 299.99);
            pstmt.execute();

            pstmt.setInt(1,5);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "08");
            pstmt.setString(4, "MARCH");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "12:49");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1599.99);
            pstmt.execute();

            pstmt.setInt(1,6);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "08");
            pstmt.setString(4, "FEBRUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "15:15");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1349);
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "09");
            pstmt.setString(4, "FEBRUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "16:43");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 2099.99);
            pstmt.execute();

            pstmt.setInt(1,2);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "14");
            pstmt.setString(4, "FEBRUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "12:31");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 2055.99);
            pstmt.execute();

            pstmt.setInt(1,2);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "16");
            pstmt.setString(4, "FEBRUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "18:27");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 899.99);
            pstmt.execute();

            pstmt.setInt(1,10);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "19");
            pstmt.setString(4, "MARCH");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "17:32");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 329.99);
            pstmt.execute();

            pstmt.setInt(1,2);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "20");
            pstmt.setString(4, "MARCH");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "17:59");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 529.99);
            pstmt.execute();

            pstmt.setInt(1,6);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "10");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "12:36");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1399.99);
            pstmt.execute();

            pstmt.setInt(1,11);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "15");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "15:45");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 599.99);
            pstmt.execute();

            pstmt.setInt(1,12);
            pstmt.setInt(2,100002);
            pstmt.setString(3, "19");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "14:45");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 799.99);
            pstmt.execute();

            pstmt.setInt(1,13);
            pstmt.setInt(2,100002);
            pstmt.setString(3, "21");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "11:21");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1999.99);
            pstmt.execute();

            pstmt.setInt(1,15);
            pstmt.setInt(2,100003);
            pstmt.setString(3, "31");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "11:19");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1599.99);
            pstmt.execute();

            pstmt.setInt(1,14);
            pstmt.setInt(2,100004);
            pstmt.setString(3, "24");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "13:15");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 499.99);
            pstmt.execute();

            pstmt.setInt(1,14);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "24");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "14:54");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 699.99);
            pstmt.execute();

            pstmt.setInt(1,14);
            pstmt.setInt(2,100005);
            pstmt.setString(3, "26");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "18:04");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 999.99);
            pstmt.execute();

            pstmt.setInt(1,14);
            pstmt.setInt(2,100002);
            pstmt.setString(3, "24");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "12:08");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 559.99);
            pstmt.execute();

            pstmt.setInt(1, 4);
            pstmt.setInt(2,100001);
            pstmt.setString(3, "24");
            pstmt.setString(4, "APRIL");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "12:34");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 359.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100003);
            pstmt.setString(3, "24");
            pstmt.setString(4, "MARCH");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "16:01");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1799.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000016);
            pstmt.setString(3, "14");
            pstmt.setString(4, "JANUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "13:10");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 999.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000017);
            pstmt.setString(3, "07");
            pstmt.setString(4, "JANUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "12:26");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 799.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000012);
            pstmt.setString(3, "12");
            pstmt.setString(4, "DECEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "15:49");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 459.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000011);
            pstmt.setString(3, "17");
            pstmt.setString(4, "AUGUST");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "11:40");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 599.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100002);
            pstmt.setString(3, "20");
            pstmt.setString(4, "DECEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "12:29");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 599.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100008);
            pstmt.setString(3, "09");
            pstmt.setString(4, "NOVEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "10:59");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 399.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100004);
            pstmt.setString(3, "16");
            pstmt.setString(4, "NOVEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "11:00");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 599.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100009);
            pstmt.setString(3, "31");
            pstmt.setString(4, "OCTOBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "15:14");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 199.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100024);
            pstmt.setString(3, "16");
            pstmt.setString(4, "NOVEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "12:04");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1799.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100007);
            pstmt.setString(3, "19");
            pstmt.setString(4, "SEPTEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "10:35");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 699.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100006);
            pstmt.setString(3, "18");
            pstmt.setString(4, "DECEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "14:30");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 499.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100006);
            pstmt.setString(3, "20");
            pstmt.setString(4, "DECEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "13:19");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 499.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100024);
            pstmt.setString(3, "20");
            pstmt.setString(4, "DECEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "15:55");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 699.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000024);
            pstmt.setString(3, "23");
            pstmt.setString(4, "DECEMBER");
            pstmt.setString(5, "2014");
            pstmt.setString(6, "16:20");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1698.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000016);
            pstmt.setString(3, "12");
            pstmt.setString(4, "JANUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "13:05");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 499.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000014);
            pstmt.setString(3, "24");
            pstmt.setString(4, "JANUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "13:46");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1699.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100005);
            pstmt.setString(3, "13");
            pstmt.setString(4, "FEBRUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "17:44");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 399.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,1000040);
            pstmt.setString(3, "12");
            pstmt.setString(4, "FEBRUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "16:01");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 1299.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100007);
            pstmt.setString(3, "19");
            pstmt.setString(4, "JANUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "11:24");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 499.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setInt(2,100006);
            pstmt.setString(3, "21");
            pstmt.setString(4, "JANUARY");
            pstmt.setString(5, "2015");
            pstmt.setString(6, "13:59");
            pstmt.setDouble(7, 0);
            pstmt.setDouble(8, 399.99);
            pstmt.execute();

        } catch (SQLException e){
            System.out.println(e);
        }
    }
}