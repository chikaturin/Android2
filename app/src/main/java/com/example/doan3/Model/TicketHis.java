package com.example.doan3.Model;

import java.io.Serializable;

public class TicketHis implements Serializable {
    private String namePlane;
    private String dateDepart;
    private String time;
    private String arrivalPlace;
    private String departPlace;
    private String price;
    private  String code;

    private  String code_History;

    public TicketHis(String namePlane, String dateDepart, String time, String arrivalPlace, String departPlace, String price, String code, String code_History, String firstnameHis, String lastnameHis, String timeArrival) {
        this.namePlane = namePlane;
        this.dateDepart = dateDepart;
        this.time = time;
        this.arrivalPlace = arrivalPlace;
        this.departPlace = departPlace;
        this.price = price;
        this.code = code;
        this.code_History = code_History;
        this.firstnameHis = firstnameHis;
        this.lastnameHis = lastnameHis;
        this.timeArrival = timeArrival;
    }

    public String getCode_History() {
        return code_History;
    }

    public void setCode_History(String code_History) {
        this.code_History = code_History;
    }
    private  String firstnameHis;
    private  String lastnameHis;

    private String timeArrival;



    public TicketHis() {
    }


    public String getFirstnameHis() {
        return firstnameHis;
    }

    public void setFirstnameHis(String firstnameHis) {
        this.firstnameHis = firstnameHis;
    }

    public String getLastnameHis() {
        return lastnameHis;
    }

    public void setLastnameHis(String lastnameHis) {
        this.lastnameHis = lastnameHis;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
