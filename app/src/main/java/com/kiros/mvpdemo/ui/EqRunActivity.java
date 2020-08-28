package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.CuringAdapter;
import com.kiros.mvpdemo.adapter.EqRunAdapter;
import com.kiros.mvpdemo.entity.CuringItem;
import com.kiros.mvpdemo.entity.EqRunItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/7/17.
 */

public class EqRunActivity extends BaseActivity{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private EqRunAdapter eqRunAdapter;
    private List<EqRunItem> data = new ArrayList<EqRunItem>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluatelist);
        hideTitle();
        recyclerView = findViewById(R.id.ry_evaluate);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        eqRunAdapter = new EqRunAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(eqRunAdapter);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            EqRunItem eqRunItem = new EqRunItem();
            eqRunItem.setEqName("聚焦设备");
            eqRunItem.setEqNum("JJHVDG234566666");
            eqRunItem.setEqUsage("聚焦设备用途聚焦设备用途聚焦设备用途聚焦设备用途聚焦设备用途聚焦设备用途");
            eqRunItem.setRunTime("14h");
            eqRunItem.setDefender("张大宝");
            eqRunItem.setRunSpeed("2536转/s");
            eqRunItem.setEqAddress("洛阳");
            eqRunItem.setEqTemperature("230°");
            eqRunItem.setUtilizationRate("80%");
            eqRunItem.setRepairNum("2次");
            data.add(eqRunItem);
        }
        eqRunAdapter.notifyDataSetChanged();
    }
}
