package com.example.doan3.Model;

public class InforUserTicket {
    private String FirstName;
    private  String LastName;
    private  String BirthDate;
    private  String NumberPhone;
    private  String Place;
    private  String Gender;
    private  String Personal;

    public InforUserTicket() {
    }

    public InforUserTicket(String firstName, String lastName, String birthDate, String numberPhone, String place, String gender, String personal) {
        FirstName = firstName;
        LastName = lastName;
        BirthDate = birthDate;
        NumberPhone = numberPhone;
        Place = place;
        Gender = gender;
        Personal = personal;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getNumberPhone() {
        return NumberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        NumberPhone = numberPhone;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPersonal() {
        return Personal;
    }

    public void setPersonal(String personal) {
        Personal = personal;
    }
}
