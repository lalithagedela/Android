package com.example.integration;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class PostActivity extends AppCompatActivity {

    private EditText Username,Password;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);


        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        textView = findViewById(R.id.textview);



        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postData();
            }
        });
    }
    public void postData() {
        String username =Username.getText().toString();
        String password = Password.getText().toString();
        String url = "https://reqres.in/api/users";
        new PostData().execute(url,username,password);
    }
    private class PostData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String urlString = params[0];
            String username = params[1];
            String password = params[2];
            String result = "";
            HttpURLConnection urlConnection = null;

            try {


                URL url = new URL(urlString);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.setChunkedStreamingMode(0);



                String postData = "username=" + username + "&password=" + password;
                OutputStream os = urlConnection.getOutputStream();
                os.write(postData.getBytes());
                os.close();



                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                result = sb.toString();
                bufferedReader.close();
            }

            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
        }
    }
}






