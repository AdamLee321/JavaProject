package database.create;

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
    private ResultSet rset;
    private Connection conn;


//Drop Tables Method
    public void dropMembers(){
        try{
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP SEQUENCE memberId_seq");
                System.out.println("Member Sequence Dropped");
            } catch (SQLException e) {}
            try {
                stmt.execute("DROP TABLE Member");
                System.out.println("Member Table Dropped");
            } catch (SQLException e) {}
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//Create Members
    public void createMembers() {
        try {
            // creates members table
            String sqlTableM = "CREATE TABLE member(\n " +
                    "memberId NUMBER,\n " +
                    "memberFName VARCHAR(30),\n" +
                    "memberLName VARCHAR(30),\n" +
                    "memberStreet VARCHAR2(80),\n" +
                    "memberCity VARCHAR2(20),\n" +
                    "memberCounty VARCHAR2(25),\n" +
                    "memberDOB DATE,\n" +
                    "memberEmail VARCHAR2(70),\n" +
                    "memberNumber NUMBER,\n" +
                    "memberPoints NUMBER,\n" +
                    "memPicUrl BLOB,\n" +
                    "Primary Key(memberId),\n" +
                    ");";
            pstmt = conn.prepareStatement(sqlTableM);
            pstmt.executeUpdate();

            // create member id sequence
            String sqlSequence = "create sequence memberId_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(sqlSequence);
            pstmt.executeUpdate();

            // insert data into member table
            String sqlData = "INSERT INTO member(memberId,memberFName,memberLName,memberStreet,memberCity,memberCounty,memberDOB,memberEmail,memberNumber,memberPoints,memPicUrl)" +
                    "values(memberId_seq.nextVal,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

//Member 1
            pstmt.setString(1, "Harry"); //FirstName
            pstmt.setString(2, "Jenkins"); //LastName
            pstmt.setString(3, "14 Ballinteer"); //Street
            pstmt.setString(4, "Dundrum"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "24-03-1989"); //DOB
            pstmt.setString(7, "HJenkins@gmail.com"); //Email
            pstmt.setInt(8, 1); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL

//Member2
            pstmt.setString(1, "Louis"); //FirstName
            pstmt.setString(2, "Morris"); //LastName
            pstmt.setString(3, "28 Main Street"); //Street
            pstmt.setString(4, "Naas"); //City
            pstmt.setString(5, "Kildare"); //County
            pstmt.setString(6, "17-09-1994"); //DOB
            pstmt.setString(7, "LMorris@hotmail.com"); //Email
            pstmt.setInt(8, 2); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member3
            pstmt.setString(1, "Betty"); //FirstName
            pstmt.setString(2, "Thompson"); //LastName
            pstmt.setString(3, "16 Main Street"); //Street
            pstmt.setString(4, "Kilbride"); //City
            pstmt.setString(5, "Wicklow"); //County
            pstmt.setString(6, "11-09-2001"); //DOB
            pstmt.setString(7, "BettyT123@yahoo.co.uk"); //Email
            pstmt.setInt(8, 3); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member4
            pstmt.setString(1, "Lori"); //FirstName
            pstmt.setString(2, "Baker"); //LastName
            pstmt.setString(3, "202 Cherrywood"); //Street
            pstmt.setString(4, "Clondalkin"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "22-11-1988"); //DOB
            pstmt.setString(7, "LBaker@gmail.com"); //Email
            pstmt.setInt(8, 4); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member5
            pstmt.setString(1, "Daniel"); //FirstName
            pstmt.setString(2, "Henderson"); //LastName
            pstmt.setString(3, "29 Jobstown"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "30-04-1965"); //DOB
            pstmt.setString(7, "DanHendo@hotmail.com"); //Email
            pstmt.setInt(8, 5); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member6
            pstmt.setString(1, "Kathleen"); //FirstName
            pstmt.setString(2, "Perry"); //LastName
            pstmt.setString(3, "98 Springfield"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "04-05-1982"); //DOB
            pstmt.setString(7, "KatPerry@yahoo.co.uk"); //Email
            pstmt.setInt(8, 6); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member7
            pstmt.setString(1, "Alan"); //FirstName
            pstmt.setString(2, "Stewart"); //LastName
            pstmt.setString(3, "132 Church Road"); //Street
            pstmt.setString(4, "Leixlip"); //City
            pstmt.setString(5, "Kildare"); //County
            pstmt.setString(6, "22-11-1971"); //DOB
            pstmt.setString(7, "A.Stewart@hotmail.com"); //Email
            pstmt.setInt(8, 7); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member8
            pstmt.setString(1, "Steve"); //FirstName
            pstmt.setString(2, "Adams"); //LastName
            pstmt.setString(3, "187 Magna Park"); //Street
            pstmt.setString(4, "Citywest"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "16-08-1989"); //DOB
            pstmt.setString(7, "sAdams@gmail.com"); //Email
            pstmt.setInt(8, 8); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member9
            pstmt.setString(1, "Sean"); //FirstName
            pstmt.setString(2, "Green"); //LastName
            pstmt.setString(3, "78 Corbally Downs"); //Street
            pstmt.setString(4, "Crumlin"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "16-12-1970"); //DOB
            pstmt.setString(7, "S.Green@aol.com"); //Email
            pstmt.setInt(8, 9); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member10
            pstmt.setString(1, "Ellen"); //FirstName
            pstmt.setString(2, "Malone"); //LastName
            pstmt.setString(3, "45 Forest Hills"); //Street
            pstmt.setString(4, "Swords"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "23-07-1981"); //DOB
            pstmt.setString(7, "Emalone@gmail.com"); //Email
            pstmt.setInt(8, 10); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member11
            pstmt.setString(1, "Greg"); //FirstName
            pstmt.setString(2, "David"); //LastName
            pstmt.setString(3, "14 The Lane"); //Street
            pstmt.setString(4, "Rathmines"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "27-06-1994"); //DOB
            pstmt.setString(7, "gDavid@hotmail.com"); //Email
            pstmt.setInt(8, 11); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member12
            pstmt.setString(1, "Barry"); //FirstName
            pstmt.setString(2, "George"); //LastName
            pstmt.setString(3, "12 Fettercairn"); //Street
            pstmt.setString(4, "Tallaght"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "10-03-1984"); //DOB
            pstmt.setString(7, "bGeorge@hotmail.com"); //Email
            pstmt.setInt(8, 12); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member13
            pstmt.setString(1, "Marie"); //FirstName
            pstmt.setString(2, "Harris"); //LastName
            pstmt.setString(3, "2A The Glen"); //Street
            pstmt.setString(4, "Newcastle"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "03-12-1967"); //DOB
            pstmt.setString(7, "MarieH@yahoo.co.uk"); //Email
            pstmt.setInt(8, 13); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member14
            pstmt.setString(1, "Brendan"); //FirstName
            pstmt.setString(2, "Wilkinson"); //LastName
            pstmt.setString(3, "41 Forest Hills"); //Street
            pstmt.setString(4, "Citywest"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "15-05-1992"); //DOB
            pstmt.setString(7, "BWilk142@gmail.com"); //Email
            pstmt.setInt(8, 14); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL
//Member15
            pstmt.setString(1, "Aoife "); //FirstName
            pstmt.setString(2, "Reilly"); //LastName
            pstmt.setString(3, "156 Stoney Lane"); //Street
            pstmt.setString(4, "Lucan"); //City
            pstmt.setString(5, "Dublin"); //County
            pstmt.setString(6, "31-01-1978"); //DOB
            pstmt.setString(7, "AReilly156@hotmail.com\n"); //Email
            pstmt.setInt(8, 15); //MemNumber
            pstmt.setInt(9, 0); //MemPoints
            pstmt.setString(10, "NULL"); //MemPicURL

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
