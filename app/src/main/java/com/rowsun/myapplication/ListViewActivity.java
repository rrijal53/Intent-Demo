package com.rowsun.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    GridView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.list_view);
       // String[] arry = getResources().getStringArray(R.array.list);
       // int c =getResources().getColor(R.color.color_black);
        String[] arry = {"Roshan", "ABC", "SDSDSDS"};
        final String[] a2 = new String[5];
        a2[0] = "sadsd";
        a2[1] = "dsd";
        a2[2] = "dsds";
        a2[3] = "dsd";
        a2[4] = "dsds";

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.my_list_item,R.id.tv_item,a2 );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // String selected = a2[i];
                 Toast.makeText(ListViewActivity.this, adapter.getItem(i)+ " selected", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
