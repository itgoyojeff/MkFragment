package com.mkosto.itgoyo.mkfragment.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etsy.android.grid.StaggeredGridView;
import com.mkosto.itgoyo.mkfragment.R;
import com.mkosto.itgoyo.mkfragment.adapter.StaggerItemAdapter;
import com.mkosto.itgoyo.mkfragment.utils.ClumsyIndicator;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by itgoyo on 16-11-26.
 */

public class NewsFragment extends Fragment {

    ViewPager imagePager;


    ClumsyIndicator mClumsyIndicator;

    @InjectView(R.id.stagger_view)
    StaggeredGridView mStaggeredGridView;

    @InjectView(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private static Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meinv, container, false);
        ButterKnife.inject(this, view);


        initView();

        return view;
    }

    private void initView() {

        mStaggeredGridView.setAdapter(new StaggerItemAdapter(getActivity()));
        mSwipeRefreshLayout.setColorSchemeResources(R.color.blue);

    }
}
