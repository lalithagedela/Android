package com.example.application;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.hononow_tasks.R;
import com.example.hononow_tasks.databinding.ClinicAdminBinding;



import java.util.ArrayList;
public class AdminProfileActivity extends AppCompatActivity {

    ClinicAdminBinding binding;

    AdminProfileAdapter adapter;


    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ClinicAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<String> text = new ArrayList<>();


        text.add("Clinic Profile");
        text.add("User Management");
        text.add("Shift Board");
        text.add("Consultation Room");
        text.add("Leave Management");


        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.fa_solid_clinic_medical);
        images.add(R.drawable.group);
        images.add(R.drawable.vector__3_);
        images.add(R.drawable.cbi_rooms_front_door);
        images.add(R.drawable.solar_calendar_bold);


        ArrayList<Admin> details = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            String text_name = text.get(i % text.size());

            int image = images.get(i % images.size());

            details.add(new Admin(text_name, image));
        }





        adapter = new AdminProfileAdapter(details, this);
        binding.recyclerviewHorizontal.setAdapter(adapter);

        binding.recyclerviewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        adapter.setOnItemClickListener(new AdminProfileAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        replaceFragment(new ClinicViewFragment());
                        break;
                    case 1:
                        replaceFragment(new UserViewFragment());
                        break;
                }
            }
        });




    }

    private void replaceFragment(Fragment fragment) {


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();

    }

}












