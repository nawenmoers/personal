package com.personsl.fengchao.fragment;
import com.personsl.fengchao.R;

/**
 * Created by 冯超 on 2016/12/27.
 */
public class WaterFragment extends BaseFragment {

    public WaterFragment() {}

    public static WaterFragment newInstance() {
        WaterFragment fragment = new WaterFragment();
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_water;
    }

    @Override
    protected void initView() {
    }
}
