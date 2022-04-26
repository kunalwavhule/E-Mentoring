package com.example.e_mentoringrait.model;

public class DataSemfl {
    String semName;
    String Sb1fl;
    String Sb2fl;
    String Sb3fl;
    String Sb4fl;
    String Sb5fl;
    String Sb6fl;

    public DataSemfl() {
    }

    public DataSemfl(String semName, String sb1fl, String sb2fl, String sb3fl, String sb4fl, String sb5fl, String sb6fl) {
        this.semName = semName;
        Sb1fl = sb1fl;
        Sb2fl = sb2fl;
        Sb3fl = sb3fl;
        Sb4fl = sb4fl;
        Sb5fl = sb5fl;
        Sb6fl = sb6fl;
    }

    public DataSemfl(String sb1fl, String sb2fl, String sb3fl, String sb4fl, String sb5fl, String sb6fl) {
        Sb1fl = sb1fl;
        Sb2fl = sb2fl;
        Sb3fl = sb3fl;
        Sb4fl = sb4fl;
        Sb5fl = sb5fl;
        Sb6fl = sb6fl;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }

    public String getSb1fl() {
        return Sb1fl;
    }

    public void setSb1fl(String sb1fl) {
        Sb1fl = sb1fl;
    }

    public String getSb2fl() {
        return Sb2fl;
    }

    public void setSb2fl(String sb2fl) {
        Sb2fl = sb2fl;
    }

    public String getSb3fl() {
        return Sb3fl;
    }

    public void setSb3fl(String sb3fl) {
        Sb3fl = sb3fl;
    }

    public String getSb4fl() {
        return Sb4fl;
    }

    public void setSb4fl(String sb4fl) {
        Sb4fl = sb4fl;
    }

    public String getSb5fl() {
        return Sb5fl;
    }

    public void setSb5fl(String sb5fl) {
        Sb5fl = sb5fl;
    }

    public String getSb6fl() {
        return Sb6fl;
    }

    public void setSb6fl(String sb6fl) {
        Sb6fl = sb6fl;
    }
}
