package gui.member;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 02/04/2015)
*/

public class MemberRow {

    private int memberId;
    private String memberFName;
    private String memberLName;
    private String memberStreet;
    private String memberCity;
    private String memberCounty;
    private String dobd;
    private String dobm;
    private String doby;
    private String memberEmail;
    private String memberNumber;
    private int memberPoints;

    public MemberRow(int memberId, String memberFName, String memberLName, String memberStreet, String memberCity, String memberCounty, String dobd, String dobm, String doby, String memberEmail, String memberNumber, int memberPoints) {
        this.memberId = memberId;
        this.memberFName = memberFName;
        this.memberLName = memberLName;
        this.memberStreet = memberStreet;
        this.memberCity = memberCity;
        this.memberCounty = memberCounty;
        this.dobd = dobd;
        this.dobm = dobm;
        this.doby = doby;
        this.memberEmail = memberEmail;
        this.memberNumber = memberNumber;
        this.memberPoints = memberPoints;
    }

    public int getMemberId() { return memberId; }
    public String getMemberFName() { return memberFName; }
    public String getMemberLName() { return memberLName; }
    public String getMemberStreet() { return memberStreet; }
    public String getMemberCity() { return memberCity; }
    public String getMemberCounty() { return memberCounty; }
    public String getMemberEmail() { return memberEmail; }

}