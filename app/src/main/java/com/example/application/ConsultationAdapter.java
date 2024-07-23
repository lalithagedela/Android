package com.example.application;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hononow_tasks.databinding.ItemClinicCardviewBinding;
import java.util.ArrayList;


public class ConsultationAdapter extends RecyclerView.Adapter<com.example.application.ConsultationAdapter.ViewHolder>{

        private ArrayList<Admin> data;

        private ConsultationActivity activity;


        public ConsultationAdapter(ArrayList<Admin>  data, ConsultationActivity activity){
            this.data = data;
            this.activity = activity;
        }


        @NonNull
        @Override
        public com.example.application.ConsultationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(activity);
            ItemClinicCardviewBinding binding  = ItemClinicCardviewBinding .inflate(inflater, parent, false);
            return new com.example.application.ConsultationAdapter.ViewHolder(binding);

        }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Admin  details = data.get(position);
        holder.bind(details);

    }


        @Override
        public int getItemCount() {
            return data.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {

            ItemClinicCardviewBinding binding;

            public ViewHolder(@NonNull ItemClinicCardviewBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            public void bind(Admin data) {

                binding.textview.setText(data.getText());
                binding.image.setImageResource(data.getProfile());

            }
        }

    }


