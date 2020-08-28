package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.fragment.HomeFragment;
import com.kiros.mvpdemo.fragment.MineFragment;
import com.kiros.mvpdemo.fragment.NoticeFragment;
import com.kiros.mvpdemo.widget.BottomBar;

/**
 * Created by kiros on 2019/7/14.
 */

public class HomeActivity extends BaseActivity {

    private BottomBar bottomBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_main);
        hideTitleView();
        initView();

    }

    private void initView() {
        bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#3f7fff")
                .addItem(HomeFragment.class,
                        "工作台",
                        R.mipmap.home_no,
                        R.mipmap.home)
                .addItem(NoticeFragment.class,
                        "系统通知",
                        R.mipmap.notice_no,
                        R.mipmap.notice)
                .addItem(MineFragment.class,
                        "我的",
                        R.mipmap.mine_no,
                        R.mipmap.mine)
                .build();
    }
}
