package database.create;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George)
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
                    "memberFName VARCHAR2(255)," +
                    "memberLName VARCHAR2(255)," +
                    "memberStreet VARCHAR2(255)," +
                    "memberCity VARCHAR2(255)," +
                    "memberCounty VARCHAR2(255)," +
                    "memberDOBd VARCHAR2(255)," +
                    "memberDOBm VARCHAR2(255)," +
                    "memberDOBy VARCHAR2(255)," +
                    "memberEmail VARCHAR2(255)," +
                    "memberNumber INTEGER," +
                    "memberPoints INTEGER," +
                    "memPic BLOB," +
                    "PRIMARY KEY(memberId))");
            System.out.println("Member table created successfully");

            // create member id sequence
            stmt.execute("CREATE SEQUENCE memberSeq START WITH 1 INCREMENT BY 1");
            System.out.println("Member sequence created successfully\n");

            // prepared statement
            String sql = "INSERT INTO member (memberId, memberFName, memberLName, memberStreet, memberCity, memberCounty," +
                    "memberDOBd, memberDOBm, memberDOBy, memberEmail, memberNumber, memberPoints, memPic)" +
                    "VALUES (memberSeq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

//Member 1
            pstmt.setString(1, "Harry"); //FirstName
            pstmt.setString(2, "Jenkins"); //LastName
            pstmt.setString(3, "14 Ballinteer"); //Street
            pstmt.setString(4, "Dundrum"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "23");//Day
            pstmt.setString(7, "Mar"); //Month
            pstmt.setString(8, "1989");//Year
            pstmt.setString(9, "HJenkins@gmail.com"); //Email
            pstmt.setInt(10, 1); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Bane.jpg")));
            pstmt.execute();
//Member2
            pstmt.setString(1, "Louis"); //FirstName
            pstmt.setString(2, "Morris"); //LastName
            pstmt.setString(3, "28 Main Street"); //Street
            pstmt.setString(4, "Naas"); //City
            pstmt.setString(5, "Kildare"); //County
            pstmt.setString(6, "16");//Day
            pstmt.setString(7, "Sep"); //Month
            pstmt.setString(8, "1994");//Year
            pstmt.setString(9, "LMorris@hotmail.com"); //Email
            pstmt.setInt(10, 2); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Batamn.jpg")));
            pstmt.execute();
//Member3
            pstmt.setString(1, "Betty"); //FirstName
            pstmt.setString(2, "Thompson"); //LastName
            pstmt.setString(3, "16 Main Street"); //Street
            pstmt.setString(4, "Kilbride"); //City
            pstmt.setString(5, "Wicklow"); //County
            pstmt.setString(6, "3");//Day
            pstmt.setString(7, "Sep"); //Month
            pstmt.setString(8, "1976");//Year
            pstmt.setString(9, "BettyT123@yahoo.co.uk"); //Email
            pstmt.setInt(10, 3); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Carnage.jpg")));
            pstmt.execute();
//Member4
            pstmt.setString(1, "Lori"); //FirstName
            pstmt.setString(2, "Baker"); //LastName
            pstmt.setString(3, "202 Cherrywood"); //Street
            pstmt.setString(4, "Clondalkin"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "12");//Day
            pstmt.setString(7, "Nov"); //Month
            pstmt.setString(8, "1988");//Year
            pstmt.setString(9, "LBaker@gmail.com"); //Email
            pstmt.setInt(10, 4); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Groot.jpg")));
            pstmt.execute();
//Member5
            pstmt.setString(1, "Daniel"); //FirstName
            pstmt.setString(2, "Henderson"); //LastName
            pstmt.setString(3, "29 Jobstown"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "30");//Day
            pstmt.setString(7, "Apr"); //Month
            pstmt.setString(8, "1965");//Year
            pstmt.setString(9, "DanHendo@hotmail.com"); //Email
            pstmt.setInt(10, 5); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Deadpool.jpg")));
            pstmt.execute();
//Member6
            pstmt.setString(1, "Kathleen"); //FirstName
            pstmt.setString(2, "Perry"); //LastName
            pstmt.setString(3, "98 Springfield"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "4");//Day
            pstmt.setString(7, "May"); //Month
            pstmt.setString(8, "1982");//Year
            pstmt.setString(9, "KatPerry@yahoo.co.uk"); //Email
            pstmt.setInt(10, 6); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Gambit.jpg")));
            pstmt.execute();
//Member7
            pstmt.setString(1, "Alan"); //FirstName
            pstmt.setString(2, "Stewart"); //LastName
            pstmt.setString(3, "132 Church Road"); //Street
            pstmt.setString(4, "Leixlip"); //City
            pstmt.setString(5, "Kildare"); //County
            pstmt.setString(6, "22");//Day
            pstmt.setString(7, "Nov"); //Month
            pstmt.setString(8, "1971");//Year
            pstmt.setString(9, "A.Stewart@hotmail.com"); //Email
            pstmt.setInt(10, 7); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Deadshot.jpg")));
            pstmt.execute();
