package model;

public class Member {

// instance variables

    private int memberId;
    private String memberFName;
    private String memberLName;
    private String memberStreet;
    private String memberCity;
    private String memberCounty;
    private String dob;
    private String memberEmail;
    private String memberNumber;
    private int memberPoints;
    private String memPicUrl;

// default constructor

    public Member(){

        memberId = 0;
        memberFName = "";
        memberLName = "";
        memberStreet = "";
        memberCity = "";
        memberCounty = "";
        dob = "";
        memberEmail = "";
        memberNumber = "";
        memberPoints = 0;
        memPicUrl = "";
    }

// overloaded constructor NEEDS AN ID PASS FROM THE DATABASE

    public Member(String memberFNameIn,String memberLNameIn,String memberStreetIn,String memberCityIn,String memberCountyIn,String dobIn,String memberEmailIn,String memberNumberIn,int memberPointsIn,String memPicUrlIn){

        memberFName = memberFNameIn;
        memberLName = memberLNameIn;
        memberStreet = memberStreetIn;
        memberCity = memberCityIn;
        memberCounty = memberCountyIn;
        dob = dobIn;
        memberEmail = memberEmailIn;
        memberNumber = memberNumberIn;
        memberPoints = memberPointsIn;
        memPicUrl = memPicUrlIn;
    }

// getters

    public int getMemberId() {
        return memberId;
    }

    public String getMemberFName() {
        return memberFName;
    }

    public String getMemberLName() {
        return memberLName;
    }

    public String getMemberStreet() {
        return memberStreet;
    }

    public String getMemberCity() {
        return memberCity;
    }

    public String getMemberCounty() {
        return memberCounty;
    }

    public String getDob() {
        return dob;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public int getMemberPoints() {
        return memberPoints;
    }

    public String getMemPicUrl() {
        return memPicUrl;
    }

// setters


    public void setMemberId(int memberIdIn) {
        this.memberId = memberIdIn;
    }

    public void setMemberFName(String memberFNameIn) {
        this.memberFName = memberFNameIn;
    }

    public void setMemberLName(String memberLNameIn) {
        this.memberLName = memberLNameIn;
    }

    public void setMemberStreet(String memberStreetIn) {
        this.memberStreet = memberStreetIn;
    }

    public void setMemberCity(String memberCityIn) {
        this.memberCity = memberCityIn;
    }

    public void setMemberCounty(String memberCountyIn) {
        this.memberCounty = memberCountyIn;
    }

    public void setDob(String dobIn) {
        this.dob = dobIn;
    }

    public void setMemberEmail(String memberEmailIn) {
        this.memberEmail = memberEmailIn;
    }

    public void setMemberNumber(String memberNumberIn) {
        this.memberNumber = memberNumberIn;
    }

    public void setMemberPoints(int memberPointsIn) {
        this.memberPoints = memberPointsIn;
    }

    public void setMemPicUrl(String memPicUrlIn) {
        this.memPicUrl = memPicUrlIn;
    }
}