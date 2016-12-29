package com.personsl.fengchao.fragment;

import android.os.Bundle;

/**
 * Created by 冯超 on 2016/12/27.
 */
public class FireFragment extends BaseFragment {
    public static FireFragment newInstance(String param1) {
        FireFragment fragment = new FireFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {
        mTitle.setText("火火");
    }

}
