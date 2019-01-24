package com.rowsun.myapplication.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rowsun.myapplication.model.News;
import com.rowsun.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = findViewById(R.id.list_view);
        // String[] arry = getResources().getStringArray(R.array.list);
        // int c =getResources().getColor(R.color.color_black);
//        String[] arry = {"Roshan", "ABC", "SDSDSDS"};
//        final String[] a2 = new String[5];
//        a2[0] = "sadsd";
//        a2[1] = "dsd";
//        a2[2] = "dsds";
//        a2[3] = "dsd";
//        a2[4] = "dsds";

        final List<News> list = new ArrayList();
        News n = new News("1", "News 1", "abcdddfdfd", R.mipmap.ic_launcher);
        list.add(n);
        list.add(new News("2", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        list.add(new News("", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        list.add(new News("2", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        list.add(new News("2", "News 2", "abcdsdsdsddddfdfd", R.mipmap.ic_launcher));
        NewsAdapter adapter = new NewsAdapter(this, list);
        listView.setAdapter(adapter);
        adapter.addNews(new News("","new news", "", R.mipmap.ic_launcher));
//        final ArrayAdapter<News> adapter = new ArrayAdapter<News>(this, R.layout.row_news, list) {
//            @NonNull
//            @Override
//            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//                convertView = LayoutInflater.from(ListViewActivity.this).inflate(R.layout.row_news, parent, false);
//                News n = getItem(position);
//                TextView tvTitle = convertView.findViewById(R.id.tv_title);
//                TextView tvDescription = convertView.findViewById(R.id.tv_desc);
//                ImageView imageView = convertView.findViewById(R.id.image);
//                tvTitle.setText(n.getTitle());
//                tvDescription.setText(n.getDescription());
//                imageView.setImageResource(n.getImage());
//                return convertView;
//            }
//
//            @Override
//            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                return super.getDropDownView(position, convertView, parent);
//            }
//        };

     //   adapter.notifyDataSetChanged();
      //  listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                // String selected = a2[i];
//                Toast.makeText(ListViewActivity.this, adapter.getItem(i).getTitle() + " selected", Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
