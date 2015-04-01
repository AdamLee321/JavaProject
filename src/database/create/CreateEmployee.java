package database.create;

import java.io.File;
import java.io.FileInputStream;
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
                    "empPic BLOB," +
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
            String sqlData = "INSERT INTO employee (empId, deptId, empFName, empLName, position, empStreet, empCity, empCounty, empDOBd, empDOBm, empDOBy, empEmail, salary, empPic, empUsername, empPassword)" +
                    "VALUES (empSeq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

                                // employee id SEQUENCE
            pstmt.setInt(1, 4); // department id
            pstmt.setString(2, "Ermac"); // employee first name
            pstmt.setString(3, "Ward"); // employee last name
            pstmt.setString(4, "Sales"); // employee position
            pstmt.setString(5, "Wright Court"); // employee street
            pstmt.setString(6, "Tallaght"); // employee city
            pstmt.setString(7, "Dublin"); // employee county
            pstmt.setInt(8, 1); // employee dob day
            pstmt.setString(9, "Feb"); // employee dob month
            pstmt.setInt(10, 1984); // employee dob year
            pstmt.setString(11, "ermac.ward@gmail.com");  //employee email
            pstmt.setInt(12, 12000); // employee salary
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/ermac.png"))); // employee picture BLOB
            pstmt.setString(14, "ruthward"); // employee username
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055"); // employee password
            pstmt.execute();

            pstmt.setInt(1, 4);
            pstmt.setString(2, "Sub");
            pstmt.setString(3, "Zero");
            pstmt.setString(4, "Admin");
            pstmt.setString(5, "2 Carriers Road");
            pstmt.setString(6, "Crumlin");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 8);
            pstmt.setString(9, "May");
            pstmt.setInt(10, 1984);
            pstmt.setString(11, "sub.zero@gmail.com");
            pstmt.setInt(12, 19000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/subzero.png")));
            pstmt.setString(14, "normabrown");
            pstmt.setString(15, "827ccb0eea8a706c4c34a16891f84e7b");
            pstmt.execute();

            pstmt.setInt(1,5);
            pstmt.setString(2, "Sonya");
            pstmt.setString(3, "Blade");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "31 Monks Way");
            pstmt.setString(6, "Bluebell");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 9);
            pstmt.setString(9, "JUL");
            pstmt.setInt(10, 1969);
            pstmt.setString(11, "sonya.blade@outlook.com");
            pstmt.setInt(12, 17000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/sonya.png")));
            pstmt.setString(14, "sonyablade");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Striker");
            pstmt.setString(3, "Watson");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "76 Bridge Street");
            pstmt.setString(6, "Ranlagh");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 17);
            pstmt.setString(9, "APR");
            pstmt.setInt(10, 1971);
            pstmt.setString(11, "striker.watson@yahoo.co.uk");
            pstmt.setInt(12, 24000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/striker.png")));
            pstmt.setString(14, "strikerwatson");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setString(2, "Smoke");
            pstmt.setString(3, "Martin");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "4 Shore Street");
            pstmt.setString(6, "Terenure");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 30);
            pstmt.setString(9, "APR");
            pstmt.setInt(10, 1974);
            pstmt.setString(11, "smoke.martin@hotmail.com");
            pstmt.setInt(12, 12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/smoke.png")));
            pstmt.setString(14, "smokemartin");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2, "Mileena");
            pstmt.setString(3, "Brooks");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "7 London Road");
            pstmt.setString(6, "Finglas");
            pstmt.setString(7 ,"Dublin");
            pstmt.setInt(8, 26);
            pstmt.setString(9, "DEC");
            pstmt.setInt(10, 1973);
            pstmt.setString(11, "mileena.brooks@gmail.com");
            pstmt.setInt(12, 23500);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/mileena.png")));
            pstmt.setString(14, "mileenabrooks");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2, "Sindel");
            pstmt.setString(3, "Reed");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "3 Middlewich Road");
            pstmt.setString(6, "Coolock");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 15);
            pstmt.setString(9, "JUN");
            pstmt.setInt(10, 1993);
            pstmt.setString(11, "sindel.reed@gmail.com");
            pstmt.setInt(12, 16000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/sindel.png")));
            pstmt.setString(14, "sindelreed");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Liu");
            pstmt.setString(3, "Kang");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "76 Jubilee Drive");
            pstmt.setString(6, "Dundrum");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 21);
            pstmt.setString(9, "JUN");
            pstmt.setInt(10, 1971);
            pstmt.setString(11, "liu.kang@hotmail.com");
            pstmt.setInt(12, 12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/liukang.png")));
            pstmt.setString(14, "liukang");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 4);
            pstmt.setString(2, "Jade");
            pstmt.setString(3, "Hernandez");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "42 Wressle Road");
            pstmt.setString(6, "Rathcoole");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 28);
            pstmt.setString(9, "APR");
            pstmt.setInt(10, 1979);
            pstmt.setString(11, "jade.hernandez@yahoo.co.uk");
            pstmt.setInt(12, 12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/jade.png")));
            pstmt.setString(14, "jadehernandez");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Kano");
            pstmt.setString(3, "Bailey");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "14 Berkeley Rd");
            pstmt.setString(6, "Ballyfermot");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 11);
            pstmt.setString(9, "JUL");
            pstmt.setInt(10, 1981);
            pstmt.setString(11, "kano.bailey@yahoo.co.uk");
            pstmt.setInt(12, 12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/kano.png")));
            pstmt.setString(14, "kanobailey");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Noob");
            pstmt.setString(3, "Saibot");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "87 Middlewich Road");
            pstmt.setString(6, "Palmerstown");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 11);
            pstmt.setString(9, "JUL");
            pstmt.setInt(10, 1987);
            pstmt.setString(11, "noob.saibot@outlook.com");
            pstmt.setInt(12, 19000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/noobsaibot.png")));
            pstmt.setString(14, "noobsaibot");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Kabal");
            pstmt.setString(3, "Jones");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "71 Russell Rd");
            pstmt.setString(6, "Blackrock");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 11);
            pstmt.setString(9, "MAR");
            pstmt.setInt(10, 1984);
            pstmt.setString(11, "kobal.jones@gmail.com");
            pstmt.setInt(12,14500);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/kabal.png")));
            pstmt.setString(14, "kabaljones");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Kitana");
            pstmt.setString(3, "Miller");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "82 Broad Street");
            pstmt.setString(6, "Rathmines");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 4);
            pstmt.setString(9, "JAN");
            pstmt.setInt(10, 1989);
            pstmt.setString(11, "kitana.miller@hotmail.com");
            pstmt.setInt(12,12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/kitana.png")));
            pstmt.setString(14, "kitanamiller");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Reptile");
            pstmt.setString(3, "Evans");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "48 Red Lane");
            pstmt.setString(6, "Inchicore");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 28);
            pstmt.setString(9, "DEC");
            pstmt.setInt(10, 1993);
            pstmt.setString(11, "reptile.evans@yahoo.co.uk");
            pstmt.setInt(12, 22000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/reptile.png")));
            pstmt.setString(14, "reptileevans");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2, "Cyrax");
            pstmt.setString(3, "Garcia");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "7 Helland Bridge");
            pstmt.setString(6, "Crumlin");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 10);
            pstmt.setString(9, "MAY");
            pstmt.setInt(10, 1992);
            pstmt.setString(11, "smoke.garcia@outlook.com");
            pstmt.setInt(12, 12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/cyrax.png")));
            pstmt.setString(14, "smokegarcia");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 2);
            pstmt.setString(2, "Scorpion");
            pstmt.setString(3, "Perry");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "40 Fraserburgh Rd");
            pstmt.setString(6, "Terenure");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 10);
            pstmt.setString(9, "MAY");
            pstmt.setInt(10, 1979);
            pstmt.setString(11, "scorpion.perry@gmail.com");
            pstmt.setInt(12, 22000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/scorpion.png")));
            pstmt.setString(14, "scorpionperry");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 4);
            pstmt.setString(2, "Jax");
            pstmt.setString(3, "James");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "92 Horsefair Green");
            pstmt.setString(6, "Terenure");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 10);
            pstmt.setString(9, "MAY");
            pstmt.setInt(10, 1981);
            pstmt.setString(11, "jax.jones@outlook.com");
            pstmt.setInt(12, 16000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/jax.png")));
            pstmt.setString(14, "jaxjames");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Kung");
            pstmt.setString(3, "Lao");
            pstmt.setString(4, "Sales");
            pstmt.setString(5, "94 Iffley Road");
            pstmt.setString(6, "Finglas");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 10);
            pstmt.setString(9, "MAY");
            pstmt.setInt(10, 1985);
            pstmt.setString(11, "kung.lao@hotmail.com");
            pstmt.setInt(12, 17500);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/kunglao.png")));
            pstmt.setString(14, "kunglao");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Nightwolf");
            pstmt.setString(3, "Lee");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "7 Southern Way");
            pstmt.setString(6, "Ranlagh");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 26);
            pstmt.setString(9, "SEP");
            pstmt.setInt(10, 1984);
            pstmt.setString(11, "nightwolf.lee@gmail.com");
            pstmt.setInt(12, 12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/nightwolf.png")));
            pstmt.setString(14, "nightwolflee");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "Shang");
            pstmt.setString(3, "Tsung");
            pstmt.setString(4, "Manager");
            pstmt.setString(5, "7 Southern Way");
            pstmt.setString(6, "Ranlagh");
            pstmt.setString(7, "Dublin");
            pstmt.setInt(8, 12);
            pstmt.setString(9, "OCT");
            pstmt.setInt(10, 1980);
            pstmt.setString(11, "shang.tsung@gmail.com");
            pstmt.setInt(12, 12000);
            pstmt.setBinaryStream(13, savePic2DB(new File("src/res/images/Employees/shangtsung.png")));
            pstmt.setString(14, "shangtsung");
            pstmt.setString(15, "81dc9bdb52d04dc20036dbd8313ed055");
            pstmt.execute();

        } catch (SQLException e) {
        System.out.println(e);
        }
    }

    // method for inserting images as blobs
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