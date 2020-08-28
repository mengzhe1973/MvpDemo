package com.kiros.mvpdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;

/**
 * Created by kiros on 2019/7/14.
 */

public class LoginActivity extends BaseActivity{

    private TextView next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_login);
        hideTitleView();
        next = findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CodeActivity.class));
                finish();
            }
        });
    }
}
