package com.example.mvc.model;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;



public class ValidateOTP implements Serializable {

    @SerializedName("mobileNo")
    public String mobileNo;


    @SerializedName("deviceKey")
    public String deviceKey;


    @SerializedName("otp")
    public String otp;


    @SerializedName("tokenizedOtp")
    public String tokenizedOtp;


}
