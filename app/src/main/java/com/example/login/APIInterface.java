package com.example.login;


import com.example.login.model.RequestOTPResponse;
import com.example.login.model.RequestOTP;
import com.example.login.model.ValidateOTP;
import com.example.login.model.ValidateOTPResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("SendExecutiveOTP")
    Call<RequestOTPResponse>sendAdminOTP(@Body RequestOTP requestOTP);

    @POST("ValidateAdminOTP")
    Call<ValidateOTPResponse>validateOTP(@Body ValidateOTP validateOTP);


}

