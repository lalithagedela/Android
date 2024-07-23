package com.example.mvc.view;


import static com.example.mvc.constants.APPLICATION_ID;
import static com.example.mvc.constants.MOBILE_NO;
import static com.example.mvc.constants.STRING;
import static com.example.mvc.constants.TOKENIZED_OTP;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.mvc.controller.LoginController;
import com.example.mvc.model.RequestOTP;
import com.example.myapplication.databinding.LoginScreenBinding;

public class LoginScreen extends AppCompatActivity implements LoginController.LoginControllerCallback {
    LoginScreenBinding binding;

    LoginController loginController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginController = new LoginController(this, this);

        binding.sendOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( binding.mobilenumber.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a valid mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }
                binding.progressBar.setVisibility(View.VISIBLE);

                loginController.sendOTP(requestOTP());


            }
        });
    }

    @Override
    public void sent_otp(String tokenizedOtp) {
        binding.progressBar.setVisibility(View.GONE);
        navigateToOTPScreen(tokenizedOtp);
    }



    private void navigateToOTPScreen(String tokenizedOtp) {
        Intent intent = new Intent(LoginScreen.this, OTPScreen.class);
        intent.putExtra(TOKENIZED_OTP, tokenizedOtp);
        intent.putExtra(MOBILE_NO, binding.mobilenumber.getText().toString());
        startActivity(intent);
    }

    private RequestOTP requestOTP() {
        RequestOTP requestOTP = new RequestOTP();
        requestOTP.mobileNo =  binding.mobilenumber.getText().toString();
        requestOTP.secretKey = STRING;
        requestOTP.applicationID = APPLICATION_ID;
        requestOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        requestOTP.isResend = false;
        return requestOTP;
    }
}