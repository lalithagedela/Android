package com.example.sample;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import com.example.myapplication.databinding.SampleMvvmBinding;



public class LoginActivity extends AppCompatActivity {
    SampleMvvmBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = SampleMvvmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.setModel(new LoginViewModel());
    }


    @BindingAdapter({"toastMessage"})
    public static void method(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }

}


