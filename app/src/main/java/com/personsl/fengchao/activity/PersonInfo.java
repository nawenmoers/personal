package com.personsl.fengchao.activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.personsl.fengchao.R;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 冯超 on 2016/12/28.
 */
public class PersonInfo extends BaseActivity {
    @BindView(R.id.title_tv)
    TextView mTitle;
    @BindView(R.id.activity_main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.title_back)
    ImageButton mBack;

    @Override
    public int getLayoutId() {
        return R.layout.person_info;
    }
    public void initView() {
        SetTranslanteBar();
        mToolbar.setTitle("");
        mTitle.setText("个人信息");
        mBack.setVisibility(View.VISIBLE);
        setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        finish();
    }
}
