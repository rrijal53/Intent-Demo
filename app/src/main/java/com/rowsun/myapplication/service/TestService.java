package com.rowsun.myapplication.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.rowsun.myapplication.ui.activity.MainActivity;

public class TestService extends IntentService {
    public static final String ACTION_LOOP = "Loopppp";

    public TestService() {
        super("testt");
    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent.getAction().equals(ACTION_LOOP) ) {
            for (int i = 0; i < 10; i++) {
                Log.d("test", "onHandleIntent: " + i);
            }
        }
    }
}
