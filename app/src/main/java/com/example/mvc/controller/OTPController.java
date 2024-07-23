package com.example.mvc.controller;


import android.content.Context;


import com.example.mvc.model.UserProfileModel;
import com.example.mvc.model.ValidateOTP;
import com.example.mvc.model.ValidateOTPResponse;
import com.example.mvc.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OTPController {

    private  Context context;
    private OTPCallback callback;

    public OTPController(Context context, OTPCallback  callback){

        this.context = context;
        this.callback = callback;

    }


    public  void  ValidateOTP(ValidateOTP validateOTP ){

        RetrofitClient.getInstance().getRetrofitAPI().validateOTP(validateOTP)
                .enqueue(new Callback<ValidateOTPResponse>() {
                    @Override
                    public void onResponse(Call<ValidateOTPResponse> call, Response<ValidateOTPResponse> response) {

                        if (response.isSuccessful() && response.code() == 200) {

                             callback.validationOTP(response.body().userprofile);

                        }
                    }

                    @Override
                    public void onFailure(Call<ValidateOTPResponse> call, Throwable t) {
                        t.printStackTrace();

                    }

                });

    }

    public interface OTPCallback{

        void validationOTP(UserProfileModel userprofile);

    }


}