package com.example.e_mentoringrait.model;

public class DataAttendence {
    String SubjectName;
    float Percentage;
    int TotalClass;
    int PrasentClass;
    int AbsentClass;

    public DataAttendence() {
    }

    public DataAttendence(String subjectName, float percentage, int totalClass, int prasentClass, int absentClass) {
        SubjectName = subjectName;
        Percentage = percentage;
        TotalClass = totalClass;
        PrasentClass = prasentClass;
        AbsentClass = absentClass;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public float getPercentage() {
        return Percentage;
    }

    public void setPercentage(float percentage) {
        Percentage = percentage;
    }

    public int getTotalClass() {
        return TotalClass;
    }

    public void setTotalClass(int totalClass) {
        TotalClass = totalClass;
    }

    public int getPrasentClass() {
        return PrasentClass;
    }

    public void setPrasentClass(int prasentClass) {
        PrasentClass = prasentClass;
    }

    public int getAbsentClass() {
        return AbsentClass;
    }

    public void setAbsentClass(int absentClass) {
        AbsentClass = absentClass;
    }
}

