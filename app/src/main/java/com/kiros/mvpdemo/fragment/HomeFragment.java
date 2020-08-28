package com.kiros.mvpdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.api.HttpApi;
import com.kiros.mvpdemo.ui.CuringActivity;
import com.kiros.mvpdemo.ui.EqRunActivity;
import com.kiros.mvpdemo.ui.EvaluateListActivity;
import com.kiros.mvpdemo.ui.GuaranteeActivity;
import com.kiros.mvpdemo.ui.InfringementActivity;
import com.kiros.mvpdemo.ui.staff.MaintenanceActivity;
import com.kiros.mvpdemo.utils.GlideImageLoader;
import com.kiros.mvpdemo.utils.OkHttpUtils;
import com.kiros.mvpdemo.utils.StatusBarUtil;
import com.kiros.mvpdemo.utils.StatusBarUtil1;
import com.youth.banner.Banner;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kiros on 2019/7/14.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Banner banner;
    //    private List<?> images = new ArrayList<>();
//    String[] urls = getResources().getStringArray(R.array.url);
    private List<Integer> images = new ArrayList<>();

    private TextView guarantee, //设备保修
            maintenance,//查看维保
            feedback,//评价
            curing,//设备养护常识
            eq_run,//设备运行
            infringement;//电子罚单
    private LinearLayout sign;
    private TextView title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_boss_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), 0, title);
        StatusBarUtil1.transparencyBar(getActivity()); //设置状态栏全透明
        StatusBarUtil1.StatusBarLightMode(getActivity()); //设置白底黑字
        banner = view.findViewById(R.id.banner);
        guarantee = view.findViewById(R.id.guarantee);
        maintenance = view.findViewById(R.id.maintenance);
        feedback = view.findViewById(R.id.feedback);
        curing = view.findViewById(R.id.curing);
        eq_run = view.findViewById(R.id.eq_run);
        infringement = view.findViewById(R.id.infringement);
        sign = view.findViewById(R.id.sign);
        //加载网络图片
//        List list = Arrays.asList(urls);
//        images = new ArrayList(list);
        //加载本地图片
        images.clear();
        images.add(R.mipmap.b1);
        images.add(R.mipmap.b2);
        images.add(R.mipmap.b1);


//        banner.setImages(images)
//                .setImageLoader(new GlideImageLoader())
//                .start();

        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        banner.start();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        guarantee.setOnClickListener(this);
        maintenance.setOnClickListener(this);
        feedback.setOnClickListener(this);
        curing.setOnClickListener(this);
        eq_run.setOnClickListener(this);
        infringement.setOnClickListener(this);
        sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.guarantee:
                intent = new Intent(getContext(), GuaranteeActivity.class);
                break;
            case R.id.maintenance:
                intent = new Intent(getContext(), MaintenanceActivity.class);
                break;
            case R.id.feedback:
                intent = new Intent(getContext(), EvaluateListActivity.class);
                break;
            case R.id.curing:
                intent = new Intent(getContext(), CuringActivity.class);
                break;
            case R.id.eq_run:
                intent = new Intent(getContext(), EqRunActivity.class);
                break;
            case R.id.infringement:
                intent = new Intent(getContext(), InfringementActivity.class);
                break;
            case R.id.sign:
                sign();
                break;
            default:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    private void sign() {
        Map<Object, Object> map = new HashMap<>();
        new OkHttpUtils(getContext()).postMap(HttpApi.SIGNIN_URL, map, new OkHttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(JSONObject obj) {
                if (obj.optInt("code") == 1) {
                    Toast.makeText(getContext(), "签到成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), obj.optString("msg"), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
