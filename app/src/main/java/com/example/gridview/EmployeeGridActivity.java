package com.example.gridview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class EmployeeGridActivity extends AppCompatActivity {

    ArrayList<Employee> emp_details = new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emp_gridview_layout);
        GridView gridview = findViewById(R.id.gridview);

        setdetails();

        EmployeeGridAdapter empgridadapter = new EmployeeGridAdapter(this,emp_details);
        gridview.setAdapter(empgridadapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Employee emp = (Employee) parent.getItemAtPosition(position);
                Intent intent = new Intent(EmployeeGridActivity.this, EmployeeGridOutputActivity.class);
                intent.putExtra("emp_details", emp);
                startActivity(intent);

                Toast.makeText(getBaseContext( ), "Selected Employee " + (emp.EmployeeName),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setdetails(){


        Employee lalitha = new Employee();
        lalitha.EmployeeName="lalitha";
        lalitha.EmployeeID=85;
        lalitha.emp_profile=R.drawable.user_profile;
        emp_details.add(lalitha);


        Employee archana = new Employee();
        archana.EmployeeName="archana";
        archana.EmployeeID=89;
        archana.emp_profile=R.drawable.user_profile;
        emp_details.add(archana);


        Employee lalli = new Employee();
        lalli.EmployeeName="lalli";
        lalli.EmployeeID=87;
        lalli.emp_profile=R.drawable.user_profile;
        emp_details.add(lalli);


        Employee tejuu = new Employee();
        tejuu.EmployeeName="tejuu";
        tejuu.EmployeeID=87;
        tejuu.emp_profile=R.drawable.user_profile;
        emp_details.add(tejuu);


        Employee srija = new Employee();
        srija.EmployeeName="srija";
        srija.EmployeeID=90;
        srija.emp_profile=R.drawable.user_profile;
        emp_details.add(srija);


        Employee saru = new Employee();
        saru.EmployeeName="saru";
        saru.EmployeeID=97;
        saru.emp_profile=R.drawable.user_profile;
        emp_details.add(saru);


        Employee jathin = new Employee();
        jathin.EmployeeName="jathin";
        jathin.EmployeeID=110;
        jathin.emp_profile=R.drawable.user_profile;
        emp_details.add(jathin);

    }

}
