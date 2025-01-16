package com.kanmeitu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.kanmeitu.MainActivity;
import com.kanmeitu.R;
import com.kanmeitu.utils.Preference;

public class LoginActivity extends BaseActivity {
    EditText userName;
    EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        userName = findViewById(R.id.username);
        pwd = findViewById(R.id.pwd);
    }

    public void loginAction(View view) {
        if (userName.getText().toString().equals("admin") && pwd.getText().toString().equals("123456")) {

            //登录成功
            Log.d("LoginActivity", "登录成功");
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();
            sp.setLogin(true);
            // 登录成功进入首页
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            //登录失败
            Log.d("LoginActivity", "登录失败");
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }
}