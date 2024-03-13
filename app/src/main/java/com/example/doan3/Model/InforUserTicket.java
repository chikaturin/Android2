package com.example.doan3.Model;

public class InforUserTicket {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String numberPhone;
    private String gender;
    private String place;

    private String personal;

    public InforUserTicket() {
    }

    public InforUserTicket(String firstName, String lastName, String birthDate, String numberPhone, String gender, String place, String personal) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.numberPhone = numberPhone;
        this.gender = gender;
        this.place = place;
        this.personal = personal;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
}