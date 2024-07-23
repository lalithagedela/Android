package com.example.application;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.hononow_tasks.databinding.FragmentLayoutUsermanagementBinding;


import java.util.ArrayList;

public class UserViewFragment extends Fragment {

    FragmentLayoutUsermanagementBinding binding;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = FragmentLayoutUsermanagementBinding.inflate(getLayoutInflater());



            ArrayList<String> test_value = new ArrayList<>();
            test_value.add("AFB Smear,Slit Skin Group: Microbiology ,TAT: 6 hrs ");
            test_value.add("AFB Smear,Slit Skin Group: Microbiology ,TAT: 8 hrs ");



            ArrayList<String> code_number = new ArrayList<>();
            code_number.add("S1279");
            code_number.add("S1278");



            ArrayList<String> Sample_value = new ArrayList<>();
            Sample_value.add("Slit Skin");
            Sample_value.add("MedicalCare");



            ArrayList<Integer> price = new ArrayList<>();
            price.add(1000);
            price.add(2000);




            ArrayList<UserManagementFragmentModel> cardItems = new ArrayList<>();

            for(int i=0;i<2;i++){
                String test_name = test_value.get(i % test_value.size());


                String code = code_number.get(i% code_number.size());

                String value = Sample_value.get(i%Sample_value.size());

                Integer price_value = price.get(i%price.size());

                cardItems.add(new UserManagementFragmentModel(test_name,code,value,price_value));
            }




            binding.fragmentCardviewRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
            UserManagementAdapter adapter = new UserManagementAdapter(cardItems,this);
            binding.fragmentCardviewRecyclerview.setAdapter(adapter);

            return  binding.getRoot();


        }
    }



