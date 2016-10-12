package com.cniao5.cniaoPlay.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cniao5.cniaoPlay.R;
import com.cniao5.cniaoPlay.common.AppApplication;
import com.cniao5.cniaoPlay.common.AppConstant;
import com.cniao5.cniaoPlay.ui.base.BaseAppCompatActivity;
import com.cniao5.cniaoPlay.ui.widget.ColorAnimationView;
import com.cniao5.cniaoPlay.ui.widget.PagerAdapter;
import com.cniao5.cniaoPlay.ui.widget.ViewPager;
import com.cniao5.cniaoPlay.utils.SharedPrenfenceUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcdull.
 */
public class GuideActivity extends BaseAppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mPager;
    private List<View> pagers = new ArrayList<>();
    private VerticalFragementPagerAdapter mAdapter;
    private ColorAnimationView colorAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_main);
        SharedPrenfenceUtil.putString(this, AppConstant.GUIDE_SHOW,
                AppApplication.getAppContext().getVersion());

        colorAnimationView = (ColorAnimationView) findViewById(R.id.ColorAnimationView);
        mPager = (ViewPager) findViewById(R.id.guide_pager);

        View view1 = LayoutInflater.from(this).inflate(
                R.layout.guide_layout, null);
        view1.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_01_point);
        View view2 = LayoutInflater.from(this).inflate(
                R.layout.guide_layout, null);
        view2.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_02_point);
        View view3 = LayoutInflater.from(this).inflate(
                R.layout.guide_layout, null);
        view3.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_03_point);
        View view4 = LayoutInflater.from(this).inflate(
                R.layout.guide_layout, null);
        view4.findViewById(R.id.guide_point).setBackgroundResource(R.mipmap.guide_04_point);

        pagers.add(view1);
        pagers.add(view2);
        pagers.add(view3);
        pagers.add(view4);

        mAdapter = new VerticalFragementPagerAdapter();
        mPager.setAdapter(mAdapter);
        mPager.setOnPageChangeListener(this);
        colorAnimationView.setmViewPager(mPager, 4, 0xff7edd61, 0xffff704a, 0xff5d7ac5, 0xff56c8f2);




    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    private class VerticalFragementPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(pagers.get(position));
            return pagers.get(position);

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

}
