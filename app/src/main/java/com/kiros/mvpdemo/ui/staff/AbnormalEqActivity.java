package com.kiros.mvpdemo.ui.staff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.staff.AbnormalEqAdapter;
import com.kiros.mvpdemo.adapter.staff.MaintenanceAdapter;
import com.kiros.mvpdemo.adapter.staff.MaintenedAdapter;
import com.kiros.mvpdemo.entity.staff.AbnormalEqItem;
import com.kiros.mvpdemo.entity.staff.MaintenanItem;
import com.kiros.mvpdemo.entity.staff.MaintenanceItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/7/17.
 */

public class AbnormalEqActivity extends BaseActivity{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AbnormalEqAdapter abnormalEqAdapter;
    private List<AbnormalEqItem> data = new ArrayList<AbnormalEqItem>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluatelist);
        setTitle("异常设备");
        recyclerView = findViewById(R.id.ry_evaluate);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        abnormalEqAdapter = new AbnormalEqAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(abnormalEqAdapter);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            AbnormalEqItem maintenanceItem = new AbnormalEqItem();
            maintenanceItem.setItemTime("2019年5月23  16：00");
            maintenanceItem.setEqName("聚焦油烟机");
            maintenanceItem.setEqNum("JKHH002246");
            maintenanceItem.setEqAbnormal("聚焦油烟机聚焦油烟机聚焦油烟机聚焦油烟机聚焦油烟机聚焦油烟机聚焦油烟机聚焦油烟机");
            maintenanceItem.setHappenTime("2019年5月23  16：00");
            maintenanceItem.setEqAddress("郑州市上街区雅兴江南小区2号楼23楼2308");
            data.add(maintenanceItem);
        }
        abnormalEqAdapter.notifyDataSetChanged();
    }
}
