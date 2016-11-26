package com.mkosto.itgoyo.mkfragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.mkosto.itgoyo.mkfragment.adapter.FragmentAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.mkosto.itgoyo.mkfragment.R.id.action_add;
import static com.mkosto.itgoyo.mkfragment.R.id.action_search;
import static com.mkosto.itgoyo.mkfragment.R.id.action_settings;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.indicator)
    PagerSlidingTabStrip mIndicator;
    @InjectView(R.id.pager)
    ViewPager mViewPager;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        FragmentAdapter mAdapter = new FragmentAdapter(getFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       switch(item.getItemId()) {
           case action_search:
               Log.i("Test","搜索");
               Toast.makeText(MainActivity.this,"搜索按钮被点击",Toast.LENGTH_SHORT).show();
           break;
           case action_add:
               Toast.makeText(MainActivity.this,"发布按钮被点击",Toast.LENGTH_SHORT).show();
           break;
           case action_settings:
               Toast.makeText(MainActivity.this,"设置按钮被点击",Toast.LENGTH_SHORT).show();
           break;


       }
        return true;

    }
}
