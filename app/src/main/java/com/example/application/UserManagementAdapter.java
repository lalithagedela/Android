package com.example.application;



import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.hononow_tasks.databinding.ItemLabtestBinding;
import java.util.ArrayList;


    public class UserManagementAdapter extends RecyclerView.Adapter<com.example.application.UserManagementAdapter.ViewHolder> {


        private ArrayList<UserManagementFragmentModel> data;

        private  UserViewFragment  activity;


        public UserManagementAdapter(ArrayList<UserManagementFragmentModel> data , UserViewFragment activity){
            this.data = data ;
            this.activity = activity;
        }

        @NonNull
        @Override
        public com.example.application.UserManagementAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            LayoutInflater inflater = LayoutInflater.from(activity.getContext());
            ItemLabtestBinding binding  = ItemLabtestBinding .inflate(inflater, parent, false);
            return new com.example.application.UserManagementAdapter.ViewHolder(binding);


        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            UserManagementFragmentModel details = data.get(position);
            holder.bind(details);


        }


        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ItemLabtestBinding binding;

            public ViewHolder(@NonNull ItemLabtestBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }

            public void bind(UserManagementFragmentModel data) {

                binding.testValue.setText(data.getTest_value());
                binding.codeValue.setText(data.getCode_number());
                binding.sampleType.setText(data.getSample_value());
                binding.priceValue.setText(String.valueOf(data.getPrice()));

            }

        }
    }

