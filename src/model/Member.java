package model;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import java.io.File;

public class Member {

// instance variables

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
    private byte[] memberPic;

    public Member(){}

// OVERLOADED CONSTRUCTOR

    public Member(int memberId, String memberFName, String memberLName, String memberStreet, String memberCity, String memberCounty, String dobd, String dobm, String doby, String memberEmail, String memberNumber, int memberPoints, byte[] memberPic) {
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
        this.memberPic = memberPic;
    }

// GETTERS

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

    public String getDobd() {
        return dobd;
    }

    public String getDobm() {
        return dobm;
    }

    public String getDoby() {
        return doby;
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

    public byte[] getMemberPic() {
        return memberPic;
    }

// SETTERS

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberFName(String memberFName) {
        this.memberFName = memberFName;
    }

    public void setMemberLName(String memberLName) {
        this.memberLName = memberLName;
    }

    public void setMemberStreet(String memberStreet) {
        this.memberStreet = memberStreet;
    }

    public void setMemberCity(String memberCity) {
        this.memberCity = memberCity;
    }

    public void setMemberCounty(String memberCounty) {
        this.memberCounty = memberCounty;
    }

    public void setDobd(String dobd) {
        this.dobd = dobd;
    }

    public void setDobm(String dobm) {
        this.dobm = dobm;
    }

    public void setDoby(String doby) {
        this.doby = doby;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public void setMemberPoints(int memberPoints) {
        this.memberPoints = memberPoints;
    }

    public void setMemberPic(byte[] memberPic) {
        this.memberPic = memberPic;
    }
}