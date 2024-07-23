package com.example.recyclerview;



import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import java.util.ArrayList;



    public   class StudentActivity extends AppCompatActivity {
        private TextView icon_text;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.student_recyclerview);

            RecyclerView recyclerView = findViewById(R.id.view);

            ArrayList<String> list = new ArrayList<>();


            list.add("saritha");
            list.add("archana");
            list.add("lalli");
            list.add("dijili");
            list.add("lalitha");


            ArrayList<Integer> images = new ArrayList<>();
            images.add(R.drawable.student_image3);
            images.add(R.drawable.student_image1);
            images.add(R.drawable.student_image4);
            images.add(R.drawable.student_image5);
            images.add(R.drawable.student_image6);


            ArrayList<Student> student_details = new ArrayList<>();

            for (int i = 0; i < 100; i++) {

                String name = list.get(i % list.size());

                int image = images.get(i % images.size());

                student_details.add(new Student(name, 1 + i, image));
            }

            icon_text= findViewById(R.id.cart_text);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            StudentAdapter adapter = new StudentAdapter(this, student_details);
            recyclerView.setAdapter(adapter);


            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
            recyclerView.addItemDecoration(dividerItemDecoration);

        }

        public void updateCount(String count) {
            icon_text.setText(String.valueOf(count));
        }
    }


