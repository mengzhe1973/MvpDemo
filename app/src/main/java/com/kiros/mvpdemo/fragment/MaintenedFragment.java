package com.kiros.mvpdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.MaintenedBossAdapter;
import com.kiros.mvpdemo.adapter.staff.MaintenanceAdapter;
import com.kiros.mvpdemo.entity.MaintenanBossItem;
import com.kiros.mvpdemo.entity.staff.MaintenanceItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/9/3.
 */

public class MaintenedFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MaintenedBossAdapter maintenanceAdapter;
    private List<MaintenanBossItem> data = new ArrayList<MaintenanBossItem>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maintened, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.ry_evaluate);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        maintenanceAdapter = new MaintenedBossAdapter(getContext(), data, 1);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(maintenanceAdapter);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            MaintenanBossItem maintenanceItem = new MaintenanBossItem();
            maintenanceItem.setTime("2019年5月23  16：00");
            maintenanceItem.setAddress("郑州市上街区雅兴江南小区2号楼23楼2308");
            maintenanceItem.setReason("聚焦油烟机聚焦油烟机");
            maintenanceItem.setSituation("聚焦油烟机");
            maintenanceItem.setMaintenancer("张大宝");
            data.add(maintenanceItem);
        }
        maintenanceAdapter.notifyDataSetChanged();
    }
}
