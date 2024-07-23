package com.example.Dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ServiceActivity extends AppCompatActivity {
    private TextView nursingData, phyData, consultData, pharmacyData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);

        Button nursingButton = findViewById(R.id.nursing_button);
        Button physiotherapyButton = findViewById(R.id.physiotherapy_button);
        Button doctorConsultationButton = findViewById(R.id.doctor_consultation);
        Button pharmacyButton = findViewById(R.id.pharmacy);

        nursingData = findViewById(R.id.nursing_data);
        phyData = findViewById(R.id.phy_data);
        consultData = findViewById(R.id.consult_data);
        pharmacyData = findViewById(R.id.pharmacy_data);


        nursingData.setVisibility(View.GONE);
        phyData.setVisibility(View.GONE);
        consultData.setVisibility(View.GONE);
        pharmacyData.setVisibility(View.GONE);

        nursingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllDataViewsGone();
                nursingData.setVisibility(View.VISIBLE);
            }
        });

        physiotherapyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllDataViewsGone();
                phyData.setVisibility(View.VISIBLE);
            }
        });

        doctorConsultationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllDataViewsGone();
                consultData.setVisibility(View.VISIBLE);
            }
        });

        pharmacyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllDataViewsGone();
                pharmacyData.setVisibility(View.VISIBLE);
            }
        });
    }


        private void setAllDataViewsGone() {
            nursingData.setVisibility(View.GONE);
            phyData.setVisibility(View.GONE);
            consultData.setVisibility(View.GONE);
            pharmacyData.setVisibility(View.GONE);
        }

    }