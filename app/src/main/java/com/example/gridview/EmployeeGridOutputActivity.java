package com.example.gridview;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class EmployeeGridOutputActivity extends AppCompatActivity {


    TextView emp_name,emp_id;
    Employee data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emp_gridview_output);


        emp_name = findViewById(R.id.emp_name);
        emp_id = findViewById(R.id.emp_id);

        data = (Employee) getIntent().getSerializableExtra("emp_details");


        emp_name.setText(data.getEmployeename());
        emp_id.setText(String.valueOf(data.getEmployeeID()));


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






