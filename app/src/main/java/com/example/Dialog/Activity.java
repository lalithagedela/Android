package com.example.Dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_mode_window);

        Dialog dialog = new Dialog(this);

        Button cross_symbol = findViewById(R.id.cross);



        cross_symbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Activity.this.finish();

                System.exit(0);

            }
        });



    }
}
