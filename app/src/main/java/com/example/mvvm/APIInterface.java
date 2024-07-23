package com.example.mvvm;




import com.example.mvvm.model.RequestOTP;
import com.example.mvvm.model.RequestOTPResponse;
import com.example.mvvm.model.ValidateOTP;
import com.example.mvvm.model.ValidateOTPResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface APIInterface {

    @POST("SendExecutiveOTP")
    Call<RequestOTPResponse>sendAdminOTP(@Body RequestOTP requestOTP);

    @POST("ValidateAdminOTP")
    Call<ValidateOTPResponse>validateOTP(@Body ValidateOTP validateOTP);


}

