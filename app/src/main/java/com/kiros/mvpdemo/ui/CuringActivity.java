package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.CuringAdapter;
import com.kiros.mvpdemo.api.HttpApi;
import com.kiros.mvpdemo.entity.CuringItem;
import com.kiros.mvpdemo.entity.CuringList;
import com.kiros.mvpdemo.entity.CuringList.*;
import com.kiros.mvpdemo.utils.OkHttpUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kiros on 2019/7/17.
 */

public class CuringActivity extends BaseActivity{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CuringAdapter curingAdapter;
    private List<CuringItem> data = new ArrayList<CuringItem>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluatelist);
        hideTitle();
        recyclerView = findViewById(R.id.ry_evaluate);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        curingAdapter = new CuringAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(curingAdapter);

        initData();
    }

    private void initData() {
        Map<Object, Object> map = new HashMap<>();
        new OkHttpUtils(CuringActivity.this).postMap(HttpApi.DEVICE_URL, map, new OkHttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(JSONObject obj) {
                CuringList curingList = new Gson().fromJson(obj.toString(), CuringList.class);
                if (curingList.getCode() == 1) {
                    List<DataBean> dataBeans = curingList.getData();
                    for (int i = 0; i < dataBeans.size(); i++) {
                        CuringItem curingItem = new CuringItem();
                        curingItem.setEqName(dataBeans.get(i).getName());
                        curingItem.setEqNum(dataBeans.get(i).getXh());
                        curingItem.setEqUsage("聚焦设备用途聚焦设备用途聚焦设备用途聚焦设备用途聚焦设备用途聚焦设备用途");
                        data.add(curingItem);
                    }
                    curingAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(CuringActivity.this, obj.optString("msg"), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
