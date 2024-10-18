package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleSecondActivity extends AppCompatActivity {
    Button btnFirstLifeCycle;
    TextView tvYourPhone, tvEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_second);
        btnFirstLifeCycle = findViewById(R.id.btnFirstLifeCycle);
        tvYourPhone = findViewById(R.id.tvYourPhone);
        tvEmail = findViewById(R.id.tvEmail);
        // lay du lieu tu activity khac gui sang
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            String phone = bundle.getString("MY_PHONE","");
            tvYourPhone.setText(phone);
            String email = bundle.getString("MY_EMAIL", "");
            tvEmail.setText(email);
        }

        btnFirstLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleSecondActivity.this, LifeCycleActivity.class);
                startActivity(intent);
            }
        });
    }
}
