package com.example.campusexpensese06205;

import android.content.Context;
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

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class RegisterActivity extends AppCompatActivity {
    TextView tvLogin;
    EditText edtUser, edtPass;
    Button btnSignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_register);
        tvLogin = findViewById(R.id.tvLogin);
        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPassword);
        btnSignup = findViewById(R.id.btnRegister);

        btnSignup.setOnClickListener(new View.OnClickListener() {
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
                // Tien hanh luu du lieu vao local storage
                // bo nho trong cua thiet bi di dong
                // luu duoi dang la 1 file
                FileOutputStream fileOutputStream = null;
                try {
                    user = user + "|"; // ngan cach user va pass
                    fileOutputStream = openFileOutput("account.txt", Context.MODE_APPEND);
                    fileOutputStream.write(user.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write(pass.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write('\n');
                    fileOutputStream.close();
                    edtUser.setText(""); // xoa du lieu o EditText
                    edtPass.setText("");
                    Toast.makeText(RegisterActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
