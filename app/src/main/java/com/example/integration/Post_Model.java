package com.example.integration;

public class Post_Model {

    private String Name;
    private String Profession;

    public Post_Model(String name, String profession) {
        Name = name;
        Profession = profession;
    }

    public String getName() {
        return Name;
    }

    public String getProfession() {
        return Profession;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }
}
