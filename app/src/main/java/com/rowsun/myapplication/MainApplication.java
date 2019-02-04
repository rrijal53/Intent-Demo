package com.rowsun.myapplication;

import android.app.Application;
import android.content.Context;

import com.rowsun.myapplication.model.News;
import com.rowsun.myapplication.ui.activity.ViewPagerExampleActivity;

import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {


    public static Context context;
    public static List<News> sportsList;
  public  ViewPagerExampleActivity.FragmentInteractLisntener object;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sportsList = new ArrayList<>();

    }
}
