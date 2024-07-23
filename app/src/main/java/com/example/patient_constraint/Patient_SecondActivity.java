package com.example.patient_constraint;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.FormModel;
import com.example.myapplication.R;

public class Patient_SecondActivity extends AppCompatActivity {

    Patient_Model data;

    TextView First_Name, Last_Name, Email,  PhoneNumber, Address, zipcode, country, date_of_birth, occupation, city, state, age, gender, maritalStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_output);


        First_Name = findViewById(R.id.firstname);
        Last_Name = findViewById(R.id.lastname);
        Email = findViewById(R.id.Email);
        PhoneNumber = findViewById(R.id.Phone);
        Address = findViewById(R.id.Address);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        zipcode = findViewById(R.id.zipcode);
        country = findViewById(R.id.Country);
        date_of_birth = findViewById(R.id.date);
        age = findViewById(R.id.Age);
        occupation = findViewById(R.id.Occupation);
        gender = findViewById(R.id.Gender);
        maritalStatus = findViewById(R.id.Martial_Status);




        data = (Patient_Model) getIntent().getSerializableExtra("Details");



        First_Name.setText(data.getFirstname());
        Last_Name.setText(data.getLastname());
        Email.setText(data.getEmail());
        PhoneNumber.setText(data.getPhoneNumber());
        Address.setText(data.getAddress());
        city.setText(data.getCity());
        state.setText(data.getState());
        zipcode.setText(data.getZipcode());
        country.setText(data.getCountry());
        date_of_birth.setText(data.getDate());
        age.setText(data.getAge());
        occupation.setText(data.getOccupation());
        gender.setText(data.getGender());
        maritalStatus.setText(data.getMartial_status());

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy: ");
    }
}
