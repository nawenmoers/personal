package com.personsl.fengchao.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 冯超 on 2016/12/30.
 */
public class GoldListAdapter extends FragmentPagerAdapter{
    private ArrayList<String> mTitle;
    private ArrayList<Fragment> mFragment;

    public GoldListAdapter(FragmentManager fragmentManager, ArrayList<String> title, ArrayList<Fragment> fragment) {
        super(fragmentManager);
        mTitle = title;
        mFragment = fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    //配置标题的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
