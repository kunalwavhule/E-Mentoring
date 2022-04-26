package com.example.e_mentoringrait.model;

public class DataSemUt1 {
    String semName;
    String Sb1ut1;
    String Sb2ut1;
    String Sb3ut1;
    String Sb4ut1;
    String Sb5ut1;
    String Sb6ut1;

    public DataSemUt1() {
    }

    public DataSemUt1(String semName, String sb1ut1, String sb2ut1, String sb3ut1, String sb4ut1, String sb5ut1, String sb6ut1) {
        this.semName = semName;
        Sb1ut1 = sb1ut1;
        Sb2ut1 = sb2ut1;
        Sb3ut1 = sb3ut1;
        Sb4ut1 = sb4ut1;
        Sb5ut1 = sb5ut1;
        Sb6ut1 = sb6ut1;
    }

    public DataSemUt1(String sb1ut1, String sb2ut1, String sb3ut1, String sb4ut1, String sb5ut1, String sb6ut1) {
        Sb1ut1 = sb1ut1;
        Sb2ut1 = sb2ut1;
        Sb3ut1 = sb3ut1;
        Sb4ut1 = sb4ut1;
        Sb5ut1 = sb5ut1;
        Sb6ut1 = sb6ut1;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }

    public String getSb1ut1() {
        return Sb1ut1;
    }

    public void setSb1ut1(String sb1ut1) {
        Sb1ut1 = sb1ut1;
    }

    public String getSb2ut1() {
        return Sb2ut1;
    }

    public void setSb2ut1(String sb2ut1) {
        Sb2ut1 = sb2ut1;
    }

    public String getSb3ut1() {
        return Sb3ut1;
    }

    public void setSb3ut1(String sb3ut1) {
        Sb3ut1 = sb3ut1;
    }

    public String getSb4ut1() {
        return Sb4ut1;
    }

    public void setSb4ut1(String sb4ut1) {
        Sb4ut1 = sb4ut1;
    }

    public String getSb5ut1() {
        return Sb5ut1;
    }

    public void setSb5ut1(String sb5ut1) {
        Sb5ut1 = sb5ut1;
    }

    public String getSb6ut1() {
        return Sb6ut1;
    }

    public void setSb6ut1(String sb6ut1) {
        Sb6ut1 = sb6ut1;
    }
}
