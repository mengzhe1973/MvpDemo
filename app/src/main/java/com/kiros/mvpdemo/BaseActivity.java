package com.kiros.mvpdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kiros.mvpdemo.utils.ActivityUtil;
import com.kiros.mvpdemo.utils.StatusBarUtil;
import com.kiros.mvpdemo.utils.StatusBarUtil1;

/**
 * Created by kiros on 2019/7/14.
 */

public class BaseActivity extends AppCompatActivity {

    private View titleView;
    private ImageView back;
    private TextView tv_title;
    private EditText search;
    private FrameLayout ly_content;
    // 内容区域的布局
    private View contentView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ActivityUtil.getInstance().addActivity(this);
        StatusBarUtil1.transparencyBar(this); //设置状态栏全透明
        StatusBarUtil1.StatusBarLightMode(this); //设置白底黑字
        initView();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        titleView = findViewById(R.id.top_title);
        back = findViewById(R.id.back);
        tv_title = findViewById(R.id.title);
        search = findViewById(R.id.search);
        ly_content = findViewById(R.id.content);
    }

    /***
     * 设置内容区域
     *
     * @param resId
     * 资源文件ID
     */
    public void setContentLayout(int resId) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(resId, null);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT);
        contentView.setLayoutParams(layoutParams);
        contentView.setBackgroundDrawable(null);
        if (null != ly_content) {
            ly_content.addView(contentView);
        }

    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {

        if (null != tv_title) {
            tv_title.setVisibility(View.VISIBLE);
            search.setVisibility(View.GONE);
            tv_title.setText(title);
        }

    }

    /**
     * 隐藏上方的标题栏
     */
    public void hideTitleView() {

        if (null != titleView) {
            titleView.setVisibility(View.GONE);
        }
    }

    /**
     * 隐藏上方的标题栏
     */
    public void hideLeftIcon() {

        if (null != back) {
            back.setVisibility(View.GONE);
        }
    }

    /**
     * 显示搜索框
     */
    public void hideTitle() {

        if (null != search) {
            search.setVisibility(View.VISIBLE);
            tv_title.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        ActivityUtil.getInstance().removeActivity(this);
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 点击手机上的返回键，返回上一层
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
