package com.example.e_mentoringrait.model;

public class DataSemSubjectName {

    String semName;
    String SN1;
    String SN2;
    String SN3;
    String SN4;
    String SN5;
    String SN6;

    public DataSemSubjectName() {
    }

    public DataSemSubjectName(String semName, String SN1, String SN2, String SN3, String SN4, String SN5, String SN6) {
        this.semName = semName;
        this.SN1 = SN1;
        this.SN2 = SN2;
        this.SN3 = SN3;
        this.SN4 = SN4;
        this.SN5 = SN5;
        this.SN6 = SN6;
    }

    public DataSemSubjectName(String SN1, String SN2, String SN3, String SN4, String SN5, String SN6) {
        this.SN1 = SN1;
        this.SN2 = SN2;
        this.SN3 = SN3;
        this.SN4 = SN4;
        this.SN5 = SN5;
        this.SN6 = SN6;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }

    public String getSN1() {
        return SN1;
    }

    public void setSN1(String SN1) {
        this.SN1 = SN1;
    }

    public String getSN2() {
        return SN2;
    }

    public void setSN2(String SN2) {
        this.SN2 = SN2;
    }

    public String getSN3() {
        return SN3;
    }

    public void setSN3(String SN3) {
        this.SN3 = SN3;
    }

    public String getSN4() {
        return SN4;
    }

    public void setSN4(String SN4) {
        this.SN4 = SN4;
    }

    public String getSN5() {
        return SN5;
    }

    public void setSN5(String SN5) {
        this.SN5 = SN5;
    }

    public String getSN6() {
        return SN6;
    }

    public void setSN6(String SN6) {
        this.SN6 = SN6;
    }
}
