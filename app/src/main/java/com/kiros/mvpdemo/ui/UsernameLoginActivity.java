package com.kiros.mvpdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.api.HttpApi;
import com.kiros.mvpdemo.entity.Userinfo;
import com.kiros.mvpdemo.utils.OkHttpUtils;
import com.kiros.mvpdemo.utils.SharedPreferencesHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kiros on 2019/7/14.
 */

public class UsernameLoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView login;
    private SharedPreferencesHelper sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //隐藏标题栏以及状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        sharedPreferences = new SharedPreferencesHelper(UsernameLoginActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        Map<Object, Object> map = new HashMap<>();
        String account = username.getText().toString().trim();
        String passwordStr = password.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(UsernameLoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(passwordStr)) {
            Toast.makeText(UsernameLoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
        }
        map.put("account", account);
        map.put("password", passwordStr);
        new OkHttpUtils(this).postMap(HttpApi.LOGIN_URL, map, new OkHttpUtils.HttpCallBack() {
            @Override
            public void onSuccess(JSONObject obj) {
                Intent intent = new Intent();
                try {
                    JSONObject jsonObject = new JSONObject(obj.optString("data"));
                    Userinfo userinfo = new Gson().fromJson(jsonObject.optString("userinfo"), Userinfo.class);
                    sharedPreferences.put("token", userinfo.getToken());
                    sharedPreferences.put("user_id", userinfo.getUser_id());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (getIntent().getIntExtra("from", 0) != 1) {
//                    intent.setClass(UsernameLoginActivity.this, HomeActivity.class);
                    intent.setClass(UsernameLoginActivity.this, BossActivity.class);
                    startActivity(intent);
                }
                finish();
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
