package com.example.CountryState;

import android.os.Bundle;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import java.util.ArrayList;



public class StateListDataActivity extends AppCompatActivity {
    ArrayList<String> states = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_states);

        ListView listView = findViewById(R.id.listview);


        states=(ArrayList<String>) getIntent().getSerializableExtra("states");



        StateListDataAdapter listDataAdapter = new StateListDataAdapter(this, states);
        listView.setAdapter(listDataAdapter);


    }
}



