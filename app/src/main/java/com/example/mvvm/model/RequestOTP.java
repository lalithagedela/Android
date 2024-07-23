package com.example.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RequestOTP implements Serializable {

    @SerializedName("mobileNo")
    public String mobileNo;

    @SerializedName("secretKey")
    public String secretKey;

    @SerializedName("applicationID")
    public String applicationID;

    @SerializedName("deviceKey")
    public String deviceKey;


    @SerializedName("isResend")
    public boolean isResend;


}
