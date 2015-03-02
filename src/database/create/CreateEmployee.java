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
    private PreparedStatement pstmt = null;
    private Statement stmt = null;

    public CreateEmployee(Connection connIn){

        conn = connIn;
    }

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
            stmt = conn.createStatement();
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
                    ")";
            stmt.execute(sqlTable);

            // create employee id sequence
            String sqlSequence = "create sequence empId_seq increment by 1 start with 1";
            stmt.execute(sqlSequence);

            // insert data into employee table
            String sqlData = "INSERT INTO employee(empId,deptId,empFName,empLName,position,empStreet,empCity,empCounty,empDOB,empEmail,salary,empPicUrl,empUsername,empPassword)" +
                    "values(empId_seq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

            // employee id SEQUENCE
            // department id
            // employee first name
            // employee last name
            // employee position
            // employee street
            // employee city
            // employee county
            // employee dob
            // employee email
            // employee salary
            // employee picture
            // employee username
            // employee password


            pstmt.setInt(1,2);
            pstmt.setString(2,"Ruth");
            pstmt.setString(3,"Ward");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"41 Wright Court");
            pstmt.setString(6,"Tallaght");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"03-05-1967");
            pstmt.setString(9,"ruth.ward@gmail.com");
            pstmt.setInt(10,12000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"ruthward");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2,"Norma");
            pstmt.setString(3,"Brown");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"2 Carriers Road");
            pstmt.setString(6,"Crumlin");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"08-05-1967");
            pstmt.setString(9,"norma.brown@gmail.com");
            pstmt.setInt(10, 19000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"normabrown");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,5);
            pstmt.setString(2,"Teresa");
            pstmt.setString(3,"Griffin");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"31 Monks Way");
            pstmt.setString(6,"Bluebell");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"09-07-1969");
            pstmt.setString(9,"Teresa.griffin@outlook.com");
            pstmt.setInt(10, 17000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"teresagriffin");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Arthur");
            pstmt.setString(3, "Watson");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"76 Bridge Street");
            pstmt.setString(6,"Ranlagh");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"17-04-1971");
            pstmt.setString(9,"Arthur.watson@yahoo.co.uk");
            pstmt.setInt(10, 24000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"arthurwatson");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setString(2, "Fred");
            pstmt.setString(3,"Martin");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"4 Shore Street");
            pstmt.setString(6,"Terenure");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"30-04-1974");
            pstmt.setString(9,"Fred.martin@hotmail.com");
            pstmt.setInt(10, 12000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"fredmartin");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2,"Melissa");
            pstmt.setString(3,"Brooks");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"7 London Road");
            pstmt.setString(6,"Finglas");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"26-12-1973");
            pstmt.setString(9,"Melissa.brooks@gmail.com");
            pstmt.setInt(10, 23500);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"melissabrooks");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2,"Sara");
            pstmt.setString(3,"Reed");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"3 Middlewich Road");
            pstmt.setString(6,"Coolock");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"15-06-1993");
            pstmt.setString(9,"Sara.reed@gmail.com");
            pstmt.setInt(10, 16000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"sarareed");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Sean");
            pstmt.setString(3,"Torres");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"76 Jubilee Drive");
            pstmt.setString(6,"Dundrum");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"21-06-1971");
            pstmt.setString(9,"Sean.torres@hotmail.com");
            pstmt.setInt(10, 12000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"seartorres");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2,"Angela");
            pstmt.setString(3,"Hernandez");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"42 Wressle Road");
            pstmt.setString(6,"Rathcoole");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"28-04-1979");
            pstmt.setString(9,"Angela.hernandez@yahoo.co.uk");
            pstmt.setInt(10, 12000);
            pstmt.setString(10,"NULL");
            pstmt.setString(11,"angelahernandez");
            pstmt.setString(12,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Stephen");
            pstmt.setString(3,"Bailey");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"14 Berkeley Rd");
            pstmt.setString(6,"Ballyfermot");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"11-06-1981");
            pstmt.setString(9,"Stephen.bailey@yahoo.co.uk");
            pstmt.setInt(10, 12000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"stephenbailey");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Beverly");
            pstmt.setString(3,"Wright");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"87 Middlewich Road");
            pstmt.setString(6,"Palmerstown");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"15-06-1987");
            pstmt.setString(9,"Beverly.wright@outlook.com");
            pstmt.setInt(10, 19000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"beverlywright");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Willie");
            pstmt.setString(3,"Jones");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"71 Russell Rd");
            pstmt.setString(6,"Blackrock");
            pstmt.setString(7,"Dublin");
            //pstmt.setDate(8,05/03/1984);
            pstmt.setString(9,"Willie.jones@gmail.com");
            pstmt.setInt(10,14500);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"williejones");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2,"Marie");
            pstmt.setString(3,"Miller");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"82 Broad Street");
            pstmt.setString(6,"Rathmines");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"04-01-1989");
            pstmt.setString(9, "Marie.miller@hotmail.com");
            pstmt.setInt(10,12000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"mariemiller");
            pstmt.setString(13,"1234");
            pstmt.execute();


            pstmt.setInt(1,3);
            pstmt.setString(2,"Melissa");
            pstmt.setString(3,"Evans");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"48 Red Lane");
            pstmt.setString(6,"Inchicore");
            pstmt.setString(7,"Dublin");
            pstmt.setString(8,"28-12-1993");
            pstmt.setString(9,"Melissa.evans@yahoo.co.uk");
            pstmt.setInt(10, 22000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"mellisaevans");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Kimberly");
            pstmt.setString(3,"Garcia");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"7 Helland Bridge");
            pstmt.setString(6,"Crumlin");
            pstmt.setString(7,"Dublin");
           // pstmt.setString(8,"10/05/1992");
            pstmt.setString(9,"Kimberly.garcia@outlook.com");
            pstmt.setInt(10, 12000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"kimberlygarcia");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,2);
            pstmt.setString(2,"Gerald");
            pstmt.setString(3,"Perry");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"40 Fraserburgh Rd");
            pstmt.setString(6,"Terenure");
            pstmt.setString(7,"Dublin");
          //  pstmt.setString(8,"23/05/1979");
            pstmt.setString(9,"Gerald.perry@gmail.com");
            pstmt.setInt(10, 22000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"geraldperry");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,4);
            pstmt.setString(2,"Jeffrey");
            pstmt.setString(3,"James");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"92 Horsefair Green");
            pstmt.setString(6,"Terenure");
            pstmt.setString(7,"Dublin");
          //  pstmt.setString(8,"08/05/1981");
            pstmt.setString(9,"Jeffery.jones@outlook.com");
            pstmt.setInt(10, 16000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"jeffreyjames");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Kelly");
            pstmt.setString(3,"Hall");
            pstmt.setString(4,"Sales");
            pstmt.setString(5,"94 Iffley Road");
            pstmt.setString(6,"Finglas");
            pstmt.setString(7,"Dublin");
         //   pstmt.setString(8,"29/05/1985");
            pstmt.setString(9,"Kelly.hall@hotmail.com");
            pstmt.setInt(10, 17500);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"kellyhall");
            pstmt.setString(13,"1234");
            pstmt.execute();

            pstmt.setInt(1,3);
            pstmt.setString(2,"Philip");
            pstmt.setString(3,"Lee");
            pstmt.setString(4,"Manager");
            pstmt.setString(5,"7 Southern Way");
            pstmt.setString(6,"Ranlagh");
            pstmt.setString(7,"Dublin");
        //    pstmt.setString(8,"26/09/1984");
            pstmt.setString(9, "Philip.lee@gmail.com");
            pstmt.setInt(10,12000);
            pstmt.setString(11,"NULL");
            pstmt.setString(12,"philiplee");
            pstmt.setString(13,"1234");
            pstmt.execute();

        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
