package com.rowsun.myapplication.ui.activity;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.rowsun.myapplication.MainApplication;
import com.rowsun.myapplication.callback.OnNewsUpdateListener;
import com.rowsun.myapplication.model.News;
import com.rowsun.myapplication.R;
import com.rowsun.myapplication.ui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    NewsAdapter adapter;
     List<News> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.list_view);
         list = new ArrayList();
        News n = new News("1", "News 1", "abcdddfdfd", R.mipmap.ic_launcher);
        list.add(n);
        list.add(new News("2", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        list.add(new News("", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        list.add(new News("2", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        list.add(new News("2", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        adapter = new NewsAdapter(this, list);
        listView.setAdapter(adapter);
        adapter.addNews(new News("", "new news", "", R.mipmap.ic_launcher));
        adapter.setOnUpdateListener(new OnNewsUpdateListener() {
            @Override
            public void onUpdate(int position) {

                Toast.makeText(ListViewActivity.this, "Update : " + list.get(position).getTitle(), Toast.LENGTH_LONG).show();
                // TODO: 1/25/19 Show alert
                News n = list.get(position);
                EditText e = new EditText(MainApplication.context);
                e.setText(n.getTitle());
                list.remove(position);
                list.add(position, new News("", ":", "", 1111));
            }

            @Override
            public void onDelete(int position) {

            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        findViewById(R.id.button).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                showAlert();

                return false;
            }
        });

        EditText e = findViewById(R.id.et_input);
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(
                        "RRR", "onTextChanged: " + charSequence);
                listView.setAdapter(new NewsAdapter(ListViewActivity.this, filterList(charSequence.toString())));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public List<News> filterList(String s){
        List<News> filteredList = new ArrayList<>();

//        for (int i = 0 ;i < list.size() ;i ++){
//            News n = list.get(i);
//
//        }

//        HashMap<String, List<News>> map = new HashMap<>();
//        map.put("International", list);
//        map.put("Sports",filteredList);
//
//
        for (News n : list) {
            String title = n.getTitle();
            String desc = n.getDescription();
            if (title.contains(s) || desc.contains(s) ){
                filteredList.add(n);
            }
        }
        return filteredList;
    }
    private void showAlert() {
        String[] choices = {"Open", "Copy", "Paste", "exit"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, choices);
        new AlertDialog.Builder(this).setMultiChoiceItems(choices, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        }).show();
//
//        new AlertDialog.Builder(this)
//                .setTitle("List")
//                .setAdapter(adapter1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        switch (i) {
//                            case 0:
//                                Toast.makeText(ListViewActivity.this, "Open", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 1:
//                                Toast.makeText(ListViewActivity.this, "Copy", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 2:
//                                Toast.makeText(ListViewActivity.this, "Paste", Toast.LENGTH_SHORT).show();
//                                break;
//                            case 3:
//                                finish();
//                                break;
//                        }
//                    }
//                })
////                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
////                    }
////                })
////                .setNegativeButton("No", null)
//                .show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
