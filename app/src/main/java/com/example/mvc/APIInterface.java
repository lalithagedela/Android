package com.example.mvc;



import com.example.mvc.model.RequestOTP;
import com.example.mvc.model.RequestOTPResponse;
import com.example.mvc.model.ValidateOTP;
import com.example.mvc.model.ValidateOTPResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface APIInterface {

    @POST("SendExecutiveOTP")
    Call<RequestOTPResponse>sendAdminOTP(@Body RequestOTP requestOTP);

    @POST("ValidateAdminOTP")
    Call<ValidateOTPResponse>validateOTP(@Body ValidateOTP validateOTP);


}

