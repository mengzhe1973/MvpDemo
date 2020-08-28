package com.kiros.mvpdemo.ui.staff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.staff.OverdueMaintenanceAdapter;
import com.kiros.mvpdemo.adapter.staff.WillMaintenanceAdapter;
import com.kiros.mvpdemo.entity.staff.OverdueMaintenanItem;
import com.kiros.mvpdemo.entity.staff.WillMaintenanItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/7/17.
 */

public class OverdueMaintenanceActivity extends BaseActivity{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private OverdueMaintenanceAdapter maintenanceAdapter;
    private List<OverdueMaintenanItem> data = new ArrayList<OverdueMaintenanItem>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluatelist);
        setTitle("已过期");
        recyclerView = findViewById(R.id.ry_evaluate);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        maintenanceAdapter = new OverdueMaintenanceAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(maintenanceAdapter);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            OverdueMaintenanItem maintenanceItem = new OverdueMaintenanItem();
            maintenanceItem.setTime("2019年5月23");
            maintenanceItem.setAddress("维保地址");
            maintenanceItem.setSummary("情况概述");
            maintenanceItem.setMaintenanceTime("2019年5月23  16：00");
            maintenanceItem.setRemarks("用户备注");
            data.add(maintenanceItem);
        }
        maintenanceAdapter.notifyDataSetChanged();
    }
}
