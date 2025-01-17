package com.kanmeitu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.kanmeitu.MainActivity;
import com.kanmeitu.R;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 3s 后跳转到 MainActivity
        findViewById(R.id.copyright).postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        }, 3000);
    }

    private void next() {
        finish();
        Intent intent;
        if (sp.isLogin()) {
            // 已经登录过
            Log.d("SplashActivity", "已经登录过");
            intent = new Intent(this, MainActivity.class);
        } else {
            // 没有登录过
            Log.d("SplashActivity", "没有登录过");
            // 登录成功进入首页
            intent = new Intent(this, LoginActivity.class);
        }
        startActivity(intent);
    }
}