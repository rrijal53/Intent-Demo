package com.rowsun.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rowsun.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button btnGetResult;
    public static final int REQUEST_LOGIN = 111;
    Toolbar toolbar;
    ProgressDialog progressDialog;

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

        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               progressDialog.show();
//                progressDialog.setProgress(50);
             //   showAlert();
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
            }
        });
        btnGetResult.setVisibility(View.VISIBLE);
        findViewById(R.id.btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(Intent.ACTION_DIAL);
//                i.setData( Uri.parse("tel:01222222"));
//                startActivity(i);
                progressDialog.dismiss();
//                Intent i = new Intent("com.rowsun.myapplication.ACTION_WEB_VIEW");
//                i.setData(Uri.parse("http://www.facebook.com"));
//                Uri uri = Uri.parse("http://www.facebook.com");
//                startActivity(Intent.createChooser(i, "Open with"));

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
        btnGetResult.setText("Resume");
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
