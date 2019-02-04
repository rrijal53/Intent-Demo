package com.rowsun.myapplication.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rowsun.myapplication.MainApplication;
import com.rowsun.myapplication.R;
import com.rowsun.myapplication.callback.FragmentButtonClickListener;
import com.rowsun.myapplication.model.News;
import com.rowsun.myapplication.ui.activity.ViewPagerExampleActivity;

public class FragmentDemo extends Fragment {
    EditText etMessage;
    Button btnSubmit;
    ViewPagerExampleActivity.FragmentInteractLisntener listener;
    Bundle b ;
    String name;
    int age;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentButtonClickListener){
            listener= (ViewPagerExampleActivity.FragmentInteractLisntener) context;
        }
    }


//    public void setListener(ViewPagerExampleActivity.FragmentInteractLisntener listener) {
//        this.listener = listener;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
           b =  getArguments();
           name = b.getString("name");
           age = b.getInt("age");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_demo, container, false);
        etMessage = v.findViewById(R.id.et_message);
        btnSubmit = v.findViewById(R.id.btn_submit);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etMessage.setText("Name " + name + " age " + age);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.onDoSomething(etMessage.getText().toString());
                }
            }
        });
    }
}
