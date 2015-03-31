package database.create;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class CreateEmployee {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateEmployee(Connection connIn) {
        conn = connIn;
    }

    public void dropEmployeesTable() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP SEQUENCE empSeq");
                System.out.println("Employee sequence dropped successfully");
            } catch (SQLException e) {
            }
            try {
                stmt.execute("DROP TABLE employee");
                System.out.println("Employee table dropped successfully\n");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createEmployeesTable() {
        try {
            // create employee table
            stmt = conn.createStatement();
            String sqlTable = "CREATE TABLE employee(" +
                    "empId INTEGER," +
                    "deptId INTEGER," +
                    "empFName VARCHAR2(30)," +
                    "empLName VARCHAR2(30)," +
                    "position VARCHAR2(30)," +
                    "empStreet VARCHAR2(80)," +
                    "empCity VARCHAR2(20)," +
                    "empCounty VARCHAR2(25)," +
                    "empDOBd INTEGER," +
                    "empDOBm VARCHAR2(20)," +
                    "empDOBy INTEGER," +
                    "empEmail VARCHAR2(70)," +
                    "salary NUMBER," +
                    "empUsername VARCHAR2(30)," +
                    "empPassword VARCHAR2(32)," +
                    "empPicUrl VARCHAR2(255)," +
                    "PRIMARY KEY(empId)," +
                    "FOREIGN KEY(deptId) references department(deptId) on delete set null" +
                    ")";
            System.out.println("Employee table created successfully");
            stmt.execute(sqlTable);
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            // create employee id sequence
            String sqlSequence = "CREATE SEQUENCE empSeq INCREMENT BY 1 START WITH 1";
            stmt.execute(sqlSequence);
            System.out.println("Employee sequence created successfully\n");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            String sqlData = "INSERT INTO employee (empId, deptId, empFName, empLName, position, empStreet, empCity, empCounty, empDOBd, empDOBm, empDOBy, empEmail, salary, empPicUrl, empUsername, empPassword)" +
                    "VALUES (empSeq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

                                // employee id SEQUENCE
            pstmt.setInt(1, 4); // department id
            pstmt.setString(2, "Rush"); // employee first name
            pstmt.setString(3, "Ward"); // employee last name
            pstmt.setString(4, "Sales"); // employee position
            pstmt.setString(5, "Wright Court"); // employee street
            pstmt.setString(6, "Tallaght"); // employee city
            pstmt.setString(7, "Dublin"); // employee county
            pstmt.setInt(8, 1); // employee dob day
            pstmt.setString(9, "Feb"); // employee dob month
            pstmt.setInt(10, 1984); // employee dob year
            pstmt.setString(11, "ruth.ward@gmail.com");  //employee email
            pstmt.setInt(12, 12000); // employee salary
            pstmt.setString(13, "0"); // employee picture
            pstmt.setString(14, "ruthward"); // employee username
            //pstmt.setString(15, "1234"); // employee password
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055"); // employee password
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2, "Norma");
            pstmt.setString(3, "Brown");
            pstmt.setString(4, "Admin");
            pstmt.setString(5, "2 Carriers Road");
            pstmt.setString(6, "Crumlin");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 8);
            pstmt.setString(9, "May");
            pstmt.setInt(10, 1984);
            pstmt.setString(11, "norma.brown@gmail.com");
            pstmt.setInt(12, 19000);
            pstmt.setString(13, "0");
            pstmt.setString(14, "normabrown");
            //pstmt.setString(15, "12345");
            pstmt.setString(15, "827ccb0eea8a706c4c34a16891f84e7b");
            pstmt.execute();

            pstmt.setInt(1,5);
            pstmt.setString(2, "Teresa");
            pstmt.setString(3, "Griffin");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "31 Monks Way");
            pstmt.setString(6, "Bluebell");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 9);
            pstmt.setString(9, "JUL");
            pstmt.setInt(10, 1969);
            pstmt.setString(11, "Teresa.griffin@outlook.com");
            pstmt.setInt(12, 17000);
            pstmt.setString(13, "0");
            pstmt.setString(14, "teresagriffin");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

