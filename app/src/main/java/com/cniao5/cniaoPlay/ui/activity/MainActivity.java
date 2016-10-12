package com.cniao5.cniaoPlay.ui.activity;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;

import com.cniao5.cniaoPlay.R;
import com.cniao5.cniaoPlay.ui.adapter.TabViewPagerAdapter;
import com.cniao5.cniaoPlay.ui.base.BaseAppCompatActivity;
import com.cniao5.cniaoPlay.ui.fragment.AppFragment;
import com.cniao5.cniaoPlay.ui.fragment.DiscoverFragment;
import com.cniao5.cniaoPlay.ui.fragment.GameFragment;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends BaseAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private  Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }

    private void initToolbar() {
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {

            setSupportActionBar(toolbar);
        }
        toolbar.setNavigationIcon(R.mipmap.drawer_menu_icon);//设置导航栏图标
        toolbar.setTitle(getString(R.string.app_name));//设置主标题


    }


    private void initUI(){

        StatusBarUtil.setColor(this,getResources().getColor(R.color.colorPrimary));
        initToolbar();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initTabs();
    }

    private void initTabs(){


        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        TabViewPagerAdapter viewPagerAdapter = new TabViewPagerAdapter(getSupportFragmentManager());

        AppFragment appFragment = new AppFragment();
        GameFragment gameFragment = new GameFragment();
        DiscoverFragment discoverFragment = new DiscoverFragment();

        viewPagerAdapter.addFragment(appFragment, "应用");//添加Fragment
        viewPagerAdapter.addFragment(gameFragment, "游戏");
        viewPagerAdapter.addFragment(discoverFragment, "发现");
        mViewPager.setAdapter(viewPagerAdapter);//设置适配器


        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("应用"));//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("游戏"));
        mTabLayout.addTab(mTabLayout.newTab().setText("发现"));
        mTabLayout.setupWithViewPager(mViewPager);


    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
