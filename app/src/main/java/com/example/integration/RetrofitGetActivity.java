package com.example.integration;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGetActivity extends AppCompatActivity {

    ListView listview;
    Button get_data;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_get);

        listview = findViewById(R.id.listview_data);
        get_data = findViewById(R.id.get_button);

        get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Get_data();

            }
        });

    }
    private void Get_data() {

        Retrofit retrofit_data = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface retrofitAPI = retrofit_data.create(Interface.class);

        Call<Get_Model> call = retrofitAPI.getAllData("2");

        call.enqueue(new Callback<Get_Model>() {
            @Override
            public void onResponse(Call<Get_Model> call, Response<Get_Model> response) {

                ArrayList<Get_Model.data> data = response.body().getData();

                String[] names = new String[data.size()];

                for (int i = 0; i < data.size(); i++) {

                    names[i] = "Id : " + data.get(i).getId() + "\nName : " + data.get(i).getFirst_name() + " " + data.get(i).getLast_name() + "\nEmail : " + data.get(i).getEmail();
                }

                listview.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names));


            }

            @Override
            public void onFailure(Call<Get_Model> call, Throwable t) {
                Toast.makeText(getApplicationContext(), " Error Occured", Toast.LENGTH_LONG).show();
            }
        });
    }
}
