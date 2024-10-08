package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity extends AppCompatActivity {
    Button btnLifeCycle;
    private final String LOG_TAG = "DemoLifeCycle";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_first);
        btnLifeCycle = findViewById(R.id.btnLifeCycle);
        /********** Ghi LOG **************/
        Log.i(LOG_TAG, "*********** onCreate Running ************");
        btnLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this, LifeCycleSecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "************ onStart Running ************");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG,"*********** onResume Running *********");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG,"*********** onPause running **********");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "********* onStop Running ********");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG,"******* onRestart Running *********");
    }
}
