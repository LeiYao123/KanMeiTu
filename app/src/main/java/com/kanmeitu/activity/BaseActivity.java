package com.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.kanmeitu.utils.Preference;

public class BaseActivity extends AppCompatActivity {
    protected Preference sp;


    /**
     * 重写 setContentView 方法，在设置布局之前初始化 偏好设置工具类
     * 因为子类调用了 setContentView 设置布局
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        // 偏好设置工具类
        sp = Preference.getInstance(this);
    }
}
