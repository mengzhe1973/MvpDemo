package com.kiros.mvpdemo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.adapter.EvaluateAdapter;
import com.kiros.mvpdemo.entity.EvaluateItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiros on 2019/7/16.
 */

public class EvaluateListActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private EvaluateAdapter evaluateAdapter;
    private List<EvaluateItem> data = new ArrayList<EvaluateItem>();

    private RadioGroup rg;
    private RadioButton tab1, tab2, tab3;
    private View view1, view2, view3, view4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_my_evaluatelist);
        setTitle("维保评价");
        recyclerView = findViewById(R.id.ry_evaluate);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        evaluateAdapter = new EvaluateAdapter(this, data);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(evaluateAdapter);
        initView();
        initData();
    }

    private void initView() {
        rg = findViewById(R.id.tab_rg);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view1.setBackgroundColor(Color.parseColor("#3f7fff"));
        view2.setBackgroundColor(Color.parseColor("#3f7fff"));
        view3.setBackgroundColor(Color.parseColor("#cccccc"));
        view4.setBackgroundColor(Color.parseColor("#cccccc"));

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //获取变更后的选中项的ID
//              int radioButtonId = radioGroup.getCheckedRadioButtonId();
                switch (i) {
                    case R.id.tab1:
                        tab1.setChecked(true);
                        tab2.setChecked(false);
                        tab3.setChecked(false);
                        view1.setBackgroundColor(Color.parseColor("#3f7fff"));
                        view2.setBackgroundColor(Color.parseColor("#3f7fff"));
                        view3.setBackgroundColor(Color.parseColor("#cccccc"));
                        view4.setBackgroundColor(Color.parseColor("#cccccc"));
                        break;
                    case R.id.tab2:
                        tab1.setChecked(false);
                        tab2.setChecked(true);
                        tab3.setChecked(false);
                        view1.setBackgroundColor(Color.parseColor("#cccccc"));
                        view2.setBackgroundColor(Color.parseColor("#3f7fff"));
                        view3.setBackgroundColor(Color.parseColor("#3f7fff"));
                        view4.setBackgroundColor(Color.parseColor("#cccccc"));
                        break;
                    case R.id.tab3:
                        tab1.setChecked(false);
                        tab2.setChecked(false);
                        tab3.setChecked(true);
                        view1.setBackgroundColor(Color.parseColor("#cccccc"));
                        view2.setBackgroundColor(Color.parseColor("#cccccc"));
                        view3.setBackgroundColor(Color.parseColor("#3f7fff"));
                        view4.setBackgroundColor(Color.parseColor("#3f7fff"));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            EvaluateItem evaluateItem = new EvaluateItem();
            evaluateItem.setFeedbackTime("2019年5月23  16：00");
            evaluateItem.setEvaluateName("张大宝");
            evaluateItem.setEvaluateTime("2019年5月23  16：00");
            evaluateItem.setEvaluateAddress("郑州市上街区雅兴江南小区2号楼23楼2308");
            evaluateItem.setEvaluateReason("郑州市上街区雅兴江南小区2号楼23楼2308");
            data.add(evaluateItem);
        }
        evaluateAdapter.notifyDataSetChanged();
    }
}
