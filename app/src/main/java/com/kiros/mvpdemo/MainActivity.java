package com.kiros.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.kiros.mvpdemo.base.BaseMvpActivity;
import com.kiros.mvpdemo.base.BaseView;
import com.kiros.mvpdemo.weather.WeatherPresenter;

public class MainActivity extends BaseMvpActivity<BaseView, WeatherPresenter> implements BaseView {
    private TextView textView;
    @Override
    protected int getLayoutID() {
        return R.layout.activity_mvp;
    }

    @Override
    protected WeatherPresenter createPresenter() {
        return new WeatherPresenter();
    }

    @Override
    protected BaseView createView() {
        return this;
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.text);
        getPresenter().getWeather("v6", "101180101", "郑州");
    }

    @Override
    public void showLoading() {
        Toast.makeText(MainActivity.this, "加载中......", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hindLoading() {
        Toast.makeText(MainActivity.this, "加载完", Toast.LENGTH_LONG).show();
    }

    @Override
    public void getData(String data) {
        if (data != null) {
            textView.setText(data);
            Log.d("data==>", data);
        }
    }

    @Override
    public void showError(String error) {
        if (error != null) {
            textView.setText(error);
        }
    }
}
