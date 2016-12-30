package com.personsl.fengchao.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.personsl.fengchao.Adapter.GoldListAdapter;
import com.personsl.fengchao.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by 冯超 on 2016/12/27.
 */
public class GoldFragment extends Fragment{
    @BindView(R.id.fg_gold_tl)
    TabLayout mTabLayout;
    @BindView(R.id.fg_gold_vp)
    ViewPager mViewPager;
    private ArrayList<String> mTapTitle;
    private ArrayList<Fragment> mFragment;

    public static GoldFragment newInstance() {
        GoldFragment fragment = new GoldFragment();
        return fragment;
    }

    public GoldFragment() {
    }

    protected void initView() {
        mTapTitle = new ArrayList<>();
        mTapTitle.add("东");
        mTapTitle.add("南");
        mTapTitle.add("西");
        mTapTitle.add("北");
        mFragment = new ArrayList<>();
        mFragment.add(new EastFragment());
        mFragment.add(new SouthFragment());
        mFragment.add(new WestFragment());
        mFragment.add(new NorthFragment());
        GoldListAdapter adapter = new GoldListAdapter(getChildFragmentManager(), mTapTitle, mFragment);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        //使用ViewPager的适配器
        mTabLayout.setTabsFromPagerAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.fragment_gold,null);
        ButterKnife.bind(this,rootView);
        initView();
        return rootView;
    }
}
