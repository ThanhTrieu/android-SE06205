package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoLayoutActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtUser, edtPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout_demo);
        // anh xa view (tim phan tu ngoai view)
        btnLogin = findViewById(R.id.btnLogin);
        edtUser = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);

        // bat su kien nguoi dung click vao button login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lay du lieu ma nguoi dung nhap
                String username = edtUser.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(username)){
                    edtUser.setError("Username can be not empty");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    edtPassword.setError("Password can be not empty");
                    return;
                }
                if (username.equals("trieunt") && password.equals("123")){
                    // dang nhap thanh cong
                    Intent intent = new Intent(DemoLayoutActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // dang nhap that bai
                    Toast.makeText(
                            DemoLayoutActivity.this,
                            "Account Invalid",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
