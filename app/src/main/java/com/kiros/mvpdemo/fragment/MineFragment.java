package com.kiros.mvpdemo.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.api.HttpApi;
import com.kiros.mvpdemo.ui.FeedbackActivity;
import com.kiros.mvpdemo.ui.LoginActivity;
import com.kiros.mvpdemo.ui.UsernameLoginActivity;
import com.kiros.mvpdemo.utils.OkHttpUtils;
import com.kiros.mvpdemo.utils.SharedPreferencesHelper;
import com.kiros.mvpdemo.utils.StatusBarUtil;
import com.kiros.mvpdemo.utils.StatusBarUtil1;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by kiros on 2019/7/14.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private LinearLayout feedback;
    private LinearLayout exit;
    private ImageView user, warn;
    private SharedPreferencesHelper sharedPreferences;
    private TextView title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.title);
        StatusBarUtil.setTranslucentForImageViewInFragment(getActivity(), 0, title);
        feedback = view.findViewById(R.id.feedback);
        exit = view.findViewById(R.id.exit);
        user = view.findViewById(R.id.user);
        warn = view.findViewById(R.id.warn);
        sharedPreferences = new SharedPreferencesHelper(getContext());
        QBadgeView qBadgeView = new QBadgeView(getContext());
        qBadgeView.bindTarget(warn);//设置要显示消息提示的View 控件
        qBadgeView.setBadgeNumber(2);//设置Badge数字
        qBadgeView.setBadgeBackgroundColor(Color.parseColor("#dc054e"));
        qBadgeView.setBadgeTextColor(Color.parseColor("#ffffff"));//设置文本颜色
        qBadgeView.setExactMode(true);//设置是否显示精确模式数值
        qBadgeView.setBadgeGravity(Gravity.END | Gravity.TOP);//设置Badge相对于TargetView的位置
        qBadgeView.setGravityOffset(1.0f, true);//设置外边距
        qBadgeView.setBadgePadding(1.0f, true);//设置内边距
        qBadgeView.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int i, Badge badge, View view) {
                Log.d("aaaaaaaaa", "onDragStateChanged:  i=" + i + "badge=" + badge + "view");

            }
        });//打开拖拽消除模式并设置监听

//        getUserData();
    }

    private void getUserData() {
        Map<Object, Object> map = new HashMap<>();
        new OkHttpUtils(getContext()).postMap(HttpApi.USRE_URL, map, new OkHttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(JSONObject obj) {
                if (obj.optInt("code") == 1) {
                    Log.d("aaaaaaaaaa", obj.toString());
                } else {
                    Toast.makeText(getContext(), obj.optString("msg"), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onError(String msg) {

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        feedback.setOnClickListener(this);
        exit.setOnClickListener(this);
        user.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.feedback:
                intent = new Intent(getContext(), FeedbackActivity.class);
                break;
            case R.id.user:
                intent = new Intent(getContext(), UsernameLoginActivity.class);
                intent.putExtra("from", 1);
                break;
            case R.id.exit:
                sharedPreferences.put("token", "");
                sharedPreferences.put("user_id", "");
                startActivity(new Intent(getContext(), UsernameLoginActivity.class));
                getActivity().finish();
                break;
            default:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
