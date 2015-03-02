package database.create;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class CreateEmployee {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;

    public void dropEmployees() {
        try{
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP SEQUENCE empId_seq");
                System.out.println("Employee Sequence Dropped");
            } catch (SQLException e) {}
            try {
                stmt.execute("DROP TABLE employee");
                System.out.println("Employee Table Dropped");
            } catch (SQLException e) {}
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createEmployees(){
        try{
            // create employee table
            String sqlTable = "CREATE TABLE employee(\n" +
                    "empId NUMBER,\n" +
                    "deptId INTEGER,\n" +
                    "empFName VARCHAR(30),\n" +
                    "empLName VARCHAR(30),\n" +
                    "position VARCHAR2(30),\n" +
                    "empStreet VARCHAR2(80),\n" +
                    "empCity VARCHAR2(20),\n" +
                    "empCounty VARCHAR2(25),\n" +
                    "empDOB DATE,\n" +
                    "empEmail VARCHAR2(70),\n" +
                    "salary NUMBER,\n" +
                    "empPicUrl BLOB,\n" +
                    "empUsername VARCHAR2 (30),\n" +
                    "empPassword VARCHAR(8),\n" +
                    "Primary Key(empId),\n" +
                    "Foreign Key(deptId) references department(deptId) on delete set null\n" +
                    ");";
            pstmt = conn.prepareStatement(sqlTable);
            pstmt.executeUpdate();

            // create employee id sequence
            String sqlSequence = "create sequence empId_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(sqlSequence);
            pstmt.executeUpdate();

            // insert data into employee table
            String sqlData = "INSERT INTO employee(empId,deptId,empFName,empLName,position,empStreet,empCity,empCounty,empDOB,empEmail,salary,empPicUrl,empUsername,empPassword)" +
                    "values(empId_seq.nextVal,dept_seq.currVal,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

            pstmt.setString(1,"Ruth");
            pstmt.setString(2,"Ward");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"41 Wright Court");
            pstmt.setString(5,"Tallaght");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"03/05/1967");
            pstmt.setString(8,"ruth.ward@gmail.com");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Norma");
            pstmt.setString(2,"Brown");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"2 Carriers Road");
            pstmt.setString(5,"Crumlin");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"08/05/1967");
            pstmt.setString(8,"norma.brown@gmail.com");
            pstmt.setString(9,"€19000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Teresa");
            pstmt.setString(2,"Griffin");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"31 Monks Way");
            pstmt.setString(5,"Bluebell");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"09/07/1969");
            pstmt.setString(8,"Teresa.griffin@outlook.com");
            pstmt.setString(9,"€17000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Arthur");
            pstmt.setString(2,"Watson");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"76 Bridge Street");
            pstmt.setString(5,"Ranlagh");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"17/04/1971");
            pstmt.setString(8,"Arthur.watson@yahoo.co.uk");
            pstmt.setString(9,"€24000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Fred");
            pstmt.setString(2,"Martin");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"4 Shore Street");
            pstmt.setString(5,"Terenure");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"30/04/1974");
            pstmt.setString(8,"Fred.martin@hotmail.com");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Melissa");
            pstmt.setString(2,"Brooks");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"7 London Road");
            pstmt.setString(5,"Finglas");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"26/12/1973");
            pstmt.setString(8,"Melissa.brooks@gmail.com");
            pstmt.setString(9,"€23500");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Sara");
            pstmt.setString(2,"Reed");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"3 Middlewich Road");
            pstmt.setString(5,"Coolock");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"15/06/1993");
            pstmt.setString(8,"Sara.reed@gmail.com");
            pstmt.setString(9,"€16000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Sean");
            pstmt.setString(2,"Torres");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"76 Jubilee Drive");
            pstmt.setString(5,"Dundrum");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"21/06/1971");
            pstmt.setString(8,"Sean.torres@hotmail.com");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Angela");
            pstmt.setString(2,"Hernandez");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"42 Wressle Road");
            pstmt.setString(5,"Rathcoole");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"28/04/1979");
            pstmt.setString(8,"Angela.hernandez@yahoo.co.uk");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Stephen");
            pstmt.setString(2,"Bailey");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"14 Berkeley Rd");
            pstmt.setString(5,"Ballyfermot");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"11/06/1981");
            pstmt.setString(8,"Stephen.bailey@yahoo.co.uk");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Beverly");
            pstmt.setString(2,"Wright");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"87 Middlewich Road");
            pstmt.setString(5,"Palmerstown");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"15/06/1987");
            pstmt.setString(8,"Beverly.wright@outlook.com");
            pstmt.setString(9,"€19000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Willie");
            pstmt.setString(2,"Jones");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"71 Russell Rd");
            pstmt.setString(5,"Blackrock");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"05/03/1984");
            pstmt.setString(8,"Willie.jones@gmail.com");
            pstmt.setString(9,"€14500");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Marie");
            pstmt.setString(2,"Miller");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"82 Broad Street");
            pstmt.setString(5,"Rathmines");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"04/01/1989");
            pstmt.setString(8,"Marie.miller@hotmail.com");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Melissa");
            pstmt.setString(2,"Evans");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"48 Red Lane");
            pstmt.setString(5,"Inchicore");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"28/12/1993");
            pstmt.setString(8,"Melissa.evans@yahoo.co.uk");
            pstmt.setString(9,"€22000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Kimberly");
            pstmt.setString(2,"Garcia");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"7 Helland Bridge");
            pstmt.setString(5,"Crumlin");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"10/05/1992");
            pstmt.setString(8,"Kimberly.garcia@outlook.com");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Gerald");
            pstmt.setString(2,"Perry");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"40 Fraserburgh Rd");
            pstmt.setString(5,"Terenure");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"23/05/1979");
            pstmt.setString(8,"Gerald.perry@gmail.com");
            pstmt.setString(9,"€22000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Jeffrey");
            pstmt.setString(2,"James");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"92 Horsefair Green");
            pstmt.setString(5,"Terenure");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"08/05/1981");
            pstmt.setString(8,"Jeffery.jones@outlook.com");
            pstmt.setString(9,"€16000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Kelly");
            pstmt.setString(2,"Hall");
            pstmt.setString(3,"Sales");
            pstmt.setString(4,"94 Iffley Road");
            pstmt.setString(5,"Finglas");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"29/05/1985");
            pstmt.setString(8,"Kelly.hall@hotmail.com");
            pstmt.setString(9,"€17500");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

            pstmt.setString(1,"Philip");
            pstmt.setString(2,"Lee");
            pstmt.setString(3,"Manager");
            pstmt.setString(4,"7 Southern Way");
            pstmt.setString(5,"Ranlagh");
            pstmt.setString(6,"Dublin");
            pstmt.setString(7,"26/09/1984");
            pstmt.setString(8,"Philip.lee@gmail.com");
            pstmt.setString(9,"€12000");
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"NULL");

        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
