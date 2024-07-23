package com.example.mvvm.view;


import static com.example.mvvm.constants.APPLICATION_ID;
import static com.example.mvvm.constants.MOBILE_NO;
import static com.example.mvvm.constants.STRING;
import static com.example.mvvm.constants.TOKENIZED_OTP;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import com.example.mvvm.model.RequestOTP;
import com.example.mvvm.viewmodel.LoginViewModel;
import com.example.myapplication.databinding.LoginScreenBinding;

public class LoginScreen extends AppCompatActivity {

    LoginScreenBinding binding;
    LoginViewModel viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = LoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);


        binding.sendOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.mobilenumber.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter the  valid mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }

                viewModel.sendOTP(requestOTP());

            }
        });


        viewModel.getTokenizedOTP().observe(this, new Observer<String>() {

            @Override
            public void onChanged(String tokenizedOTP) {
                navigationToOTPScreen(tokenizedOTP);

            }
        });
    }


    private void navigationToOTPScreen(String tokenizedOtp) {
        Intent intent = new Intent(LoginScreen.this, OTPScreen.class);
        intent.putExtra(TOKENIZED_OTP, tokenizedOtp);
        intent.putExtra(MOBILE_NO, binding.mobilenumber.getText().toString());
        startActivity(intent);

    }


    public RequestOTP requestOTP() {
        RequestOTP requestOTP = new RequestOTP();
        requestOTP.mobileNo = binding.mobilenumber.getText().toString();
        requestOTP.secretKey = STRING;
        requestOTP.applicationID = APPLICATION_ID;
        requestOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        requestOTP.isResend = false;
        return requestOTP;
    }


}


