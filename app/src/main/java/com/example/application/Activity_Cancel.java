package com.example.application;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hononow_tasks.R;

public class Activity_Cancel extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment);

        TextView eligible_text= findViewById(R.id.text);

        SpannableString string = new SpannableString("Eligible for Refund Amount Rs.500");
        string.setSpan(new ForegroundColorSpan(getColor(R.color.light_green)), string.toString().indexOf("Eligible"), string.toString().lastIndexOf("Rs"), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        string.setSpan(new ForegroundColorSpan(getColor(R.color.dark_green)), string.toString().indexOf("Rs"), string.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        eligible_text.setText(string);
    }
}