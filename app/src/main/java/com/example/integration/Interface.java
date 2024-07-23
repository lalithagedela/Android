package com.example.integration;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface Interface {

    @POST("users")
    Call<Post_Model> createPost (@Body Post_Model Modal);

    @GET("/api/users?")
    Call<Get_Model> getAllData(@Query("page") String id);



}

