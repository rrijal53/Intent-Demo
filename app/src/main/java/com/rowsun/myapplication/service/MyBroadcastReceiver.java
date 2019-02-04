package com.rowsun.myapplication.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.rowsun.myapplication.MainApplication;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(MainApplication.context, "Your screen is on", Toast.LENGTH_LONG).show();
    }
}
