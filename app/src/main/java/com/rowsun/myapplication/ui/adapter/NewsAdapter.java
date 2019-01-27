package com.rowsun.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rowsun.myapplication.MainApplication;
import com.rowsun.myapplication.R;
import com.rowsun.myapplication.callback.OnNewsUpdateListener;
import com.rowsun.myapplication.model.News;

import java.util.LinkedList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {
    List<News> list;
    Context context;
    OnNewsUpdateListener listener;

    public NewsAdapter(Context context, List<News> list) {
        this.list = list;
        this.context = context;
    }

    public void setOnUpdateListener(OnNewsUpdateListener listener) {
        this.listener = listener;
    }

    public void addNews(News n){
        list.add(n);
        notifyDataSetChanged();
    }

//    public void removeNews(int position){
//        list.remove(position);
//        notifyDataSetChanged();
//    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row_news, viewGroup, false);
      final   News n = (News) getItem(i);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvDescription = convertView.findViewById(R.id.tv_desc);
        ImageView imageView = convertView.findViewById(R.id.image);
        tvTitle.setText(n.getTitle());
        tvDescription.setText(n.getDescription());
        imageView.setImageResource(n.getImage());
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, n.getTitle(), Toast.LENGTH_SHORT).show();
                list.remove(i);
                notifyDataSetChanged();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onUpdate(i);
                }
            }
        });

        return convertView;
    }

}