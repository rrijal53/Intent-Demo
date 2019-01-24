package com.rowsun.myapplication.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.rowsun.myapplication.R;

public class BrowserActivity extends AppCompatActivity {
    TextView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        webView = findViewById(R.id.webview);
        Uri uri = getIntent().getData();
        webView.setText(uri.toString());
       // webView.getSettings().setJavaScriptEnabled(true);
    }
}
