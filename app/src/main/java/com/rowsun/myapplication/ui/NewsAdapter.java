package com.rowsun.myapplication.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.model.News;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    List<News> list;
    Context context;

    public NewsAdapter(Context context, List<News> list) {
        this.list = list;
        this.context = context;
    }

    public void addNews(News n){
        list.add(n);
        notifyDataSetChanged();
    }

    public void removeNews(int position){
        list.remove(position);
        notifyDataSetChanged();
    }
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row_news, viewGroup, false);
        News n = (News) getItem(i);
        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvDescription = convertView.findViewById(R.id.tv_desc);
        ImageView imageView = convertView.findViewById(R.id.image);
        tvTitle.setText(n.getTitle());
        tvDescription.setText(n.getDescription());
        imageView.setImageResource(n.getImage());
        return convertView;
    }

}