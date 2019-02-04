package com.rowsun.myapplication.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rowsun.myapplication.MainApplication;
import com.rowsun.myapplication.R;
import com.rowsun.myapplication.ui.activity.ViewPagerExampleActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoTwoFragment extends Fragment {


    public NoTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_no_two, container, false);
    }


}
