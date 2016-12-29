package com.personsl.fengchao.fragment;

import android.os.Bundle;
import android.view.View;

import com.personsl.fengchao.R;

/**
 * Created by 冯超 on 2016/12/27.
 */
public class WaterFragment extends BaseFragment {
    public static WaterFragment newInstance(String param1) {
        WaterFragment fragment = new WaterFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public WaterFragment() {
    }

    @Override
    protected void initView() {
        View.inflate(mContext, R.layout.fragment_water,null);
    }
}
