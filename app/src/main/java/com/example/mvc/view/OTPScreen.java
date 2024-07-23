package com.example.mvc.view;


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


import com.example.mvc.controller.OTPController;
import com.example.mvc.model.UserProfileModel;
import com.example.mvc.model.ValidateOTP;
import com.example.myapplication.databinding.OtpScreenBinding;


public class OTPScreen extends AppCompatActivity implements OTPController.OTPCallback {


    OtpScreenBinding binding;

    OTPController otpcontroller;

    UserProfileModel Userprofile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = OtpScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        otpcontroller = new OTPController(this, this);

        binding.setMobileNumber(getIntent().getStringExtra(MOBILE_NO));

        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                otpcontroller.ValidateOTP(validateOTP());


                saveprofile();
                navigationTOUserprofile();

            }


        });


    }

    public  ValidateOTP validateOTP() {


        ValidateOTP validateOTP = new ValidateOTP();
        validateOTP.mobileNo = getIntent().getStringExtra(MOBILE_NO);
        validateOTP.otp = binding.otpPinView.getText().toString();
        validateOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        validateOTP.tokenizedOtp = getIntent().getStringExtra(TOKENIZED_OTP);
        return validateOTP;

    }


    public  void validationOTP(UserProfileModel userprofile){

        this.Userprofile = userprofile;

    }

    private void navigationTOUserprofile() {

        Intent intent = new Intent(OTPScreen.this, UserProfile.class);
        intent.putExtra(USER_PROFILE, Userprofile);
        startActivity(intent);

    }


    private void saveprofile() {

        SharedPref sharedPref =  SharedPref.getInstance(OTPScreen.this);
        sharedPref.saveUserProfile(Userprofile);
    }
}




