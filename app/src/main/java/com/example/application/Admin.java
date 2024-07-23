package com.example.application;

public class Admin {

    public String text;

    public int  profile;

    public Admin(String text,int profile) {
        this.text = text;
        this.profile = profile;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
