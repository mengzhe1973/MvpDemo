package com.kiros.mvpdemo.ui.staff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.staff.MaintenedAdapter;
import com.kiros.mvpdemo.entity.staff.MaintenanItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/7/17.
 */

public class MaintenedActivity extends BaseActivity{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MaintenedAdapter maintenedAdapter;
    private List<MaintenanItem> data = new ArrayList<MaintenanItem>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluatelist);
        setTitle("已维保");
        recyclerView = findViewById(R.id.ry_evaluate);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        maintenedAdapter = new MaintenedAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(maintenedAdapter);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            MaintenanItem maintenanItem = new MaintenanItem();
            maintenanItem.setTime("2019年5月23  16：00");
            maintenanItem.setAddress("维保地址");
            maintenanItem.setReason("故障原因");
            maintenanItem.setSituation("维保情况");
            data.add(maintenanItem);
        }
        maintenedAdapter.notifyDataSetChanged();
    }
}
