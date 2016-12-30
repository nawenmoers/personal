package com.personsl.fengchao.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by 冯超 on 2016/12/27.
 */
public abstract class BaseFragment extends Fragment {
    private View view;
    protected Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(getLayoutId(),null);}
        mContext = getActivity();
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
