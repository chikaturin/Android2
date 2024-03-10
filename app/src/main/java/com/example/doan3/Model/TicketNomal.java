package com.example.doan3.Model;

import java.io.Serializable;
import java.util.Date;

public class TicketNomal implements Serializable {
    private String namePlane;
    private String dateDepart;
    private String time;
    private String arrivalPlace;
    private String departPlace;
    private int price;
    private int price1;
    private float price2;


    public TicketNomal() {
    }

    public TicketNomal(String namePlane, String dateDepart, String hours,String time, String minutes, String arrivalPlace, String departPlace, int price,int price1,float price2) {
        this.namePlane = namePlane;
        this.dateDepart = dateDepart;
        this.time = hours+minutes;
        this.arrivalPlace = arrivalPlace;
        this.departPlace = departPlace;
        this.price = price;
        this.price1 = price1;
        this.price2 = price2;
        this.time=time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNamePlane() {
        return namePlane;
    }

    public void setNamePlane(String namePlane) {
        this.namePlane = namePlane;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }


    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public float getPrice2() {
        return price2;
    }

    public void setPrice2(float price2) {
        this.price2 = price2;
    }
}
