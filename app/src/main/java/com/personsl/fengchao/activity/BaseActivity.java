package com.personsl.fengchao.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.personsl.fengchao.R;
import com.personsl.fengchao.Utils.StatusBarUtil;

import butterknife.ButterKnife;

/**
 * Created by 冯超 on 2016/12/28.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(getLayoutId());
        mContext = this;
        ButterKnife.bind(this);
        initView();
    }

    protected abstract void initView();

    public abstract int getLayoutId();

    private void setStatusBar() {
        StatusBarUtil.setStatusBarColor(this, ContextCompat.getColor(this,R.color.blue));
    }
    protected void SetTranslanteBar(){
        StatusBarUtil.translucentStatusBar(this);
    }
}
