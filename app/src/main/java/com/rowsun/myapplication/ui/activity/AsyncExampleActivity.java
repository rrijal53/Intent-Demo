package com.rowsun.myapplication.ui.activity;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rowsun.myapplication.R;

public class AsyncExampleActivity extends AppCompatActivity implements AsyncTaskExample.OnSuccessListener {
    ProgressBar pbar;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_example);
        pbar = findViewById(R.id.pbar);
        result = findViewById(R.id.result);
        AsyncTaskExample a = new AsyncTaskExample();
        a.setListener(this);
        pbar.setVisibility(View.VISIBLE);
        a.execute();
    }

    @Override
    public void onSuccess(String s) {
        pbar.setVisibility(View.GONE);
        result.setText(result.getText() + "\n" + s);
    }
}
