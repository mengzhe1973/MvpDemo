package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.CuringAdapter;
import com.kiros.mvpdemo.adapter.InfringementAdapter;
import com.kiros.mvpdemo.entity.CuringItem;
import com.kiros.mvpdemo.entity.InfringementItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/7/17.
 */

public class InfringementActivity extends BaseActivity{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private InfringementAdapter infringementAdapter;
    private List<InfringementItem> data = new ArrayList<InfringementItem>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluatelist);
        setTitle("电子罚单");
        recyclerView = findViewById(R.id.ry_evaluate);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        infringementAdapter = new InfringementAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(infringementAdapter);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            InfringementItem infringementItem = new InfringementItem();
            infringementItem.setInfringementTime("2019年5月26号  16:00");
            infringementItem.setInfringementTip("您单位于5月26号, 餐厨油烟排放2.7, 已经属于违章排放, 对您单位进行500元罚款");
            data.add(infringementItem);
        }
        infringementAdapter.notifyDataSetChanged();
    }
}
