package com.rowsun.myapplication.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://10.0.2.2:8888/";
    static Retrofit instance;

    public static Retrofit getClient() {

        OkHttpClient client = new OkHttpClient();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
