package com.rowsun.myapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.model.User;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<User> list;

    private static final int VIEW_TYPE_USER = 1;
    private static final int VIEW_TYPE_ITEM = 2;

    public AdapterUser(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == VIEW_TYPE_USER) {
            View v = LayoutInflater.from(context).inflate(R.layout.row_user, viewGroup, false);
            return new ViewHolderUser(v);
        } else {
            View v = LayoutInflater.from(context).inflate(R.layout.item_header, viewGroup, false);
            return new ViewHolderHeader(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("", "onBindViewHolder: ");
        if (holder instanceof ViewHolderUser) {
            User u = list.get(position - 1);
            ViewHolderUser h = (ViewHolderUser) holder;
            h.tvName.setText((position + 1) + "" + u.getFullname());
            h.tvAdd.setText(u.getUserName());
            h.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

//            h.itemView.setMinimumHeight(position%2 == 0 ? 500 : 200);
        } else if (holder instanceof ViewHolderHeader) {
            // TODO: 2/10/19 Show header image
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_ITEM;
        } else {
            return VIEW_TYPE_USER;
        }

    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    class ViewHolderUser extends RecyclerView.ViewHolder {
        TextView tvName, tvAdd;
        ImageView image;

        public ViewHolderUser(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAdd = itemView.findViewById(R.id.tv_add);
            image = itemView.findViewById(R.id.image);
        }
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {
        ImageView iv;

        public ViewHolderHeader(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.image);
        }
    }


}
