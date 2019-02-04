package com.rowsun.myapplication.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MyThread1 extends Thread {

    Handler handler;

    public MyThread1(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0 ; i < 10 ; i ++) {
            int finalI = i;
            try {
                Thread.sleep(3000);
                Message m = new Message();
                m.arg1 = i;
                Bundle b = new Bundle();
                b.putInt("progress", finalI);
                m.setData(b);
                handler.sendMessage(m);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
