package com.example.e_mentoringrait.model;

public class DataCalender {
    String Branch;
    String AccadmicYear;
    String Division;
    String Batch;
    String Day;
    String StartTime;
    String EndTime;
    String ClassName;
    String ClassRoom;
    String ClassType;
    String InstructerName;

    public DataCalender() {
    }

    public DataCalender(String startTime, String endTime, String className, String classRoom, String classType, String instructerName) {
        StartTime = startTime;
        EndTime = endTime;
        ClassName = className;
        ClassRoom = classRoom;
        ClassType = classType;
        InstructerName = instructerName;
    }

    public DataCalender(String branch, String accadmicYear, String division, String batch, String day, String startTime, String endTime, String className, String classRoom, String classType, String instructerName) {
        Branch = branch;
        AccadmicYear = accadmicYear;
        Division = division;
        Batch = batch;
        Day = day;
        StartTime = startTime;
        EndTime = endTime;
        ClassName = className;
        ClassRoom = classRoom;
        ClassType = classType;
        InstructerName = instructerName;
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

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(String classRoom) {
        ClassRoom = classRoom;
    }

    public String getClassType() {
        return ClassType;
    }

    public void setClassType(String classType) {
        ClassType = classType;
    }

    public String getInstructerName() {
        return InstructerName;
    }

    public void setInstructerName(String instructerName) {
        InstructerName = instructerName;
    }
}
