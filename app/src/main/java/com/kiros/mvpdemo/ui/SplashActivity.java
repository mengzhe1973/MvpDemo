package com.kiros.mvpdemo.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.utils.SharedPreferencesHelper;
import com.kiros.mvpdemo.utils.VersionUtil;

/**
 * Created by kiros on 2019/7/19.
 */

public class SplashActivity extends AppCompatActivity {
    private SharedPreferencesHelper sharedPreferences;
    private TextView version;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏以及状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        sharedPreferences = new SharedPreferencesHelper(SplashActivity.this);
        version = findViewById(R.id.version);
        String versionStr = VersionUtil.getAppVersionName(this);
        if (!TextUtils.isEmpty(versionStr)) {
            version.setText("Version: " + versionStr);
        } else {
            version.setText("Version: 1.0.0");
        }
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                getHome();
            }
        }
    };

    public void getHome() {
        Intent intent = new Intent();
        boolean isFirst = (boolean) sharedPreferences.getSharedPreference("isFirst", true);
        if (isFirst) {
            intent.setClass(SplashActivity.this, GuideActivity.class);
            sharedPreferences.put("isFirst", false);
        } else {
            intent.setClass(SplashActivity.this, LoginRegisterActivity.class);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
        finish();
    }
}
