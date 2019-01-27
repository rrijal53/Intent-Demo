package com.rowsun.myapplication.ui.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rowsun.myapplication.R;

public class WebActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_activity);
        Uri i = getIntent().getData();
        Log.d("URI ", "onCreate: " + i.toString());
    }
}
