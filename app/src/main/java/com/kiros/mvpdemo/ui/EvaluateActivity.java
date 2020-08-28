package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.api.HttpApi;
import com.kiros.mvpdemo.utils.OkHttpUtils;
import com.kiros.mvpdemo.utils.SharedPreferencesHelper;
import com.kiros.mvpdemo.widget.StarBar;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiros on 2019/7/16.
 */

public class EvaluateActivity extends BaseActivity{
    private StarBar service_starBar, technology_starBar;
    private TextView submit;
    private EditText content;
    private String manner, technology;
    private SharedPreferencesHelper sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluate);
        setTitle("维保人员评价");
        sp = new SharedPreferencesHelper(this);
        initView();

        service_starBar.setOnStarChangeListener(new StarBar.OnStarChangeListener() {
            @Override
            public void onStarChange(float mark) {
                showToast(mark + "");
                manner = String.valueOf(mark);
            }
        });

        technology_starBar.setOnStarChangeListener(new StarBar.OnStarChangeListener() {
            @Override
            public void onStarChange(float mark) {
                showToast(mark + "");
                technology = String.valueOf(mark);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    private void initView() {
        service_starBar = findViewById(R.id.service_starBar);
        technology_starBar = findViewById(R.id.technology_starBar);
        submit = findViewById(R.id.submit);
        content = findViewById(R.id.edit_text);
    }

    private void submit() {
        Map<Object, Object> map = new HashMap<>();
        map.put("content", content.getText().toString().trim());
        map.put("manner", manner);
        map.put("technology", technology);
        map.put("access_uid", sp.getSharedPreference("user_id", -1));
        new OkHttpUtils(this).postMap(HttpApi.ACCESS_URL, map, new OkHttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(JSONObject obj) {
                if (obj.optInt("code") == 1) {
                    finish();
                    showToast("评价成功");
                } else {
                    showToast(obj.optString("msg"));
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

}
