package com.mkosto.itgoyo.mkfragment.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.mkosto.itgoyo.mkfragment.fragment.MeiNvFragment;
import com.mkosto.itgoyo.mkfragment.fragment.MeiTuFragment;
import com.mkosto.itgoyo.mkfragment.fragment.NewsFragment;
import com.mkosto.itgoyo.mkfragment.fragment.PagerFragment;
import com.mkosto.itgoyo.mkfragment.fragment.PopularFragment;

/**
 * Created by itgoyo on 16-11-26.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] pageTitle={"美女","美图","热点","新闻"};
    @Override
    public Fragment getItem(int position) {
    switch (position){
            case 0:
                return new MeiNvFragment();
            case 1:
                return new MeiTuFragment();
            case 2:
                return new PopularFragment();
            case 3:
                return new NewsFragment();

            default:
               return PagerFragment.newInstance(position + "");
        }
    }

    @Override
    public int getCount() {
        return pageTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }
}
