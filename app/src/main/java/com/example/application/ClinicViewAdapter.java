package com.example.application;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hononow_tasks.databinding.ItemFragmentLayoutBinding;

import java.util.ArrayList;

public class ClinicViewAdapter extends RecyclerView.Adapter<ClinicViewAdapter.ViewHolder> {


    private ArrayList<ClinicProfileFragmentModel> data;

    private ClinicViewFragment activity;


    public ClinicViewAdapter(ArrayList<ClinicProfileFragmentModel> data , ClinicViewFragment activity){
        this.data = data ;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ClinicViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(activity.getContext());
        ItemFragmentLayoutBinding binding  = ItemFragmentLayoutBinding .inflate(inflater, parent, false);
        return new ClinicViewAdapter.ViewHolder(binding);


    }

    @Override
    public void onBindViewHolder(@NonNull ClinicViewAdapter.ViewHolder holder, int position) {
        ClinicProfileFragmentModel details = data.get(position);
        holder.bind(details);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

      ItemFragmentLayoutBinding binding;

        public ViewHolder(@NonNull ItemFragmentLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ClinicProfileFragmentModel data) {

            binding.image.setImageResource(data.getImage());
            binding.textview.setText(data.getText());
            binding.place.setText(data.getPlace());
            binding.mobileNum.setText(data.getMobile_num());
            binding.houNetworkData.setText(data.getNetwork_data());
            binding.textAddress.setText(data.getAddress_text());


        }



        }


}