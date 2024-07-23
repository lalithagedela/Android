package com.example.application;

public class HealthModel {
   String data;

   String status;
    public HealthModel(String data, String status) {
        this.data= data;
this.status = status;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String setStatus(String status){
        this.status = status;
        return status;
    }


    public String getStatus(){
        return status;
    }
}
