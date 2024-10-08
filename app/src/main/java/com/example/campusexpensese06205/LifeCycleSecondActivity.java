package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleSecondActivity extends AppCompatActivity {
    Button btnFirstLifeCycle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_second);
        btnFirstLifeCycle = findViewById(R.id.btnFirstLifeCycle);
        btnFirstLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleSecondActivity.this, LifeCycleActivity.class);
                startActivity(intent);
            }
        });
    }
}
