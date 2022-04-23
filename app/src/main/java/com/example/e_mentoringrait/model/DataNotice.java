package com.example.e_mentoringrait.model;

public class DataNotice {
    String Branch;
    String AccadmicYear;
    String Division;
    String Batch;
    String PostedOn;
    String PostedBy;
    String Notice;

    public DataNotice() {
    }

    public DataNotice(String postedOn, String postedBy, String notice) {
        PostedOn = postedOn;
        PostedBy = postedBy;
        Notice = notice;
    }

    public DataNotice(String branch, String accadmicYear, String division, String batch, String postedOn, String postedBy, String notice) {
        Branch = branch;
        AccadmicYear = accadmicYear;
        Division = division;
        Batch = batch;
        PostedOn = postedOn;
        PostedBy = postedBy;
        Notice = notice;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getAccadmicYear() {
        return AccadmicYear;
    }

    public void setAccadmicYear(String accadmicYear) {
        AccadmicYear = accadmicYear;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public String getPostedOn() {
        return PostedOn;
    }

    public void setPostedOn(String postedOn) {
        PostedOn = postedOn;
    }

    public String getPostedBy() {
        return PostedBy;
    }

    public void setPostedBy(String postedBy) {
        PostedBy = postedBy;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }
}
