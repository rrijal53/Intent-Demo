package com.rowsun.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnGetResult;
    public static  final  int REQUEST_LOGIN = 111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetResult = findViewById(R.id.btn_get_result);
        btnGetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(i, 111);
            }
        });
        btnGetResult.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGetResult.setText("Resume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        btnGetResult.setText("Pause");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOGIN && resultCode == RESULT_OK){
            String result = data.getStringExtra("result");
            btnGetResult.setText(result + "");
        }
    }
}
