package com.example.recyclerview;

public class Student {

    public  String student_name;
    public int student_no;


    public int profile;


    public Student(String student_name, int student_no,int profile) {
        this.student_name = student_name;
        this.student_no = student_no;
        this.profile=profile;

    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getStudent_no() {
        return student_no;
    }

    public void setStudent_no(int student_no) {
        this.student_no = student_no;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }



}

