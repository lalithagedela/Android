package com.example.application;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hononow_tasks.R;
import com.example.hononow_tasks.databinding.FragmentLayoutClinicBinding;

import java.util.ArrayList;


public class ClinicViewFragment extends Fragment {

    FragmentLayoutClinicBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLayoutClinicBinding.inflate(getLayoutInflater());


        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.user_profile_svgrepo_com);
        images.add(R.drawable.user_profile_svgrepo_com);

        ArrayList<String> clinic_center = new ArrayList<>();
        clinic_center.add("People Care Wellness Center");
        clinic_center.add("Medical   Care");

        ArrayList<String> location = new ArrayList<>();
        location.add("Madhapur");
        location.add("Hyderabad");

        ArrayList<String> mobile_num = new ArrayList<>();
        mobile_num.add("+91 9636936989");
        mobile_num.add("+91 8529639632");

        ArrayList<String> confirmation = new ArrayList<>();
        confirmation.add("Yes");
        confirmation.add("No");

        ArrayList<String> address = new ArrayList<>();
        address.add("1-92,Kavuri Hills Rd,Kummari Basti,Vittal Rao \n Nagar,Madhapur,Hyderabad-500081");
        address.add("1-92,Kavuri Hills Rd,Kummari Basti,Vittal Rao \n Nagar,kondapur,Hyderabad-500081");

        ArrayList<ClinicProfileFragmentModel> cardItems = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String center = clinic_center.get(i % clinic_center.size());

            int image = images.get(i % images.size());

            String place = location.get(i % location.size());

            String mobile_no = mobile_num.get(i % mobile_num.size());

            String hou_network = confirmation.get(i % confirmation.size());

            String Address = address.get(i % address.size());

            cardItems.add(new ClinicProfileFragmentModel(image, center, place, mobile_no, hou_network, Address));


        }


        binding.fragmentCardviewRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        ClinicViewAdapter adapter = new ClinicViewAdapter(cardItems, this);
        binding.fragmentCardviewRecyclerview.setAdapter(adapter);


        return binding.getRoot();


    }
}

