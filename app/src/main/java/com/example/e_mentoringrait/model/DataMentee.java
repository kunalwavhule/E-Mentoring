package com.example.e_mentoringrait.model;

public class DataMentee {
    String Uid;
    int UserTypes;
    String Branch;
    String AccadmicYear;
    String Division;
    String Batch;
    String RollNo;
    String FullName;
    String Email;
    String Password;
    String MotherName;
    String Address;
    String StudentNumber;
    String ParentNumber;
    String AdmissionYear;
    String Ssc;
    String Hsc;
    String PaidFee;
    String Religion;
    String Caste;
    String AdmissionType;

    public DataMentee() {
    }

    public DataMentee(String uid, int userTypes, String branch, String accadmicYear, String division, String batch, String rollNo, String fullName, String email, String password, String motherName, String address, String studentNumber, String parentNumber, String admissionYear, String ssc, String hsc, String paidFee, String religion, String caste, String admissionType) {
        Uid = uid;
        UserTypes = userTypes;
        Branch = branch;
        AccadmicYear = accadmicYear;
        Division = division;
        Batch = batch;
        RollNo = rollNo;
        FullName = fullName;
        Email = email;
        Password = password;
        MotherName = motherName;
        Address = address;
        StudentNumber = studentNumber;
        ParentNumber = parentNumber;
        AdmissionYear = admissionYear;
        Ssc = ssc;
        Hsc = hsc;
        PaidFee = paidFee;
        Religion = religion;
        Caste = caste;
        AdmissionType = admissionType;
    }

    public DataMentee(String uid, int userTypes, String branch, String accadmicYear, String division, String batch, String rollNo, String fullName, String email) {
        Uid = uid;
        UserTypes = userTypes;
        Branch = branch;
        AccadmicYear = accadmicYear;
        Division = division;
        Batch = batch;
        RollNo = rollNo;
        FullName = fullName;
        Email = email;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public int getUserTypes() {
        return UserTypes;
    }

    public void setUserTypes(int userTypes) {
        UserTypes = userTypes;
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

    public String getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        StudentNumber = studentNumber;
    }

    public String getParentNumber() {
        return ParentNumber;
    }

    public void setParentNumber(String parentNumber) {
        ParentNumber = parentNumber;
    }

    public String getAdmissionYear() {
        return AdmissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        AdmissionYear = admissionYear;
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

    public String getPaidFee() {
        return PaidFee;
    }

    public void setPaidFee(String paidFee) {
        PaidFee = paidFee;
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

    public String getAdmissionType() {
        return AdmissionType;
    }

    public void setAdmissionType(String admissionType) {
        AdmissionType = admissionType;
    }
}
