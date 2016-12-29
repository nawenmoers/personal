package com.personsl.fengchao.fragment;

import android.os.Bundle;

/**
 * Created by 冯超 on 2016/12/27.
 */
public class EarthFragment extends BaseFragment {
    public static EarthFragment newInstance(String param1) {
        EarthFragment fragment = new EarthFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public EarthFragment() {
    }

    @Override
    protected void initView() {
        mTitle.setText("土土");
    }

}
