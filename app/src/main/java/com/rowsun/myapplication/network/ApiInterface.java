package com.rowsun.myapplication.network;

import com.rowsun.myapplication.model.News;
import com.rowsun.myapplication.model.NewsResponse;
import com.rowsun.myapplication.model.PersonResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/get_news")
    Call<NewsResponse> getNews(@Query("type")String type);

    @GET("broadway/api.php")
    Call<PersonResponse> getPersons();


    @POST("broadway/api.php")
    @FormUrlEncoded
    Call<ResponseBody> savePerson(@Field("type")String type,
                                  @Field("name")String name,
                                  @Field("address")String address,
                                  @Field("phone")String phone
                                  );
}
