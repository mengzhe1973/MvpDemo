package com.kiros.mvpdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kiros.mvpdemo.BaseActivity;
import com.kiros.mvpdemo.R;
import com.kiros.mvpdemo.widget.PhoneCode;


public class CodeActivity extends BaseActivity {
    private PhoneCode pc_1;
    private TextView next;
    private boolean isClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_verification_code);
        setTitle("获取验证码");
        pc_1 = findViewById(R.id.pc_1);
        next = findViewById(R.id.next);

        pc_1.setOnInputListener(new PhoneCode.OnInputListener() {
            @Override
            public void onSuccess(String code) {
                isClick = true;
                next.setBackground(getResources().getDrawable(R.drawable.btn_blue,null));
            }

            @Override
            public void onInput() {
                isClick = false;
                next.setBackground(getResources().getDrawable(R.drawable.btn_gray,null));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClick) {
                    startActivity(new Intent(CodeActivity.this, HomeActivity.class));
                    finish();
                } else {
                    Toast.makeText(CodeActivity.this, "请输入正确的验证码", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
