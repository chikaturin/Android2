package com.example.doan3.Model;

import java.io.Serializable;

public class Servicemodel implements Serializable {
    String information;
    String name;
    float price;
    int image;

    public Servicemodel(String information, String name, float price, int image) {
        this.information = information;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public Servicemodel() {
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
