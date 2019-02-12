package com.rowsun.myapplication.views;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rowsun.myapplication.R;

public class GreenToast extends Toast {
    public GreenToast(Context context) {
        super(context);

    }

    public static Toast makeText(Context context, String title, int duration) {
        Toast t = new Toast(context);
        View v = LayoutInflater.from(context).inflate(R.layout.row_news, null);
        TextView tvTitle = v.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        t.setView(v);
        t.setDuration(duration);
        return t;
    }
}
