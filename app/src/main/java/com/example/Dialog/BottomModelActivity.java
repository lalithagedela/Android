package com.example.Dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class BottomModelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet);

        Button Model_sheet =  findViewById(R.id.bottom_sheet);

        Model_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomDialogActivity bottomSheet = new BottomDialogActivity();
                bottomSheet.show(getSupportFragmentManager(),"ModalBottomSheet");

            }
        });


    }
}
