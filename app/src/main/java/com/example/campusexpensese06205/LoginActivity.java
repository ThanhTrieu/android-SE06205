package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;

public class LoginActivity extends AppCompatActivity {
    TextView tvRegister;
    EditText edtUser, edtPass;
    Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_login);
        tvRegister = findViewById(R.id.tvRegister);
        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if (TextUtils.isEmpty(user)){
                    edtUser.setError("Username can be not empty");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    edtPass.setError("Password can be not empty");
                    return;
                }
                // doc du lieu tu file trong local storage
                // check du lieu nguoi dung dang nhap
                try {
                    FileInputStream fileInputStream = openFileInput("account.txt");
                    int read = -1;
                    StringBuilder builder = new StringBuilder();
                    while ((read = fileInputStream.read()) != -1){
                        builder.append((char) read);
                    }
                    boolean checkLogin = false;
                    String[] infoAccount = null; // chua tat thong tin account
                    infoAccount = builder.toString().trim().split("\n");
                    for (String account : infoAccount){
                        String username = account.substring(0,account.indexOf("|")).trim();
                        String password = account.substring(account.indexOf("|")+1).trim();
                        if (username.equals(user) && password.equals(pass)){
                            checkLogin = true;
                            break;
                        }
                    }
                    if (checkLogin){
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Account Invalid", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
