package com.example.mvc.controller;


import android.content.Context;


import com.example.mvc.model.RequestOTP;
import com.example.mvc.model.RequestOTPResponse;
import com.example.mvc.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginController {

    private Context context;
    private LoginControllerCallback callback;


    public LoginController(Context context, LoginControllerCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public void sendOTP(RequestOTP requestOTP) {

        RetrofitClient.getInstance().getRetrofitAPI().sendAdminOTP(requestOTP)
                .enqueue(new Callback<RequestOTPResponse>() {
                    @Override
                    public void onResponse(Call<RequestOTPResponse> call, Response<RequestOTPResponse> response) {
                        if (response.isSuccessful() && response.code() == 200) {
                            callback.sent_otp(response.body().tokenizedOTP);
                        }
                    }

                    @Override
                    public void onFailure(Call<RequestOTPResponse> call, Throwable t) {

                    }
                });
    }



    public interface LoginControllerCallback {
        void sent_otp(String tokenizedOtp);

    }
}