package com.example.integration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;




import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPostActivity extends AppCompatActivity {

    private EditText name,profession;
    private Button post_data;
    private TextView Message;
    private ProgressBar progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_post);


        post_data = findViewById(R.id.post_button);
        Message = findViewById(R.id.message_text);
        name = findViewById(R.id.name);
        profession = findViewById(R.id.profession);
        progress = findViewById(R.id.progress);


        post_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = name.getText().toString();
                String Profession = profession.getText().toString();

                postData(Name,Profession);

            }
        });

    }

    private void postData(String Name,String Profession){
        Retrofit retrofit_data = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface retrofitAPI = retrofit_data.create(Interface.class);

        Post_Model post_modal = new Post_Model(Name, Profession);

        Call<Post_Model> call = retrofitAPI.createPost(post_modal);

        call.enqueue(new Callback<Post_Model>() {

            @Override
            public void onResponse(Call<Post_Model> call, Response<Post_Model> response) {

                Toast.makeText(getApplicationContext(),"Data added to API",Toast.LENGTH_SHORT).show();

                progress.setVisibility(View.GONE);


                profession.setText(" ");
                name.setText(" ");


                Post_Model responseFromAPI = response.body();


                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getProfession();

                Message.setText(responseString);
            }

            @Override
            public void onFailure(Call<Post_Model> call, Throwable t) {

                Message.setText("Error found is : "+t.getMessage());

            }
        });


    }
}
