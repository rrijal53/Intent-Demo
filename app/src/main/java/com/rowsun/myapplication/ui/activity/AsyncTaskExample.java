package com.rowsun.myapplication.ui.activity;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class AsyncTaskExample extends AsyncTask<String, Integer, List<String>> {

    List<String> nameList;
    OnSuccessListener listener;

    public void setListener(OnSuccessListener listener) {
        this.listener = listener;
    }

    interface OnSuccessListener {
        void onSuccess(String s);
    }

    public AsyncTaskExample() {
        nameList = new ArrayList<>();
        nameList.add("Rosjam");
        nameList.add("Rijal");
        nameList.add("asdsds");
        nameList.add("Rosdsdsjam");
        nameList.add("asasdsds");

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected List<String> doInBackground(String... str) {
        List<String> list = new ArrayList<>();
        //  Log.d("", "doInBackground: " + str[0]);
        for (String s : nameList) {
            if (s.startsWith("R")) {
                list.add(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        for (String s : strings
        ) {
            if (listener != null) {
                listener.onSuccess(s);
            }
            // Log.d("Tag", s);
        }
    }


}
