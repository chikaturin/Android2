package com.example.doan3.Model;

import java.io.Serializable;

public class TicketHis implements Serializable {
    private String namePlane;
    private String dateDepart;
    private String time;
    private String arrivalPlace;
    private String departPlace;
    private int price;
    private  String code;


    private String timeArrival;


    public TicketHis() {
    }

    public TicketHis(String namePlane, String dateDepart, String time, String arrivalPlace, String departPlace, int price, String code, String timeArrival) {
        this.namePlane = namePlane;
        this.dateDepart = dateDepart;
        this.time = time;
        this.arrivalPlace = arrivalPlace;
        this.departPlace = departPlace;
        this.price = price;
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

}
