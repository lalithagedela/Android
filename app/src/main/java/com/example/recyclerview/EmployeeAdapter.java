package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import java.util.ArrayList;

public class EmployeeAdapter  extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {


    private  final ArrayList<String> employee;

    private  final  ArrayList<Integer> images;
    private final   EmployeeActivity employeeActivity;

    public EmployeeAdapter(EmployeeActivity employeeActivity, ArrayList<String> employee,ArrayList<Integer> images) {

        this.employeeActivity = employeeActivity;
        this.employee = employee;
        this.images=images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(employeeActivity).inflate(R.layout.employee_recycler_textview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
        holder.textview.setText(employee.get(position));
        holder.imageView.setImageResource(images.get(position));

    }

    public int getItemCount() {
        return employee.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textview;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.employee_textview);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}




