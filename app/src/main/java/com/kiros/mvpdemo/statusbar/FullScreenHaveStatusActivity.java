package com.kiros.mvpdemo.statusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kiros.mvpdemo.R;

/**
 * Created by kiros on 2019/8/16.
 */

public class FullScreenHaveStatusActivity extends StatusBarBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_havastatus);
        //配置在theme里面
    }
}
