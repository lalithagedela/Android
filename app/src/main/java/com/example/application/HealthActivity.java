package com.example.application;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.hononow_tasks.R;
import com.example.hononow_tasks.databinding.HealthonusclinicBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
public class HealthActivity extends AppCompatActivity {
    HealthonusclinicBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HealthonusclinicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<String> lab_details = new ArrayList<>();
        lab_details.add("Smear,Pus,Code:S1283,Group:Microbiology,TAT:6hrs4321");


        ArrayList<String> lab_status = new ArrayList<>();

        lab_status.add("Completed");
        lab_status.add("Status Completed");


        ArrayList<HealthModel> data = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String info = lab_details.get(i % lab_details.size());
            String status = lab_status.get(i % lab_status.size());

            data.add(new HealthModel(info, status));

        }
        binding.houClinicRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        HealthAdapter adapter = new HealthAdapter(data, this);
        binding.houClinicRecyclerview.setAdapter(adapter);


        BottomSheetDialog bottom_dialog = new BottomSheetDialog(this);


        binding.dashes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_dialog.setContentView(R.layout.bottomsheet);
                bottom_dialog.show();
            }
        });

    }
}



