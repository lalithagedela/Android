package com.example.mvvm.view;


import static com.example.mvvm.constants.SAVED_PROFILE;
import static com.example.mvvm.constants.USER_PROFILE;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvvm.model.UserProfileModel;
import com.example.myapplication.databinding.SplashScreenBinding;
import com.google.gson.Gson;

public class LoginSplashScreen extends AppCompatActivity {

    SplashScreenBinding binding;

   @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = SplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                binding.progressBar.setVisibility(View.VISIBLE);


                SharedPref sharedPref =  SharedPref.getInstance(LoginSplashScreen.this);
                String profile = sharedPref.getString(SAVED_PROFILE);



                Intent intent;
                if (profile != null) {
                   intent = new Intent(LoginSplashScreen.this, UserProfile.class);
                    intent.putExtra(USER_PROFILE, new Gson().fromJson(profile, UserProfileModel.class));
                }
                else {
                    intent = new Intent(LoginSplashScreen.this, LoginScreen.class);
                }

                startActivity(intent);

            }
        });

    }


}
