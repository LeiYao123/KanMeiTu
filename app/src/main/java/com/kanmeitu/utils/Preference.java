package com.kanmeitu.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private static final String KEY_LOGIN = "LOGIN";
    private static Preference instance;
    private final SharedPreferences preference;

    private Preference(Context context) {
        preference = context.getSharedPreferences("ixuea", Context.MODE_PRIVATE);
    }

    /**
     * 获取偏好工具类(单例设计模式)
     * @return instance
     */
    public static Preference getInstance(Context context) {
        if (instance == null) {
            instance = new Preference(context.getApplicationContext());
        }
        return instance;
    }

    /**
     * 设置登录状态
     */
    public void setLogin(Boolean data) {
        preference.edit().putBoolean(KEY_LOGIN, data).apply();
    }

    /**
     * 获取登录状态
     */
    public boolean isLogin() {
        return preference.getBoolean(KEY_LOGIN, false);
    }
}
