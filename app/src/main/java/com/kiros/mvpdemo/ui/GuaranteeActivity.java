package com.kiros.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.GuaranteeAdapter;
import com.kiros.mvpdemo.api.HttpApi;
import com.kiros.mvpdemo.entity.GuaranteeItem;
import com.kiros.mvpdemo.entity.RepairList;
import com.kiros.mvpdemo.entity.RepairList.DataBean;
import com.kiros.mvpdemo.utils.OkHttpUtils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kiros on 2019/7/17.
 */

public class GuaranteeActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GuaranteeAdapter guaranteeAdapter;
    private List<GuaranteeItem> data = new ArrayList<GuaranteeItem>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_evaluatelist);
        setTitle("报修设备");
        recyclerView = findViewById(R.id.ry_evaluate);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        guaranteeAdapter = new GuaranteeAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(guaranteeAdapter);

        initData();
    }

    private void initData() {
        Map<Object, Object> map = new HashMap<>();
        map.put("platform", "app");
        map.put("code", 1);
        new OkHttpUtils(GuaranteeActivity.this).postMap(HttpApi.REPAIR_URL, map, new OkHttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(JSONObject obj) {
                RepairList orderList = new Gson().fromJson(obj.toString(), RepairList.class);
                if (orderList.getCode() == 1) {
                    List<DataBean> dataBeans = orderList.getData();
                    for (int i = 0; i < dataBeans.size(); i++) {
                        GuaranteeItem guaranteeItem = new GuaranteeItem();
                        guaranteeItem.setGuaranteeTime(dataBeans.get(i).getCreatetime());
                        guaranteeItem.setGuaranteeAddress(dataBeans.get(i).getAddr());
                        guaranteeItem.setGuaranteeReason(dataBeans.get(i).getContent());
                        data.add(guaranteeItem);
                    }
                    guaranteeAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(GuaranteeActivity.this, obj.optString("msg"), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
