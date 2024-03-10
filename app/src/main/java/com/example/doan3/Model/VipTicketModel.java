package com.example.doan3.Model;

import java.io.Serializable;

public class VipTicketModel implements Serializable {
    private String nameAirplanevip;
    private String datevip;
    private String timevip;
    private String destinationvip;
    private String departurevip;
    private float pricevip;

    public VipTicketModel() {
    }

    public VipTicketModel(String nameAirplanevip, String datevip, String timevip, String destinationvip, String departurevip, float pricevip) {
        this.nameAirplanevip = nameAirplanevip;
        this.datevip = datevip;
        this.timevip = timevip;
        this.destinationvip = destinationvip;
        this.departurevip = departurevip;
        this.pricevip = pricevip;
    }

    public String getNameAirplanevip() {
        return nameAirplanevip;
    }

    public void setNameAirplanevip(String nameAirplanevip) {
        this.nameAirplanevip = nameAirplanevip;
    }

    public String getDatevip() {
        return datevip;
    }

    public void setDatevip(String datevip) {
        this.datevip = datevip;
    }

    public String getTimevip() {
        return timevip;
    }

    public void setTimevip(String timevip) {
        this.timevip = timevip;
    }

    public String getDestinationvip() {
        return destinationvip;
    }

    public void setDestinationvip(String destinationvip) {
        this.destinationvip = destinationvip;
    }

    public String getDeparturevip() {
        return departurevip;
    }

    public void setDeparturevip(String departurevip) {
        this.departurevip = departurevip;
    }

    public float getPricevip() {
        return pricevip;
    }

    public void setPricevip(float pricevip) {
        this.pricevip = pricevip;
    }
}
