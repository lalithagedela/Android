package com.example.patient_constraint;

import java.io.Serializable;
public class Patient_Model implements Serializable {

    private String firstname;

    private String lastname;

    private String Email;

    private String Password;

    private String PhoneNumber;

    private String Address;

    private String zipcode;

    private String country;

    private String date;

    private String city;


    private String occupation;

    private String state;

    private String age;

    private String gender;

    private String martial_status;


    public Patient_Model(){

    }
    public String getFirstname() {
        return firstname;
    }


    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getState() {
        return state;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getMartial_status() {
        return martial_status;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMartial_status(String martial_status) {
        this.martial_status = martial_status;
    }

}
