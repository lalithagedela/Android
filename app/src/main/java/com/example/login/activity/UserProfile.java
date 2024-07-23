package com.example.login.activity;


import static com.example.login.constants.USER_PROFILE;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login.model.UserProfileModel;
import com.example.myapplication.databinding.UserProfileBinding;



public class UserProfile extends AppCompatActivity {

    UserProfileBinding binding;
    UserProfileModel data;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = UserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        data = (UserProfileModel) getIntent().getSerializableExtra(USER_PROFILE) ;
//        binding.setUserProfile(data);



    }
}
