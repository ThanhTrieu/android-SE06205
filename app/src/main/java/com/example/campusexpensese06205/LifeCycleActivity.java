package com.example.campusexpensese06205;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity extends AppCompatActivity {
    Button btnLifeCycle;
    EditText edtPhone, edtEmail;
    private final String LOG_TAG = "DemoLifeCycle";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_first);
        btnLifeCycle = findViewById(R.id.btnLifeCycle);
        edtPhone = findViewById(R.id.edtNumber);
        edtEmail = findViewById(R.id.edtEmail);

        /********** Ghi LOG **************/
        Log.i(LOG_TAG, "*********** onCreate Running ************");
        btnLifeCycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhone.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                Intent intent = new Intent(LifeCycleActivity.this, LifeCycleSecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("MY_PHONE", phone);
                bundle.putString("MY_EMAIL",email);
                intent.putExtras(bundle); // dong goi
                startActivity(intent); // gui di sang activity khac
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
