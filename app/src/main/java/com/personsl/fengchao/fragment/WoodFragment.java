package com.personsl.fengchao.fragment;
import com.personsl.fengchao.R;
/**
 * Created by 冯超 on 2016/12/27.
 */
public class WoodFragment extends BaseFragment {
    public static WoodFragment newInstance() {
        WoodFragment fragment = new WoodFragment();
        return fragment;
    }

    public WoodFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wood;
    }

    @Override
    protected void initView(){
    }
}
