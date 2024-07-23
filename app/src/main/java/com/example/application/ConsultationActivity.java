package com.example.application;


import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.hononow_tasks.R;
import com.example.hononow_tasks.databinding.ConsultationBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;


public class ConsultationActivity extends AppCompatActivity {

    ConsultationBinding binding;

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ConsultationBinding.inflate(getLayoutInflater());
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


        for (int i = 1; i <= 10; i++) {



            Chip chip = new Chip(this);
            chip.setText("Room " + i);
            chip.setTextColor(getResources().getColor(R.color.chip_color));
            chip.setChipStrokeColorResource(R.color.chip_border);
            chip.setChipStrokeWidth(1);
            chip.setChipCornerRadius(0);
            chip.setTextSize(20);
            binding.chipGroup.addView(chip);



        }


        ConsultationAdapter adapter = new ConsultationAdapter(details, this);
        binding.recyclerviewHorizontal.setAdapter(adapter);
        binding.recyclerviewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        BottomSheetDialog bottom_dialog = new BottomSheetDialog(this);


        binding.addRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_dialog.setContentView(R.layout.consultation_bottom_sheet);
                bottom_dialog.show();
            }
        });
    }
}


