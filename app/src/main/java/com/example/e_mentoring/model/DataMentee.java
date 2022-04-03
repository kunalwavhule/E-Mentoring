package com.example.e_mentoring.model;

public class DataMentee {
    String serialno;
    String RollNo;
    String FullName;
    String Email;
    String Password;
    String MotherName;
    String Address;
    String MobileNO;
    String Mentee;
    String AddYear;
    String Religion;
    String Caste;
    String Ssc;
    String Hsc;
    String Fee;
    String AdmissionType;
    String Year;
    String Branch;
    String Division;
    String Batch;

    public DataMentee() {
    }


    public DataMentee(String serialno, String rollNo, String fullName, String email, String password, String motherName, String address, String religion, String caste, String ssc, String hsc, String fee, String admissionType, String year, String branch, String division, String batch) {
        this.serialno = serialno;
        RollNo = rollNo;
        FullName = fullName;
        Email = email;
        Password = password;
        MotherName = motherName;
        Address = address;
        Religion = religion;
        Caste = caste;
        Ssc = ssc;
        Hsc = hsc;
        Fee = fee;
        AdmissionType = admissionType;
        Year = year;
        Branch = branch;
        Division = division;
        Batch = batch;
    }

    public DataMentee(String serialno, String rollNo, String fullName, String email, String password, String motherName, String address, String mobileNO, String mentee, String addYear, String religion, String caste, String ssc, String hsc, String fee, String admissionType, String year, String branch, String division, String batch) {
        this.serialno = serialno;
        RollNo = rollNo;
        FullName = fullName;
        Email = email;
        Password = password;
        MotherName = motherName;
        Address = address;
        MobileNO = mobileNO;
        Mentee = mentee;
        AddYear = addYear;
        Religion = religion;
        Caste = caste;
        Ssc = ssc;
        Hsc = hsc;
        Fee = fee;
        AdmissionType = admissionType;
        Year = year;
        Branch = branch;
        Division = division;
        Batch = batch;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public String getCaste() {
        return Caste;
    }

    public void setCaste(String caste) {
        Caste = caste;
    }

    public String getSsc() {
        return Ssc;
    }

    public void setSsc(String ssc) {
        Ssc = ssc;
    }

    public String getHsc() {
        return Hsc;
    }

    public void setHsc(String hsc) {
        Hsc = hsc;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    public String getAdmissionType() {
        return AdmissionType;
    }

    public void setAdmissionType(String admissionType) {
        AdmissionType = admissionType;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
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

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMobileNO() {
        return MobileNO;
    }

    public void setMobileNO(String mobileNO) {
        MobileNO = mobileNO;
    }

    public String getMentee() {
        return Mentee;
    }

    public void setMentee(String mentee) {
        Mentee = mentee;
    }

    public String getAddYear() {
        return AddYear;
    }

    public void setAddYear(String addYear) {
        AddYear = addYear;
    }
}
