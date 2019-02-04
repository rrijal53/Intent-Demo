package com.rowsun.myapplication.ui.activity;

import android.app.IntentService;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.service.MyBroadcastReceiver;
import com.rowsun.myapplication.service.TestService;
import com.rowsun.myapplication.service.TestServiceMain;

import static com.rowsun.myapplication.service.TestService.ACTION_LOOP;

public class MainActivity extends AppCompatActivity {
    Button btnGetResult;
    public static final int REQUEST_LOGIN = 111;
    Toolbar toolbar;
    ProgressDialog progressDialog;
    Handler handler;
    public static final String ACTION_GET_PROGRESS = "ACTIONDSFDSFFDFDF";

    class Bro extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            btnGetResult.setText(intent.getStringExtra("hello"));
        }
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("test", "onReceive: " + intent.getStringExtra("progress"));
                btnGetResult.setText(intent.getStringExtra("progress"));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        btnGetResult = findViewById(R.id.btn_get_result);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait.......");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
//        IntentFilter i = new IntentFilter();
//        i.addAction("BRO");
//        registerReceiver(new Bro(), i);

        IntentFilter i = new IntentFilter();
        i.addAction(ACTION_GET_PROGRESS);
        registerReceiver(receiver, i);
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread() {

                    @Override
                    public void run() {
                        super.run();
//                        try {
//                            for (int i = 0; i < 100; i++) {
//                                Message m = new Message();
//                                Bundle b = new Bundle();
//                                b.putString("name", i + "");
//                                m.setData(b);
//                                handler.sendMessage(m);
//                                Thread.sleep(1000);
//                            }
////                            Intent i = new Intent("BRO");
////                            i.putExtra("hello", "eweewewewewew");
////                            sendBroadcast(i);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }

                        startService(new Intent(MainActivity.this, TestServiceMain.class));

                    }
                }.start();


            }
        });
        btnGetResult.setVisibility(View.VISIBLE);
        findViewById(R.id.btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.dismiss();

            }
        });
    }


    private void showAlert() {

        final View v = getLayoutInflater().inflate(R.layout.activity_login, null);


        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setTitle("Hellow")
                .setView(v)
                .setIcon(R.drawable.androida)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Cancel", null)
                .setNeutralButton("Do nothing", null);
        AlertDialog dialog1 = dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                btnGetResult.setText(msg.getData().getString("name"));
            }
        };


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        btnGetResult.setText("Pause");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOGIN && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            btnGetResult.setText(result + "");
        }
    }
}
