package com.example.Dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class BottomSheetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet);

        Button model_button = findViewById(R.id.bottom_sheet);
        BottomSheetDialog bottom_dialog = new BottomSheetDialog(this);



        model_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottom_dialog.setContentView(R.layout.payment_mode_window);

                bottom_dialog.show();
            }
        });








    }
}
