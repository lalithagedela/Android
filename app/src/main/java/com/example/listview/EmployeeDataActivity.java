package com.example.listview;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import java.util.ArrayList;
public class EmployeeDataActivity extends AppCompatActivity {

    ArrayList<Employee> details = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_listview);
        ListView listview = findViewById(R.id.listview);

        setdetails();

        EmployeeDataAdapter employee = new EmployeeDataAdapter(this, details);
        listview.setAdapter(employee);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Employee emp = (Employee) parent.getItemAtPosition(position);
                Intent intent = new Intent(EmployeeDataActivity.this, EmployeListOutputActivity.class);
                intent.putExtra("Employee", emp);
                startActivity(intent);


            }
        });
    }

    private void setdetails(){


        Employee Lalitha = new Employee();
        Lalitha.EmployeeName="Lalitha";
        Lalitha.EmployeeID=85;
        Lalitha.emp_profile=R.drawable.user_profile;
        details.add(Lalitha);


        Employee Archana = new Employee();
        Archana.EmployeeName="Archana";
        Archana.EmployeeID=89;
        Archana.emp_profile=R.drawable.user_profile;
        details.add(Archana);


        Employee Lalli = new Employee();
        Lalli.EmployeeName="Lalli";
        Lalli.EmployeeID=87;
        Lalli.emp_profile=R.drawable.user_profile;
        details.add(Lalli);


        Employee Tejuu = new Employee();
        Tejuu.EmployeeName="Tejuu";
        Tejuu.EmployeeID=87;
        Tejuu.emp_profile=R.drawable.user_profile;
        details.add(Tejuu);

    }
}
