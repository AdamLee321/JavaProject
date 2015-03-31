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

public class CreateMember {

    private PreparedStatement pstmt;
    private Statement stmt;
    private Connection conn;

    public CreateMember(Connection conn){
        this.conn = conn;
    }

    //Drop Tables Method
    public void dropMembersTable(){
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE member");
                System.out.println("Members table dropped successfully");
                stmt.execute("DROP SEQUENCE memberSeq");
                System.out.println("Members sequence dropped successfully\n");
            } catch (SQLException ex) {
                System.out.println("Error dropping table or they may not exist\n");
            }
        } catch (SQLException e) {
            //System.out.println(e);
            System.out.println("Error with connection");
        }
    }

//Create Members
    public void createMembersTable() {
        try {
            // create member table
            stmt = conn.createStatement();

            stmt.execute("CREATE TABLE member(" +
                    "memberId INTEGER, " +
                    "memberFName VARCHAR(30)," +
                    "memberLName VARCHAR(30)," +
                    "memberStreet VARCHAR2(80)," +
                    "memberCity VARCHAR2(20)," +
                    "memberCounty VARCHAR2(20)," +
                    "memberDOB DATE," +
                    "memberEmail VARCHAR2(70)," +
                    "memberNumber INTEGER," +
                    "memberPoints INTEGER," +
                    "memPicUrl BLOB," +
                    "PRIMARY KEY(memberId))");
            System.out.println("Member table created successfully");

            // create member id sequence
            stmt.execute("CREATE SEQUENCE memberSeq START WITH 1 INCREMENT BY 1");
            System.out.println("Member sequence created successfully\n");

            // prepared statement
            String sql = "INSERT INTO member (memberId, memberFName, memberLName, memberStreet, memberCity, memberCounty," +
                    "memberDOB, memberEmail, memberNumber, memberPoints, memPicUrl)" +
                    "VALUES (memberSeq.nextVal,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

//Member 1
            pstmt.setString(1, "Harry"); //FirstName
            pstmt.setString(2, "Jenkins"); //LastName
            pstmt.setString(3, "14 Ballinteer"); //Street
            pstmt.setString(4, "Dundrum"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "24-MAR-1989"); //DOB
            pstmt.setString(7, "HJenkins@gmail.com"); //Email
            pstmt.setInt(8, 1); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Bane.jpg")));
            pstmt.execute();
//Member2
            pstmt.setString(1, "Louis"); //FirstName
            pstmt.setString(2, "Morris"); //LastName
            pstmt.setString(3, "28 Main Street"); //Street
            pstmt.setString(4, "Naas"); //City
            pstmt.setString(5, "Kildare"); //County
            pstmt.setString(6, "17-SEP-1994"); //DOB
            pstmt.setString(7, "LMorris@hotmail.com"); //Email
            pstmt.setInt(8, 2); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Batamn.jpg")));
            pstmt.execute();
//Member3
            pstmt.setString(1, "Betty"); //FirstName
            pstmt.setString(2, "Thompson"); //LastName
            pstmt.setString(3, "16 Main Street"); //Street
            pstmt.setString(4, "Kilbride"); //City
            pstmt.setString(5, "Wicklow"); //County
            pstmt.setString(6, "11-SEP-2001"); //DOB
            pstmt.setString(7, "BettyT123@yahoo.co.uk"); //Email
            pstmt.setInt(8, 3); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Carnage.jpg")));
            pstmt.execute();
//Member4
            pstmt.setString(1, "Lori"); //FirstName
            pstmt.setString(2, "Baker"); //LastName
            pstmt.setString(3, "202 Cherrywood"); //Street
            pstmt.setString(4, "Clondalkin"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "22-NOV-1988"); //DOB
            pstmt.setString(7, "LBaker@gmail.com"); //Email
            pstmt.setInt(8, 4); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Groot.jpg")));
            pstmt.execute();
//Member5
            pstmt.setString(1, "Daniel"); //FirstName
            pstmt.setString(2, "Henderson"); //LastName
            pstmt.setString(3, "29 Jobstown"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "30-APR-1965"); //DOB
            pstmt.setString(7, "DanHendo@hotmail.com"); //Email
            pstmt.setInt(8, 5); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Deadpool.jpg")));
            pstmt.execute();
//Member6
            pstmt.setString(1, "Kathleen"); //FirstName
            pstmt.setString(2, "Perry"); //LastName
            pstmt.setString(3, "98 Springfield"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "04-MAY-1982"); //DOB
            pstmt.setString(7, "KatPerry@yahoo.co.uk"); //Email
            pstmt.setInt(8, 6); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Gambit.jpg")));
            pstmt.execute();
//Member7
            pstmt.setString(1, "Alan"); //FirstName
            pstmt.setString(2, "Stewart"); //LastName
            pstmt.setString(3, "132 Church Road"); //Street
            pstmt.setString(4, "Leixlip"); //City
            pstmt.setString(5, "Kildare"); //County
            pstmt.setString(6, "22-NOV-1971"); //DOB
            pstmt.setString(7, "A.Stewart@hotmail.com"); //Email
            pstmt.setInt(8, 7); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Deadshot.jpg")));
            pstmt.execute();
//Member8
            pstmt.setString(1, "Steve"); //FirstName
            pstmt.setString(2, "Adams"); //LastName
            pstmt.setString(3, "187 Magna Park"); //Street
            pstmt.setString(4, "Citywest"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "16-AUG-1989"); //DOB
            pstmt.setString(7, "sAdams@gmail.com"); //Email
            pstmt.setInt(8, 8); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Deathstroke.jpg")));
            pstmt.execute();
//Member9
            pstmt.setString(1, "Sean"); //FirstName
            pstmt.setString(2, "Green"); //LastName
            pstmt.setString(3, "78 Corbally Downs"); //Street
            pstmt.setString(4, "Crumlin"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "16-DEC-1970"); //DOB
            pstmt.setString(7, "S.Green@aol.com"); //Email
            pstmt.setInt(8, 9); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Hulk.jpg")));
            pstmt.execute();
//Member10
            pstmt.setString(1, "Ellen"); //FirstName
            pstmt.setString(2, "Malone"); //LastName
            pstmt.setString(3, "45 Forest Hills"); //Street
            pstmt.setString(4, "Swords"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "23-JUL-1981"); //DOB
            pstmt.setString(7, "Emalone@gmail.com"); //Email
            pstmt.setInt(8, 10); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/HarleyQuinn.jpg"))); //MemPicURL
            pstmt.execute();
//Member11
            pstmt.setString(1, "Greg"); //FirstName
            pstmt.setString(2, "David"); //LastName
            pstmt.setString(3, "14 The Lane"); //Street
            pstmt.setString(4, "Rathmines"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "27-JUN-1994"); //DOB
            pstmt.setString(7, "gDavid@hotmail.com"); //Email
            pstmt.setInt(8, 11); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Ironman.jpg")));
            pstmt.execute();
//Member12
            pstmt.setString(1, "Barry"); //FirstName
            pstmt.setString(2, "George"); //LastName
            pstmt.setString(3, "12 Fettercairn"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "10-MAR-1984"); //DOB
            pstmt.setString(7, "bGeorge@hotmail.com"); //Email
            pstmt.setInt(8, 12); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Joker.jpg")));
            pstmt.execute();
//Member13
            pstmt.setString(1, "Marie"); //FirstName
            pstmt.setString(2, "Harris"); //LastName
            pstmt.setString(3, "2A The Glen"); //Street
            pstmt.setString(4, "Newcastle"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "03-DEC-1967"); //DOB
            pstmt.setString(7, "MarieH@yahoo.co.uk"); //Email
            pstmt.setInt(8, 13); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Spiderman.jpg"))); //MemPicURL
            pstmt.execute();
//Member14
            pstmt.setString(1, "Brendan"); //FirstName
            pstmt.setString(2, "Wilkinson"); //LastName
            pstmt.setString(3, "41 Forest Hills"); //Street
            pstmt.setString(4, "Citywest"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "15-MAY-1992"); //DOB
            pstmt.setString(7, "BWilk142@gmail.com"); //Email
            pstmt.setInt(8, 14); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Thor.jpg"))); //MemPicURL
            pstmt.execute();
//Member15
            pstmt.setString(1, "Aoife "); //FirstName
            pstmt.setString(2, "Reilly"); //LastName
            pstmt.setString(3, "156 Stoney Lane"); //Street
            pstmt.setString(4, "Lucan"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "31-JAN-1978"); //DOB
            pstmt.setString(7, "AReilly156@hotmail.com\n"); //Email
            pstmt.setInt(8, 15); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setBinaryStream(10, savePic2DB(new File("src/res/images/MemberPictures/Wolverine.jpg"))); //MemPicURL
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }
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
