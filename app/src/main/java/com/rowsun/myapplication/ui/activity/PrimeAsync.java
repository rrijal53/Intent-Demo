package com.rowsun.myapplication.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;

public class PrimeAsync extends AsyncTask<Integer, String, List<Integer>> {

    Handler h;

    public PrimeAsync(Handler h) {
        this.h = h;
    }

    @Override
    protected List<Integer> doInBackground(Integer... integers) {
        int i1 = integers[0];
        int i2 = integers[1];
        int i3 = integers[2];
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                sendMessage("even", i);
            } else {
                sendMessage("odd", i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private void sendMessage(String odd, int i) {
        Message m = new Message();
        Bundle b = new Bundle();
        b.putString("type", odd);
        b.putInt("value", i);
        m.setData(b);
        h.sendMessage(m);
    }

    @Override
    protected void onPostExecute(List<Integer> integers) {
        super.onPostExecute(integers);

    }
}
