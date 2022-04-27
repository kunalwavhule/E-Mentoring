package com.example.e_mentoringrait.model;

public class DataTest {
    int Totalfees;
    int Paidfees;
    int Balancefees;
    String Scholarship;
    String Category;

    public DataTest() {
    }

    public DataTest(int totalfees, int paidfees, int balancefees, String scholarship, String category) {
        Totalfees = totalfees;
        Paidfees = paidfees;
        Balancefees = balancefees;
        Scholarship = scholarship;
        Category = category;
    }

    public int getTotalfees() {
        return Totalfees;
    }

    public void setTotalfees(int totalfees) {
        Totalfees = totalfees;
    }

    public int getPaidfees() {
        return Paidfees;
    }

    public void setPaidfees(int paidfees) {
        Paidfees = paidfees;
    }

    public int getBalancefees() {
        return Balancefees;
    }

    public void setBalancefees(int balancefees) {
        Balancefees = balancefees;
    }

    public String getScholarship() {
        return Scholarship;
    }

    public void setScholarship(String scholarship) {
        Scholarship = scholarship;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
