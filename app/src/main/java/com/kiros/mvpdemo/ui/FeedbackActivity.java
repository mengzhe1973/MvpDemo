package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;

/**
 * Created by kiros on 2019/7/15.
 */

public class FeedbackActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_feedback);
        setTitle("意见反馈");
    }
}
