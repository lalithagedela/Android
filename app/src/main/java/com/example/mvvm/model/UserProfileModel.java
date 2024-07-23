package com.example.mvvm.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserProfileModel implements Serializable {

    @SerializedName("UserID")
    public String userID;

    @SerializedName("FirstName")
    public String firstName;
    @SerializedName("LastName")
    public String lastName;
    @SerializedName("MobileNumber")
    public String mobileNumber;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
