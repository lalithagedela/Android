package com.example.application;

public class ClinicProfileFragmentModel {


    public int image;

    public String text;

    public String place;


    public  String mobile_num;


    public String network_data;


    public String Address_text;

    public ClinicProfileFragmentModel(int image, String text, String place, String mobile_num, String network_data, String address_text) {
        this.image = image;
        this.text = text;
        this.place = place;
        this.mobile_num = mobile_num;
        this.network_data = network_data;
        Address_text = address_text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getNetwork_data() {
        return network_data;
    }

    public void setNetwork_data(String network_data) {
        this.network_data = network_data;
    }

    public String getAddress_text() {
        return Address_text;
    }

    public void setAddress_text(String address_text) {
        Address_text = address_text;
    }
}
