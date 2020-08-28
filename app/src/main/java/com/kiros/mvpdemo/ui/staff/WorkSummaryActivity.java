package com.kiros.mvpdemo.ui.staff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;

/**
 * Created by kiros on 2019/7/15.
 */

public class WorkSummaryActivity extends BaseActivity{

    private TextView time;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_work_summary);
        setTitle("工作总结");
        time = findViewById(R.id.time);
        time.setText("时间: 2019年9月8日");
    }
}
