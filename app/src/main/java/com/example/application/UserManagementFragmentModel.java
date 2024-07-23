package com.example.application;

public class UserManagementFragmentModel {


    public  String test_value;

    public String code_number;

    public String Sample_value ;

    public int price;

    public UserManagementFragmentModel(String test_value, String code_number, String sample_value, int price) {
        this.test_value = test_value;
        this.code_number = code_number;
        this.Sample_value = sample_value;
        this.price = price;
    }


    public String getTest_value() {
        return test_value;
    }

    public void setTest_value(String test_value) {
        this.test_value = test_value;
    }

    public String getCode_number() {
        return code_number;
    }

    public void setCode_number(String code_number) {
        this.code_number = code_number;
    }

    public String getSample_value() {
        return Sample_value;
    }

    public void setSample_value(String sample_value) {
        Sample_value = sample_value;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
