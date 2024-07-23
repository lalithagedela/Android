package com.example.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.myapplication.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomDialogActivity extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.model_dialog, container, false);

        Button emp = v.findViewById(R.id.employees);
        Button manager = v.findViewById(R.id.managers);



        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Show Employees", Toast.LENGTH_SHORT).show();

            }
        });

        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Show Managers", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}

