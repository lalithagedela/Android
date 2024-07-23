package com.example.application;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hononow_tasks.R;
import com.example.hononow_tasks.databinding.ConsultationBinding;

import java.util.ArrayList;


public class AdminActivity extends AppCompatActivity {

    ConsultationBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ConsultationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<String> text = new ArrayList<>();
        text.add("Clinic Profile");
        text.add("User Management");
        text.add("Doc COnsultation Config");
        text.add("Leave Management");
        text.add("Help Center");

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.user_profile_svgrepo_com);
        images.add(R.drawable.user_profile_svgrepo_com);
        images.add(R.drawable.user_profile_svgrepo_com);
        images.add(R.drawable.user_profile_svgrepo_com);
        images.add(R.drawable.user_profile_svgrepo_com);


        ArrayList<Admin> details = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            String text_name = text.get(i % text.size());

            int image = images.get(i % images.size());

            details.add(new Admin(text_name, image));
        }


        binding.recyclerviewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        AdminAdapter adapter = new AdminAdapter(details, this);
        binding.recyclerviewHorizontal.setAdapter(adapter);
    }
}






