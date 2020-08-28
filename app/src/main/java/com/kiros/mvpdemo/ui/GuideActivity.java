package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.ViewPagerAdapter;
import com.kiros.mvpdemo.fragment.Fragment1;
import com.kiros.mvpdemo.fragment.Fragment2;
import com.kiros.mvpdemo.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/8/21.
 */

public class GuideActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将屏幕设置为全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        initView();
    }


    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), showView()));
    }

    private List<Fragment> showView() {
        List<Fragment> listView = new ArrayList<Fragment>();
        listView.add(new Fragment1());
        listView.add(new Fragment2());
        listView.add(new Fragment3());
        return listView;
    }
}
