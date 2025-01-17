package com.kanmeitu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kanmeitu.activity.BaseActivity;
import com.kanmeitu.activity.ImageDetailActivity;
import com.kanmeitu.activity.LoginActivity;
import com.kanmeitu.adapter.ImageAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView listView = findViewById(R.id.list);
        listView.setHasFixedSize(true);

        // 显示2列 9宫格
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        listView.setLayoutManager(layoutManager);

        // 添加测试数据
        ArrayList<String> datum = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datum.add(String.format("https://picsum.photos/720/640/?random=%d", i));
        }
        ImageAdapter imageAdapter = new ImageAdapter(this, datum);

        imageAdapter.setOnItemClick(position -> {
           String data = imageAdapter.getData(position);
           Toast.makeText(this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();

           Intent intent = new Intent(this, ImageDetailActivity.class);
           intent.putExtra("data", data);
           startActivity(intent);
        });

        listView.setAdapter(imageAdapter);
    }

    /**
     * 退出登录
     */
    public void logout(View view) {
        sp.setLogin(false);
        Log.d("MainActivity", "退出登录");
        Toast.makeText(this, "退出成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}