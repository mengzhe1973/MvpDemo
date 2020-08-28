package com.kiros.mvpdemo.ui.staff;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.FragmentAdapter;

/**
 * Created by kiros on 2019/7/17.
 */

public class MaintenanceActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private FragmentAdapter mFragmentAdapter = null;
    private int tabWidth;
    private DisplayMetrics mDisplayMetrics = new DisplayMetrics();
    //图片选择条
    private ImageView mivBottom_line;
    private TextView tab1;
    private TextView tab2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_maintenance);
        setTitle("维保记录");
        mViewPager = findViewById(R.id.viewpager);
        mivBottom_line = findViewById(R.id.img_tabLine);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab1.setTextSize(18);
        //图片选择条
        initLine();
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(this);
    }


    private void initLine() {
        getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        tabWidth = mDisplayMetrics.widthPixels / 2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.line);
        // 设置图片选择条的宽高
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, tabWidth, 8);
        mivBottom_line.setImageBitmap(bitmap1);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // Matrix创建一个矩形
        Matrix matrix = new Matrix();
        switch (position) {
            case 0:
                // 使用setTranslate直接位置
                matrix.setTranslate(0, 0);
                break;
            case 1:
                matrix.setTranslate(tabWidth, 0);
                break;
        }
        // 在滑动的过程中，计算出图片选择条的动态滑动距离
        //这里用了"后乘"positionOffset[0,1)
        float miters = (tabWidth) * positionOffset;
        // 使用postTranslate动态追加滑动距离
        matrix.postTranslate(miters, 0);
        mivBottom_line.setImageMatrix(matrix);
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0: {
                tab1.setTextSize(18);
                tab2.setTextSize(16);
                tab1.setTextColor(getResources().getColor(R.color.color_333333));
                tab2.setTextColor(getResources().getColor(R.color.color_666666));
                mViewPager.setCurrentItem(0);
            }
            break;
            case 1: {
                tab1.setTextSize(16);
                tab2.setTextSize(18);
                tab1.setTextColor(getResources().getColor(R.color.color_666666));
                tab2.setTextColor(getResources().getColor(R.color.color_333333));
                mViewPager.setCurrentItem(1);
            }
            break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab1: {
                tab1.setTextSize(18);
                tab2.setTextSize(16);
                tab1.setTextColor(getResources().getColor(R.color.color_333333));
                tab2.setTextColor(getResources().getColor(R.color.color_666666));
                mViewPager.setCurrentItem(0);
            }
            break;
            case R.id.tab2: {
                tab1.setTextSize(16);
                tab2.setTextSize(18);
                tab1.setTextColor(getResources().getColor(R.color.color_666666));
                tab2.setTextColor(getResources().getColor(R.color.color_333333));
                mViewPager.setCurrentItem(1);
            }
            break;
            default:
                break;
        }
    }
}
