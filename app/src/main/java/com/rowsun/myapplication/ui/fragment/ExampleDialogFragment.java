package com.rowsun.myapplication.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rowsun.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleDialogFragment extends BottomSheetDialogFragment {


    public ExampleDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_example_dialog, container, false);

        return v;
    }

}
