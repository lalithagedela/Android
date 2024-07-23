package com.example.Dialog;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class StatusActivity extends AppCompatActivity {

        Spinner statusSpinner, locationSpinner, citySpinner, documentSpinner;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.status);



            statusSpinner = findViewById(R.id.status_spinner);
            locationSpinner = findViewById(R.id.location_spinner);
            citySpinner = findViewById(R.id.city_spinner);
            documentSpinner = findViewById(R.id.document_spinner);

            setupSpinner(statusSpinner, R.array.status);
            setupSpinner(locationSpinner, R.array.location);
            setupSpinner(citySpinner, R.array.city);
            setupSpinner(documentSpinner, R.array.Document);
        }

        private void setupSpinner(Spinner spinner, int arrayResId) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrayResId, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);



        }
    }






