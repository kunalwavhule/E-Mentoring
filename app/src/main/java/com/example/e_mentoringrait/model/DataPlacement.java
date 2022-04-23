package com.example.e_mentoringrait.model;

public class DataPlacement {
    String CompanyName;
    String Position;
    String Location;
    String Package;

    public DataPlacement() {
    }

    public DataPlacement(String companyName, String position, String location, String aPackage) {
        CompanyName = companyName;
        Position = position;
        Location = location;
        Package = aPackage;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String aPackage) {
        Package = aPackage;
    }
}
