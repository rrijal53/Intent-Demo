package com.rowsun.myapplication.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.callback.FragmentButtonClickListener;
import com.rowsun.myapplication.ui.fragment.FragmentDemo;
import com.rowsun.myapplication.ui.fragment.NoTwoFragment;

public class FragmentDemoActivity extends AppCompatActivity implements FragmentButtonClickListener {

    Button btn;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
            FragmentDemo f = new FragmentDemo();
            Bundle b = new Bundle();
            b.putString("name", "SABFDFDFDF");
            b.putInt("age",22);
            f.setArguments(b);
            loadFragment(f);
        //loadFragment(new NoTwoFragment());
        // loadFragment(new FragmentDemo());
    }

    private void loadFragment(Fragment f) {
      FragmentTransaction t =  getSupportFragmentManager().beginTransaction();
      t.replace(R.id.content, f);
      t.commit();
     }

    @Override
    public void onClick(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }
}
