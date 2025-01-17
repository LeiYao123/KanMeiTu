package com.kanmeitu.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kanmeitu.R;

public class ImageUtil {
    public static void show(ImageView view, String url) {

        RequestOptions options = getCommonOptions();

        Glide.with(view.getContext())
                .load(url)
                .apply(options)
                .into(view);
    }

    private static RequestOptions getCommonOptions() {

        RequestOptions options = new RequestOptions();
        // 加载前占位图
        options.placeholder(R.mipmap.ic_launcher);
        // 加载失败图
//        options.error(R.mipmap.ic_launcher);
        // 测试 禁用所有缓存
        return options;
    }
}
