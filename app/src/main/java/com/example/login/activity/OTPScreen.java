package com.example.login.activity;


import static com.example.login.constants.MOBILE_NO;
import static com.example.login.constants.TOKENIZED_OTP;
import static com.example.login.constants.URL;
import static com.example.login.constants.USER_PROFILE;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login.model.UserProfileModel;
import com.example.login.model.ValidateOTP;
import com.example.login.model.ValidateOTPResponse;
import com.example.login.network.RetrofitClient;
import com.example.myapplication.databinding.OtpScreenBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OTPScreen extends AppCompatActivity {

    OtpScreenBinding binding;
    UserProfileModel Userprofile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = OtpScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.setMobileNumber(getIntent().getStringExtra(MOBILE_NO));


        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                RetrofitClient.getInstance().getRetrofitAPI().validateOTP(validateOTP())
                        .enqueue(new Callback<ValidateOTPResponse>() {
                            @Override
                            public void onResponse(Call<ValidateOTPResponse> call, Response<ValidateOTPResponse> response) {

                                if (response.isSuccessful() && response.code() == 200) {
                                    Userprofile = response.body().userprofile;

                                    saveUserProfile();
                                    navigationToUserProfileScreen();


                                }
                            }

                            @Override
                            public void onFailure(Call<ValidateOTPResponse> call, Throwable t) {
                                t.printStackTrace();

                            }

                        });


            }

        });
    }

    private ValidateOTP validateOTP() {


        ValidateOTP validateOTP = new ValidateOTP();
        validateOTP.mobileNo = getIntent().getStringExtra(MOBILE_NO);
        validateOTP.otp = binding.otpPinView.getText().toString();
        validateOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        validateOTP.tokenizedOtp = getIntent().getStringExtra(TOKENIZED_OTP);
        return validateOTP;

    }

    private void navigationToUserProfileScreen() {

        Intent intent = new Intent(OTPScreen.this, UserProfile.class);
        intent.putExtra(USER_PROFILE, Userprofile);
        startActivity(intent);

    }


    private void saveUserProfile() {

        SharedPref sharedPref =  SharedPref.getInstance(OTPScreen.this);
        sharedPref.saveUserProfile(Userprofile);
    }
}
