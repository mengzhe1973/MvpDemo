package com.kiros.mvpdemo.statusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.kiros.mvpdemo.R;

/**
 * Created by kiros on 2019/8/16.
 */

public class StatusBarTextColor2Activity extends CompatStatusBarActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_statusbar_text2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_next);
        int color = 0xffffffff;
        toolbar.setBackgroundColor(color);
        //此页面主要做的是当标题栏为白色的时候 适配状态栏透明的同时 修改添加View的颜色来的达到适配的目的
        setViewColorStatusBar(true, color);
    }
}
