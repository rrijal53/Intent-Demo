package com.rowsun.myapplication.ui.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.ui.fragment.FragmentDemo;
import com.rowsun.myapplication.ui.fragment.NoTwoFragment;

public class ViewPagerExampleActivity extends AppCompatActivity  {

    ViewPager viewPager;
    TabLayout tabLayout;

  
    public interface FragmentInteractLisntener {
        void onDoSomething(String s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_example);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    static class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i) {
            FragmentDemo d = new FragmentDemo();
            NoTwoFragment f = new NoTwoFragment();

            Bundle b = new Bundle();
            b.putString("name", "A " + i);
            b.putInt("age", i);
            d.setArguments(b);
            if (i == 0) {
                return d;
            } else {
                return f;
            }

        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return position + "";
        }

        @Override
        public int getCount() {
            return 20;
        }
    }
}
