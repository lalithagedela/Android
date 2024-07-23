package com.example.CountryState;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import java.util.ArrayList;

public class CountriesListDataActivity extends AppCompatActivity {
    ArrayList<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_countries);

        ListView listView = findViewById(R.id.listview);

        setCountries();

        CountriesListDataAdapter countrylistDataAdapter = new CountriesListDataAdapter(this, countries);
        listView.setAdapter(countrylistDataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Country country = (Country) parent.getItemAtPosition(position);
                Intent intent = new Intent(CountriesListDataActivity.this, StateListDataActivity.class);
                intent.putExtra("states", country.getStates());
                startActivity(intent);

            }
        });

    }

    private void setCountries(){

        Country india = new Country();
        india.countryName="india";
        india.setCountryID(1);
        india.setStates(setIndiaStates());
        countries.add(india);


        Country USA = new Country();
        USA.countryName = "USA";
        USA.setCountryID(2);
        USA.setStates(setUsStates());
        countries.add(USA);



        Country UK = new Country();
        UK.countryName = "UK";
        UK.setCountryID(3);
        UK.setStates(setUKStates());
        countries.add(UK);



    }


    private ArrayList<String> setIndiaStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Andhra Pradesh");
        states.add("Telangana");
        states.add("Karnataka");
        states.add("Maharashtra");
        states.add("Uttar Pradesh");
        return states;
    }

    private ArrayList<String> setUsStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Texas");
        states.add("California");
        states.add("Florida");
        states.add("Chicago");
        states.add("Sidney");
        return states;
    }
    private ArrayList<String> setUKStates() {
        ArrayList<String> states = new ArrayList<>();
        states.add("Texas");
        states.add("California");
        states.add("Florida");
        states.add("Chicago");
        states.add("Sidney");
        return states;
    }
}


