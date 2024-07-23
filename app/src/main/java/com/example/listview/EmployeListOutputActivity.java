package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class EmployeListOutputActivity extends AppCompatActivity {


    TextView Employee_name,Employee_id;


    Employee data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_listview_output);


        Employee_name = findViewById(R.id.Employee_name);
        Employee_id = findViewById(R.id.Employee_id);

        data = (Employee) getIntent().getSerializableExtra("Employee");


        Employee_name.setText(data.getEmployeename());
        Employee_id.setText(String.valueOf(data.getEmployeeID()));


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






