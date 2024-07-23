package com.example.mvvm.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.mvvm.model.UserProfileModel;
import com.example.mvvm.model.ValidateOTP;
import com.example.mvvm.model.ValidateOTPResponse;
import com.example.mvvm.network.RetrofitClient;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpViewModel extends ViewModel {

    private MutableLiveData<UserProfileModel> UserProfile = new MutableLiveData<>();

    public LiveData<UserProfileModel> getUserProfile() {

        return UserProfile;

    }

    public void validateOTP(ValidateOTP validateOTP) {


        RetrofitClient.getInstance().getRetrofitAPI().validateOTP(validateOTP)
                .enqueue(new Callback<ValidateOTPResponse>() {
                    @Override
                    public void onResponse(Call<ValidateOTPResponse> call, Response<ValidateOTPResponse> response) {

                        if (response.isSuccessful() && response.code() == 200) {

                            UserProfile.setValue(response.body().userprofile);

                        }
                    }

                    @Override
                    public void onFailure(Call<ValidateOTPResponse> call, Throwable t) {

                    }
                });

    }


}


