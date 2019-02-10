package com.rowsun.myapplication.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rowsun.myapplication.R;

public class AsyncExampleActivity extends AppCompatActivity implements AsyncTaskExample.OnSuccessListener {
    ProgressBar pbar;
    TextView result;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_example);
        pbar = findViewById(R.id.pbar);
        result = findViewById(R.id.result);
        AsyncTaskExample a = new AsyncTaskExample();
        a.setListener(this);
        EditText etInput = findViewById(R.id.et_input);

        pbar.setVisibility(View.VISIBLE);
     //   a.execute("test");
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s =etInput.getText().toString();
                int i = Integer.parseInt(s);
                new PrimeAsync(h).execute(i,2,4,4,8);
            }
        });
        
    }

    @Override
    public void onSuccess(String s) {
        pbar.setVisibility(View.GONE);
        result.setText(result.getText() + "\n" + s);
    }

    @Override
    protected void onResume() {
        super.onResume();
        h = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle b = msg.getData();
                String type = b.getString("type");
                int value = b.getInt("value");
                result.setText(type +" " + value);

            }
        };
    }
}
