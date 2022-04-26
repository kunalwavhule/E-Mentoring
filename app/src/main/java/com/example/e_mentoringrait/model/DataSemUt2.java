package com.example.e_mentoringrait.model;

public class DataSemUt2 {
    String semName;
    String Sb1ut2;
    String Sb2ut2;
    String Sb3ut2;
    String Sb4ut2;
    String Sb5ut2;
    String Sb6ut2;

    public DataSemUt2() {
    }

    public DataSemUt2(String semName, String sb1ut2, String sb2ut2, String sb3ut2, String sb4ut2, String sb5ut2, String sb6ut2) {
        this.semName = semName;
        Sb1ut2 = sb1ut2;
        Sb2ut2 = sb2ut2;
        Sb3ut2 = sb3ut2;
        Sb4ut2 = sb4ut2;
        Sb5ut2 = sb5ut2;
        Sb6ut2 = sb6ut2;
    }

    public DataSemUt2(String sb1ut2, String sb2ut2, String sb3ut2, String sb4ut2, String sb5ut2, String sb6ut2) {
        Sb1ut2 = sb1ut2;
        Sb2ut2 = sb2ut2;
        Sb3ut2 = sb3ut2;
        Sb4ut2 = sb4ut2;
        Sb5ut2 = sb5ut2;
        Sb6ut2 = sb6ut2;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }

    public String getSb1ut2() {
        return Sb1ut2;
    }

    public void setSb1ut2(String sb1ut2) {
        Sb1ut2 = sb1ut2;
    }

    public String getSb2ut2() {
        return Sb2ut2;
    }

    public void setSb2ut2(String sb2ut2) {
        Sb2ut2 = sb2ut2;
    }

    public String getSb3ut2() {
        return Sb3ut2;
    }

    public void setSb3ut2(String sb3ut2) {
        Sb3ut2 = sb3ut2;
    }

    public String getSb4ut2() {
        return Sb4ut2;
    }

    public void setSb4ut2(String sb4ut2) {
        Sb4ut2 = sb4ut2;
    }

    public String getSb5ut2() {
        return Sb5ut2;
    }

    public void setSb5ut2(String sb5ut2) {
        Sb5ut2 = sb5ut2;
    }

    public String getSb6ut2() {
        return Sb6ut2;
    }

    public void setSb6ut2(String sb6ut2) {
        Sb6ut2 = sb6ut2;
    }
}
