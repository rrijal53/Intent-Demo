package com.rowsun.myapplication.callback;

import com.rowsun.myapplication.model.News;

public interface OnNewsUpdateListener {
    void onUpdate(int position);
    void onDelete(int position);
}
