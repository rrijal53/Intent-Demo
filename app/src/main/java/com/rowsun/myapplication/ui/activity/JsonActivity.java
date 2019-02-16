package com.rowsun.myapplication.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.model.News;
import com.rowsun.myapplication.model.NewsResponse;
import com.rowsun.myapplication.model.Person;
import com.rowsun.myapplication.model.PersonResponse;
import com.rowsun.myapplication.model.Persons;
import com.rowsun.myapplication.network.ApiClient;
import com.rowsun.myapplication.network.ApiInterface;
import com.rowsun.myapplication.utils.NetworkUtils;
import com.rowsun.myapplication.utils.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        String  st =  Utilities.readStringFromAssetUsinBuffer(this,"abc.json");
        List<Person> personList = Person.fromJson(st);
//        for (Person p : personList){
//            Log.d("JSON", "onCreate: " + p.getName());
//        }

        if (NetworkUtils.isNetworkConnected(this)) {
//
//
//            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//            Call<NewsResponse> call = apiInterface.getNews("sports");
//            call.enqueue(new Callback<NewsResponse>() {
//                @Override
//                public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                    if (response.body() != null && response.body().getStatus().equals("success")) {
//                        List<News> list = response.body().getData();
//                        for (News n:list
//                        ) {
//
//                            Log.d("tag", "Response  " + n+ "");
//                        }
//                    }else{
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<NewsResponse> call, Throwable t) {
//
//                }
//            });

            String name = "Roshan";
            String address = "Address";
            String phone  = "Phone";


            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            apiInterface.savePerson("save_person", name, address, phone)
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.body()!=null){
                                try {
                                    String json = response.body().string();
                                   // Log.d("tag", "onResponse: " + json);
                                    Toast.makeText(JsonActivity.this, json, Toast.LENGTH_LONG).show();
                                    // TODO: 2/15/19 Parse json

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }else{
                                try {
                                    Toast.makeText(JsonActivity.this, response.errorBody().string(), Toast.LENGTH_LONG).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                                t.printStackTrace();
                        }
                    });

            apiInterface.getPersons().enqueue(new Callback<PersonResponse>() {
                @Override
                public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                    if (response.body() != null && response.body().getSuccess().equals("1")) {
                        List<Persons> list = response.body().getData();
                        for (Persons n:list
                        ) {

                            Log.d("tag", "Response  " + n+ "");
                        }
                    }else{

                    }
                }

                @Override
                public void onFailure(Call<PersonResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });

        }else{
            Toast.makeText(JsonActivity.this, "No internet connection", Toast.LENGTH_LONG).show();
        }
    }


}
