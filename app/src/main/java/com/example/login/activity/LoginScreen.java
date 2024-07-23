package com.example.login.activity;


import static com.example.login.constants.APPLICATION_ID;
import static com.example.login.constants.MOBILE_NO;
import static com.example.login.constants.STRING;
import static com.example.login.constants.TOKENIZED_OTP;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



import com.example.login.model.RequestOTPResponse;
import com.example.login.model.RequestOTP;
import com.example.login.network.RetrofitClient;
import com.example.myapplication.databinding.LoginScreenBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginScreen extends AppCompatActivity   {
    LoginScreenBinding binding;
    String tokenizedOtp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = LoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.sendOtpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.mobilenumber.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"please enter valid mobile number",Toast.LENGTH_SHORT).show();
                    return;
                }


                binding.progressBar.setVisibility(View.VISIBLE);


                RetrofitClient.getInstance().getRetrofitAPI().sendAdminOTP(requestOTP())
                        .enqueue(new Callback<RequestOTPResponse>() {
                            @Override
                            public void onResponse(Call<RequestOTPResponse> call, Response<RequestOTPResponse> response) {

                                if (response.isSuccessful() && response.code() == 200) {
                                    binding.progressBar.setVisibility(View.GONE);
                                    tokenizedOtp= response.body().tokenizedOTP;
                                    navigationToOTPScreen();

                                }
                            }

                            @Override
                            public void onFailure(Call<RequestOTPResponse> call, Throwable t) {

                            }

                        });
            }

        });
    }


    private RequestOTP requestOTP(){

        RequestOTP requestOTP = new RequestOTP();

        requestOTP.mobileNo = binding.mobilenumber.getText().toString() ;
        requestOTP.secretKey = STRING;
        requestOTP.applicationID = APPLICATION_ID;
        requestOTP.deviceKey = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID) ;
        requestOTP.isResend = false;
        return requestOTP;

    }


    private void navigationToOTPScreen(){

        Intent intent = new Intent(LoginScreen.this, OTPScreen.class);
        intent.putExtra(TOKENIZED_OTP, tokenizedOtp);
        intent.putExtra(MOBILE_NO, binding.mobilenumber.getText().toString());
        startActivity(intent);

    }

}








































