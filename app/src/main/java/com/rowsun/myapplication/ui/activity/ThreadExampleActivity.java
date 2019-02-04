package com.rowsun.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.service.TestServiceMain;

import java.util.Date;

public class ThreadExampleActivity extends AppCompatActivity {
    ProgressDialog pd;
    Handler handler;
    Button b2;
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int number = intent.getIntExtra("number", 0);
            b2.setText("Number " + number);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_example);
        pd = new ProgressDialog(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ThreadExampleActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();
            }
        }, 3000);

        findViewById(R.id.btn_click).setOnClickListener(view -> {
            pd.setMax(10);
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();
                    for (int i = 0; i < 10; i++) {
                        int finalI = i;
                        try {
                            Thread.sleep(3000);
                            Message m = new Message();
                            m.arg1 = i;
                            Bundle b = new Bundle();
                            b.putInt("progress", finalI);
                            m.setData(b);
                            handler.sendMessage(m);

//                          runOnUiThread(new Runnable() {
//                              @Override
//                              public void run() {
//
//                                 // Toast.makeText(ThreadExampleActivity.this, finalI + "",Toast.LENGTH_SHORT).show();
//                                pd.setProgress(finalI);
//                              }
//                          });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            };
            t.start();
        });
        IntentFilter iff = new IntentFilter();
        iff.addAction("BROADCAST");
        registerReceiver(receiver, iff);
        b2 = findViewById(R.id.btn_click_2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//
//                            }
//                        }).start();

//
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                startActivity(new Intent(ThreadExampleActivity.this, MainActivity.class));
//                            }
//                        }, 3000);

                //   startActivity(new Intent(ThreadExampleActivity.this, AsyncExampleActivity.class));
//
                //         startService(new Intent(ThreadExampleActivity.this, TestServiceMain.class));
//                        pd.setMax(10);
//                        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                        pd.show();
//
//                        MyThread1 t = new MyThread1(handler);
//                        t.start();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle b = msg.getData();
                pd.setProgress(b.getInt("progress"));
            }
        };

    }
}
