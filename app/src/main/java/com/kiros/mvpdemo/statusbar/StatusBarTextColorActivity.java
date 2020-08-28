package com.kiros.mvpdemo.statusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.kiros.mvpdemo.R;

/**
 * Created by kiros on 2019/8/16.
 */

public class StatusBarTextColorActivity extends StatusBarBaseActivity {
    private boolean isChange;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusbar_text);
        //此页面主要做的是当标题栏为白色的时候 适配状态栏透明的同时 修改状态栏的字体颜色
        //因修改状态栏字体颜色只支持6.0以上系统，适配低版本的时候，我们修改状态栏颜色为浅灰色(大部分APP适配规则)
        int statusBarColor = 0xffcccccc;
        setColorStatusBar(true, statusBarColor);

        //测试加载完成以后再次修改状态栏字体颜色
        Button testButton = (Button) findViewById(R.id.btn_statusbar_text_test);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isChange) {
                    isChange = true;
                    setColorStatusBar(false, 0);
                } else {
                    int statusBarColor = 0xffcccccc;
                    setColorStatusBar(true, statusBarColor);
                    isChange = false;
                }
            }
        });
    }
}
