package com.example.doan3.Model;

import java.io.Serializable;
import java.util.Date;

public class TicketNomal implements Serializable {
    private String namePlane;
    private String dateDepart;
    private String timeDepart;
    private String arrivalPlace;
    private String departPlace;
    private float price;
    private float price1;
    private float price2;
    private  String code;


    private String timeArrival;


    public TicketNomal() {
    }

    public TicketNomal(String namePlane, String dateDepart, String time, String arrivalPlace, String departPlace, float price, float price1, float price2, String code, String timeArrival) {
        this.namePlane = namePlane;
        this.dateDepart = dateDepart;
        this.timeDepart = time;
        this.arrivalPlace = arrivalPlace;
        this.departPlace = departPlace;
        this.price = price;
        this.price1 = price1;
        this.price2 = price2;
        this.code = code;
        this.timeArrival = timeArrival;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }
    public String getTimeDepart() {
        return timeDepart;
    }

    public void setTimeDepart(String time) {
        this.timeDepart = time;
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
