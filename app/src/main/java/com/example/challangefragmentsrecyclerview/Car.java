package com.example.challangefragmentsrecyclerview;

public class Car {
    private String logo,carname,name,telno;

    public Car(String logo, String carname, String name, String telno) {
        this.logo = logo;
        this.carname = carname;
        this.name = name;
        this.telno = telno;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }
}
