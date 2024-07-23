package com.example.mvvm.network;


import static com.example.mvvm.constants.URL;
import com.example.mvvm.APIInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    static RetrofitClient retrofitClient;

    private final Retrofit retrofit;

    private RetrofitClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);


        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

    }

    public static RetrofitClient getInstance() {
        retrofitClient = new RetrofitClient();
        return retrofitClient;
    }

    public APIInterface getRetrofitAPI() {
        return retrofit.create(APIInterface.class);
    }
}

