package com.personsl.fengchao.fragment;

import android.os.Bundle;
/**
 * Created by 冯超 on 2016/12/27.
 */
public class WoodFragment extends BaseFragment {
    public static WoodFragment newInstance(String param1) {
        WoodFragment fragment = new WoodFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public WoodFragment() {
    }

    @Override
    protected void initView() {
        mTitle.setText("木木");
    }
}
