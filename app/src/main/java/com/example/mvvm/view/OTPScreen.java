package com.example.mvvm.view;


import static com.example.mvvm.constants.MOBILE_NO;
import static com.example.mvvm.constants.TOKENIZED_OTP;
import static com.example.mvvm.constants.USER_PROFILE;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.mvvm.model.UserProfileModel;
import com.example.mvvm.model.ValidateOTP;
import com.example.mvvm.viewmodel.OtpViewModel;
import com.example.myapplication.databinding.OtpScreenBinding;

public class OTPScreen extends AppCompatActivity {
    OtpScreenBinding binding;
    OtpViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = OtpScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = new ViewModelProvider(this).get(OtpViewModel.class);

        binding.setMobileNumber(getIntent().getStringExtra(MOBILE_NO));

        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.otpPinView.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please enter the OTP", Toast.LENGTH_SHORT).show();
                    return;
                }

                viewModel.validateOTP(validateOTP());

            }
        });


        viewModel.getUserProfile().observe(this, new Observer<UserProfileModel>() {
            @Override
            public void onChanged(UserProfileModel userProfile) {
                saveUserProfile(userProfile);
                navigationToUserProfileScreen(userProfile);
            }
        });
    }

    private void navigationToUserProfileScreen(UserProfileModel userProfile) {
        Intent intent = new Intent(OTPScreen.this, UserProfile.class);
        intent.putExtra(USER_PROFILE, userProfile);
        startActivity(intent);
    }

    private void saveUserProfile(UserProfileModel userProfile) {
        SharedPref sharedPref = SharedPref.getInstance(OTPScreen.this);
        sharedPref.saveUserProfile(userProfile);
    }

    public ValidateOTP validateOTP() {

        ValidateOTP validateOTP = new ValidateOTP();
        validateOTP.mobileNo = getIntent().getStringExtra(MOBILE_NO);
        validateOTP.otp = binding.otpPinView.getText().toString();
        validateOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        validateOTP.tokenizedOtp = getIntent().getStringExtra(TOKENIZED_OTP);
        return validateOTP;

    }
}

