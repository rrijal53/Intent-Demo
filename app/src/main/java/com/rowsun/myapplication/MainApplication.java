package com.rowsun.myapplication;

import android.app.Application;
import android.content.Context;

import com.rowsun.myapplication.model.News;

import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {


    public static Context context;
    public static List<News> sportsList;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sportsList = new ArrayList<>();
    }
}
