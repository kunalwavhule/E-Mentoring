package com.example.e_mentoringrait.model;

public class DataFees {
    String Totalfees;
    String Paidfees;
    String Balancefees;
    String Scholarship;
    String Category;

    public DataFees(String totalfees, String paidfees, String balancefees, String scholarship, String category) {
        Totalfees = totalfees;
        Paidfees = paidfees;
        Balancefees = balancefees;
        Scholarship = scholarship;
        Category = category;
    }

    public String getTotalfees() {
        return Totalfees;
    }

    public void setTotalfees(String totalfees) {
        Totalfees = totalfees;
    }

    public String getPaidfees() {
        return Paidfees;
    }

    public void setPaidfees(String paidfees) {
        Paidfees = paidfees;
    }

    public String getBalancefees() {
        return Balancefees;
    }

    public void setBalancefees(String balancefees) {
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
