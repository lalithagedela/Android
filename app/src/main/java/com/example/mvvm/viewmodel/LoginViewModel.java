package com.example.mvvm.viewmodel;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mvvm.model.RequestOTP;
import com.example.mvvm.model.RequestOTPResponse;
import com.example.mvvm.network.RetrofitClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<String> tokenizedOtp = new MutableLiveData<>();

    public LiveData<String> getTokenizedOTP() {

        return tokenizedOtp;
    }

    public void sendOTP(RequestOTP requestOTP) {

        RetrofitClient.getInstance().getRetrofitAPI().sendAdminOTP(requestOTP)
                .enqueue(new Callback<RequestOTPResponse>() {
                    @Override
                    public void onResponse(Call<RequestOTPResponse> call, Response<RequestOTPResponse> response) {

                        if (response.isSuccessful() && response.code() == 200) {

                            tokenizedOtp.setValue(response.body().tokenizedOTP);
                        }
                    }

                    @Override
                    public void onFailure(Call<RequestOTPResponse> call, Throwable t) {

                    }
                });
    }
}
