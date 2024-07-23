package com.example.mvc.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ValidateOTPResponse implements Serializable {


    @SerializedName("StatusCode")
    public String  statuscode;

    @SerializedName("StatusMessage")
     public  String statusmessage;

    @SerializedName("UserProfile")
    public UserProfileModel userprofile;

}
