package com.example.application;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hononow_tasks.databinding.ItemLayoutsBinding;
import java.util.ArrayList;


public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.ViewHolder> {

    private ArrayList<HealthModel> data;

    private HealthActivity activity;
    public HealthAdapter(ArrayList data, HealthActivity activity){
        this.data = data;
        this.activity = activity;

    }


    @NonNull
    @Override
    public HealthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(activity);
        ItemLayoutsBinding binding  =ItemLayoutsBinding .inflate(inflater, parent, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull HealthAdapter.ViewHolder holder, int position) {

        HealthModel details = data.get(position);
        holder.bind(details);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutsBinding binding;

        public ViewHolder(@NonNull ItemLayoutsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HealthModel data) {

        binding.labDetailsCompleteCheckbox.setText(data.getData());
        binding.completed.setText(data.getStatus());
        }
    }
}