/*
            pstmt.setInt(1,3);
            pstmt.setString(2, "Arthur");
            pstmt.setString(3, "Watson");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "76 Bridge Street");
            pstmt.setString(6, "Ranlagh");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "17-APR-1971");
            pstmt.setString(9, "Arthur.watson@yahoo.co.uk");
            pstmt.setInt(10, 24000);
            pstmt.setString(11, null);
            pstmt.setString(12, "arthurwatson");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setString(2, "Fred");
            pstmt.setString(3, "Martin");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "4 Shore Street");
            pstmt.setString(6, "Terenure");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "30-APR-1974");
            pstmt.setString(9, "Fred.martin@hotmail.com");
            pstmt.setInt(10, 12000);
            pstmt.setString(11, null);
            pstmt.setString(12, "fredmartin");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2, "Melissa");
            pstmt.setString(3, "Brooks");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "7 London Road");
            pstmt.setString(6, "Finglas");
            pstmt.setString(7 ,"Dublin");
            pstmt.setString(8, "26-DEC-1973");
            pstmt.setString(9, "Melissa.brooks@gmail.com");
            pstmt.setInt(10, 23500);
            pstmt.setString(11, null);
            pstmt.setString(12, "melissabrooks");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2, "Sara");
            pstmt.setString(3, "Reed");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "3 Middlewich Road");
            pstmt.setString(6, "Coolock");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "15-JUN-1993");
            pstmt.setString(9, "Sara.reed@gmail.com");
            pstmt.setInt(10, 16000);
            pstmt.setString(11, null);
            pstmt.setString(12, "sarareed");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Sean");
            pstmt.setString(3, "Torres");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "76 Jubilee Drive");
            pstmt.setString(6, "Dundrum");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "21-JUN-1971");
            pstmt.setString(9, "Sean.torres@hotmail.com");
            pstmt.setInt(10, 12000);
            pstmt.setString(11, null);
            pstmt.setString(12, "seartorres");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2, "Angela");
            pstmt.setString(3, "Hernandez");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "42 Wressle Road");
            pstmt.setString(6, "Rathcoole");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "28-APR-1979");
            pstmt.setString(9, "Angela.hernandez@yahoo.co.uk");
            pstmt.setInt(10, 12000);
            pstmt.setString(11, null);
            pstmt.setString(12, "angelahernandez");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Stephen");
            pstmt.setString(3, "Bailey");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "14 Berkeley Rd");
            pstmt.setString(6, "Ballyfermot");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "11-JUN-1981");
            pstmt.setString(9, "Stephen.bailey@yahoo.co.uk");
            pstmt.setInt(10, 12000);
            pstmt.setString(11, null);
            pstmt.setString(12, "stephenbailey");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Beverly");
            pstmt.setString(3, "Wright");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "87 Middlewich Road");
            pstmt.setString(6, "Palmerstown");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "15-JUN-1987");
            pstmt.setString(9, "Beverly.wright@outlook.com");
            pstmt.setInt(10, 19000);
            pstmt.setString(11, null);
            pstmt.setString(12, "beverlywright");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Willie");
            pstmt.setString(3, "Jones");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "71 Russell Rd");
            pstmt.setString(6, "Blackrock");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "05-MAR-1984");
            pstmt.setString(9, "Willie.jones@gmail.com");
            pstmt.setInt(10,14500);
            pstmt.setString(11, null);
            pstmt.setString(12, "williejones");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Marie");
            pstmt.setString(3, "Miller");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "82 Broad Street");
            pstmt.setString(6, "Rathmines");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "04-JAN-1989");
            pstmt.setString(9, "Marie.miller@hotmail.com");
            pstmt.setInt(10,12000);
            pstmt.setString(11, null);
            pstmt.setString(12, "mariemiller");
            pstmt.setString(13, "1234");
            pstmt.execute();


            pstmt.setInt(1,3);
            pstmt.setString(2, "Melissa");
            pstmt.setString(3, "Evans");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "48 Red Lane");
            pstmt.setString(6, "Inchicore");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "28-DEC-1993");
            pstmt.setString(9, "Melissa.evans@yahoo.co.uk");
            pstmt.setInt(10, 22000);
            pstmt.setString(11, null);
            pstmt.setString(12, "mellisaevans");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Kimberly");
            pstmt.setString(3, "Garcia");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "7 Helland Bridge");
            pstmt.setString(6, "Crumlin");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "10-MAY-1992");
            pstmt.setString(9, "Kimberly.garcia@outlook.com");
            pstmt.setInt(10, 12000);
            pstmt.setString(11, null);
            pstmt.setString(12, "kimberlygarcia");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,2);
            pstmt.setString(2, "Gerald");
            pstmt.setString(3, "Perry");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "40 Fraserburgh Rd");
            pstmt.setString(6, "Terenure");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "23-MAY-1979");
            pstmt.setString(9, "Gerald.perry@gmail.com");
            pstmt.setInt(10, 22000);
            pstmt.setString(11, null);
            pstmt.setString(12, "geraldperry");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2, "Jeffrey");
            pstmt.setString(3, "James");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "92 Horsefair Green");
            pstmt.setString(6, "Terenure");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "08-MAY-1981");
            pstmt.setString(9, "Jeffery.jones@outlook.com");
            pstmt.setInt(10, 16000);
            pstmt.setString(11, null);
            pstmt.setString(12, "jeffreyjames");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Kelly");
            pstmt.setString(3, "Hall");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "94 Iffley Road");
            pstmt.setString(6, "Finglas");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "29-MAY-1985");
            pstmt.setString(9, "Kelly.hall@hotmail.com");
            pstmt.setInt(10, 17500);
            pstmt.setString(11, null);
            pstmt.setString(12, "kellyhall");
            pstmt.setString(13, "1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Philip");
            pstmt.setString(3, "Lee");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "7 Southern Way");
            pstmt.setString(6, "Ranlagh");
            pstmt.setString(7, "Dublin");
            pstmt.setString(8, "26-SEP-1984");
            pstmt.setString(9, "Philip.lee@gmail.com");
            pstmt.setInt(10,12000);
            pstmt.setString(11, null);
            pstmt.setString(12, "philiplee");
            pstmt.setString(13, "1234");
            pstmt.execute();
            */
        } catch (SQLException e) {
        System.out.println(e);
        }
    }
}