//Member8
            pstmt.setString(1, "Steve"); //FirstName
            pstmt.setString(2, "Adams"); //LastName
            pstmt.setString(3, "187 Magna Park"); //Street
            pstmt.setString(4, "Citywest"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "5");//Day
            pstmt.setString(7, "Aug"); //Month
            pstmt.setString(8, "1989");//Year
            pstmt.setString(9, "sAdams@gmail.com"); //Email
            pstmt.setInt(10, 8); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Deathstroke.jpg")));
            pstmt.execute();
//Member9
            pstmt.setString(1, "Sean"); //FirstName
            pstmt.setString(2, "Green"); //LastName
            pstmt.setString(3, "78 Corbally Downs"); //Street
            pstmt.setString(4, "Crumlin"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "14");//Day
            pstmt.setString(7, "Dec"); //Month
            pstmt.setString(8, "1970");//Year
            pstmt.setString(9, "S.Green@aol.com"); //Email
            pstmt.setInt(10, 9); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Hulk.jpg")));
            pstmt.execute();
//Member10
            pstmt.setString(1, "Ellen"); //FirstName
            pstmt.setString(2, "Malone"); //LastName
            pstmt.setString(3, "45 Forest Hills"); //Street
            pstmt.setString(4, "Swords"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "18");//Day
            pstmt.setString(7, "Jul"); //Month
            pstmt.setString(8, "1981");//Year
            pstmt.setString(9, "Emalone@gmail.com"); //Email
            pstmt.setInt(10, 10); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/HarleyQuinn.jpg"))); //memPic
            pstmt.execute();
//Member11
            pstmt.setString(1, "Greg"); //FirstName
            pstmt.setString(2, "David"); //LastName
            pstmt.setString(3, "14 The Lane"); //Street
            pstmt.setString(4, "Rathmines"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "14");//Day
            pstmt.setString(7, "Jun"); //Month
            pstmt.setString(8, "1990");//Year
            pstmt.setString(9, "gDavid@hotmail.com"); //Email
            pstmt.setInt(10, 11); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Ironman.jpg")));
            pstmt.execute();
//Member12
            pstmt.setString(1, "Barry"); //FirstName
            pstmt.setString(2, "George"); //LastName
            pstmt.setString(3, "12 Fettercairn"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "20");//Day
            pstmt.setString(7, "Mar"); //Month
            pstmt.setString(8, "1984");//Year
            pstmt.setString(9, "bGeorge@hotmail.com"); //Email
            pstmt.setInt(10, 12); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Joker.jpg")));
            pstmt.execute();
//Member13
            pstmt.setString(1, "Marie"); //FirstName
            pstmt.setString(2, "Harris"); //LastName
            pstmt.setString(3, "2A The Glen"); //Street
            pstmt.setString(4, "Newcastle"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "1");//Day
            pstmt.setString(7, "Dec"); //Month
            pstmt.setString(8, "1967");//Year
            pstmt.setString(9, "MarieH@yahoo.co.uk"); //Email
            pstmt.setInt(10, 13); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Spiderman.jpg"))); //memPic
            pstmt.execute();
//Member14
            pstmt.setString(1, "Brendan"); //FirstName
            pstmt.setString(2, "Wilkinson"); //LastName
            pstmt.setString(3, "41 Forest Hills"); //Street
            pstmt.setString(4, "Citywest"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "31");//Day
            pstmt.setString(7, "May"); //Month
            pstmt.setString(8, "1992");//Year
            pstmt.setString(9, "BWilk142@gmail.com"); //Email
            pstmt.setInt(10, 14); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Thor.jpg"))); //memPic
            pstmt.execute();
//Member15
            pstmt.setString(1, "Aoife "); //FirstName
            pstmt.setString(2, "Reilly"); //LastName
            pstmt.setString(3, "156 Stoney Lane"); //Street
            pstmt.setString(4, "Lucan"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "26");//Day
            pstmt.setString(7, "Jan"); //Month
            pstmt.setString(8, "1994"); //Year
            pstmt.setString(9, "AReilly156@hotmail.com\n"); //Email
            pstmt.setInt(10, 15); //MemNumber
            pstmt.setInt(11, 0); //MemPoints
            pstmt.setBinaryStream(12, savePic2DB(new File("src/res/images/MemberPictures/Wolverine.jpg"))); //memPic
            pstmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public FileInputStream savePic2DB(File pic) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(pic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return in;
    }
}