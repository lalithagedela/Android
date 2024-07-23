package com.example.recyclerview;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.R;
import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_recyclerview);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        int SpanCount=2;

        ArrayList<String> employee = new ArrayList<>();

        employee.add("lalitha");
        employee.add("Dijili");
        employee.add("lalli");
        employee.add("srija");
        employee.add("shivani");
        employee.add("sriya");
        employee.add("saritha");



        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.student_image1);
        images.add(R.drawable.student_image2);
        images.add(R.drawable.student_image3);
        images.add(R.drawable.student_image4);
        images.add(R.drawable.student_image5);
        images.add(R.drawable.student_image6);
        images.add(R.drawable.user_profile);



        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        //recyclerView.setLayoutManager(new GridLayoutManager(this, SpanCount));


        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));




        EmployeeAdapter adapter = new EmployeeAdapter(this,employee,images);
        recyclerView.setAdapter(adapter);



        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
