package com.personsl.fengchao.fragment;
import android.os.Bundle;
/**
 * Created by 冯超 on 2016/12/27.
 */
public class GoldFragment extends BaseFragment {
    public static GoldFragment newInstance(String param1) {
        GoldFragment fragment = new GoldFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public GoldFragment() {
    }

    @Override
    protected void initView() {
        mTitle.setText("金金");
    }
}
