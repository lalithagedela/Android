package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private int count = 0;


    private ArrayList<Student> addedStudent = new ArrayList<>();
    private ArrayList<Student> student_details;
    private StudentActivity studentActivity;

    public StudentAdapter(StudentActivity studentActivity, ArrayList<Student> student_details) {

        this.studentActivity = studentActivity;
        this.student_details = student_details;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(studentActivity).inflate(R.layout.student_recyclerview_textview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Student student = student_details.get(position);

        holder.rollno.setText(String.valueOf(student.getStudent_no()));

        holder.name.setText(student.getStudent_name());

        holder.image.setImageResource(student.getProfile());

    }

    public int getItemCount() {
        return student_details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, rollno;
        ImageView image;
        Button add_button, delete_button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.student_name);
            rollno = itemView.findViewById(R.id.student_rollno);
            image = itemView.findViewById(R.id.image);

            add_button = itemView.findViewById(R.id.add_button);
            delete_button = itemView.findViewById(R.id.delete_button);
            add_button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Student student  = student_details.get(position);
                        addedStudent.add(student);
                        count++;
                        studentActivity.updateCount(String.valueOf(count));
                        Toast.makeText(v.getContext(), "Added Student  " + student.getStudent_name(), Toast.LENGTH_SHORT).show();
                    }
                }

            });

            delete_button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Student student = student_details.get(position);
                        if (addedStudent.contains(student)) {
                            addedStudent.remove(student);
                            count--;
                            studentActivity.updateCount(String.valueOf(count));
                            Toast.makeText(v.getContext(), "Removed Student " + student.getStudent_name(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            });
        }
    }
}






