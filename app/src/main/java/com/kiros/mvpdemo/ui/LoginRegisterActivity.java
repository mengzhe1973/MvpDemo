package com.kiros.mvpdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.ui.staff.StaffActivity;
import com.kiros.mvpdemo.utils.SharedPreferencesHelper;

/**
 * Created by kiros on 2019/7/14.
 */

public class LoginRegisterActivity extends AppCompatActivity {

    private TextView login, register;
    private SharedPreferencesHelper sharedPreferences;
    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        sharedPreferences = new SharedPreferencesHelper(LoginRegisterActivity.this);
        token = (String) sharedPreferences.getSharedPreference("token", "");
        if (!TextUtils.isEmpty(token)) {
//            Intent intent = new Intent(LoginRegisterActivity.this, HomeActivity.class);
            Intent intent = new Intent(LoginRegisterActivity.this, BossActivity.class);
//            Intent intent = new Intent(LoginRegisterActivity.this, StaffActivity.class);
            startActivity(intent);
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginRegisterActivity.this, UsernameLoginActivity.class));
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginRegisterActivity.this, RegisterActivity.class));
                finish();
            }
        });
    }
}
