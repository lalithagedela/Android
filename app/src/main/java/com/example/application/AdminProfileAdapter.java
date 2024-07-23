package com.example.application;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hononow_tasks.databinding.ItemClinicCardviewBinding;
import java.util.ArrayList;



public class AdminProfileAdapter extends RecyclerView.Adapter<AdminProfileAdapter.ViewHolder>{


    private ArrayList<Admin> data;

    private AdminProfileActivity activity;
    private OnItemClickListener onItemClickListener;

    public AdminProfileAdapter(ArrayList<Admin>  data, AdminProfileActivity activity){
        this.data = data;
        this.activity = activity;
    }



    @NonNull
    @Override
    public AdminProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(activity);
        ItemClinicCardviewBinding binding  = ItemClinicCardviewBinding .inflate(inflater, parent, false);
        return new AdminProfileAdapter.ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull AdminProfileAdapter.ViewHolder holder, int position) {

        Admin  details = data.get(position);
        holder.bind(details);


        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
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
