package com.personsl.fengchao.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.personsl.fengchao.R;
import butterknife.ButterKnife;

/**
 * Created by 冯超 on 2016/12/27.
 */
public abstract class BaseFragment extends Fragment {
    private View view;
    protected TextView mTitle;
    protected Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.base_fragment, container, false);
        mTitle = (TextView) getActivity().findViewById(R.id.title_tv);
        mContext = getActivity();
        initView();
        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract void initView();
}
