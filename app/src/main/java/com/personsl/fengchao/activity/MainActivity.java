package com.personsl.fengchao.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.personsl.fengchao.Adapter.MyAdapter;
import com.personsl.fengchao.R;
import com.personsl.fengchao.fragment.EarthFragment;
import com.personsl.fengchao.fragment.FireFragment;
import com.personsl.fengchao.fragment.GoldFragment;
import com.personsl.fengchao.fragment.WaterFragment;
import com.personsl.fengchao.fragment.WoodFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

;

public class MainActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener, BottomNavigationBar.OnTabSelectedListener {
    @BindView(R.id.activity_main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.lv_left_menu)
    RecyclerView mRecyclerView;
    @BindView(R.id.dl_left)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mNavigationBar;
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.left_icon)
    TextView leftIcon;
    private ActionBarDrawerToggle mDrawerToggle;
    private GoldFragment mGoldFragment;
    private WoodFragment mWoodFragment;
    private WaterFragment mWaterFragment;
    private FireFragment mFireFragment;
    private EarthFragment mEarthFragment;
    private MenuItem mItemMenuSearch;
    private MenuItem mItemMenuSetting;
    private MenuItem mItemMenuRefresh;
    private MenuItem mItemMenuMy;
    private MenuItem mItemMenuAbout;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter mAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void initView() {
//      SetTranslanteBar();
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(this);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        mDrawerToggle.setHomeAsUpIndicator(R.mipmap.menu_user);
        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT, true);
                } else {
                    mDrawerLayout.openDrawer(Gravity.LEFT, true);
                }
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置菜单列表

        mNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);//设置选择动画和文字是否显示
        mNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);//设置点击是否有水波纹效果
        mNavigationBar.setInActiveColor(R.color.gray);//设置未被选中时的颜色
        mNavigationBar.setActiveColor(R.color.blue);
        //底部选择按钮
        mNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Gold"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Wood"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Water"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Fire"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Earth"))
                .initialise();
        mNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
        initLeftMenu();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mGoldFragment = GoldFragment.newInstance();
        transaction.replace(R.id.main_container, mGoldFragment);
        transaction.commit();
    }

    private void initLeftMenu() {
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //创建并设置Adapter
        mAdapter = new MyAdapter(getLeftData());
        mAdapter.setOnItemClickListener(new MyAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int data) {
                switch (data) {
                    case 0:
                        Intent intent = new Intent(mContext, PersonInfo.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<String> getLeftData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("我的钱包");
        list.add("我的消息");
        list.add("我的收藏");
        list.add("我的商城");
        list.add("会员中心");
        list.add("游戏中心");
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        mItemMenuSearch = menu.findItem(R.id.action_search);
        mItemMenuSetting = menu.findItem(R.id.action_setting);
        mItemMenuRefresh = menu.findItem(R.id.action_refresh);
        mItemMenuMy = menu.findItem(R.id.action_my);
        mItemMenuAbout = menu.findItem(R.id.action_about);
        mItemMenuSearch.setVisible(true);
        mItemMenuSetting.setVisible(false);
        mItemMenuRefresh.setVisible(false);
        mItemMenuMy.setVisible(false);
        mItemMenuAbout.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout.closeDrawer(Gravity.LEFT, true);
        } else {
            String msg = "";
            switch (item.getItemId()) {
                case R.id.action_search:
                    msg = "搜索";
                    break;
                case R.id.action_setting:
                    msg = "设置";
                    break;
                case R.id.action_refresh:
                    msg = "更新";
                    break;
                case R.id.action_about:
                    msg = "关于";
                    break;
                case R.id.action_my:
                    msg = "我的";
                    break;

            }
            if (!msg.equals("")) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }


    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mGoldFragment == null) {
                    mGoldFragment = mGoldFragment.newInstance();
                }
                mItemMenuSearch.setVisible(true);
                mItemMenuSetting.setVisible(false);
                mItemMenuRefresh.setVisible(false);
                mItemMenuMy.setVisible(false);
                mItemMenuAbout.setVisible(false);
                transaction.replace(R.id.main_container, mGoldFragment);
                break;
            case 1:
                mItemMenuSearch.setVisible(false);
                mItemMenuSetting.setVisible(true);
                mItemMenuRefresh.setVisible(false);
                mItemMenuMy.setVisible(false);
                mItemMenuAbout.setVisible(false);
                if (mWoodFragment == null) {
                    mWoodFragment = WoodFragment.newInstance();
                }
                transaction.replace(R.id.main_container, mWoodFragment);
                break;
            case 2:
                mItemMenuSearch.setVisible(false);
                mItemMenuSetting.setVisible(false);
                mItemMenuRefresh.setVisible(true);
                mItemMenuMy.setVisible(false);
                mItemMenuAbout.setVisible(false);
                if (mWaterFragment == null) {
                    mWaterFragment = WaterFragment.newInstance();
                }
                transaction.replace(R.id.main_container, mWaterFragment);
                break;
            case 3:
                mItemMenuSearch.setVisible(false);
                mItemMenuSetting.setVisible(false);
                mItemMenuRefresh.setVisible(false);
                mItemMenuMy.setVisible(true);
                mItemMenuAbout.setVisible(false);
                if (mFireFragment == null) {
                    mFireFragment = FireFragment.newInstance();
                }
                transaction.replace(R.id.main_container, mFireFragment);
                break;
            case 4:
                mItemMenuSearch.setVisible(false);
                mItemMenuSetting.setVisible(false);
                mItemMenuRefresh.setVisible(false);
                mItemMenuMy.setVisible(true);
                mItemMenuAbout.setVisible(true);
                if (mEarthFragment == null) {
                    mEarthFragment = EarthFragment.newInstance();
                }
                transaction.replace(R.id.main_container, mEarthFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @OnClick(R.id.left_icon)
    public void onClick() {
        Intent intent = new Intent(mContext, PersonInfo.class);
        startActivity(intent);
    }
}
