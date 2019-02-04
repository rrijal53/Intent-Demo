package com.rowsun.myapplication.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;

import com.rowsun.myapplication.MainApplication;
import com.rowsun.myapplication.R;
import com.rowsun.myapplication.ui.activity.MainActivity;

import static com.rowsun.myapplication.ui.activity.MainActivity.ACTION_GET_PROGRESS;

public class TestServiceMain extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            sendNotification();
//        }
//
//        for (int i = 0 ; i < 10 ; i ++){
//            Intent in= new Intent(ACTION_GET_PROGRESS);
//            in.putExtra("progress", i + "");
//            sendBroadcast(in);
//
//          //  LocalBroadcastManager.getInstance(this).sendBroadcast()
//        }
//        Intent i = new Intent(this, MyBroadcastReceiver.class);
//        sendBroadcast(i);


        Thread ti = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
      Thread t =   new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    for (int i = 0 ; i < 10 ; i ++){
                        Intent in = new Intent("BROADCAST");
                        in.putExtra("number", i);
                        sendBroadcast(in);
                        Thread.sleep(1000);
//                        LocalBroadcastManager.getInstance(MainApplication.context).sendBroadcast(in);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

      t.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void sendNotification() {
        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder a = new NotificationCompat.Builder(this, "11");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel notificationChannel = new NotificationChannel("11", "myapp", importance);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        a.setContentTitle("test")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pi)
                .setContentText("Dsdsd")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("DSDSDS"))

                .addAction(R.mipmap.ic_launcher, "YES", null);


        startForeground((int) (Math.random() * 1000), a.build());
        // notificationManager.notify(1, a.build());

    }
}
