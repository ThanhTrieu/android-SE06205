package com.example.campusexpensese06205;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoEventActivity extends AppCompatActivity {
    EditText edtData;
    CheckBox cbAgree;
    TextView tvTitle, tvCountText;
    Button btnClickMe;
    RadioGroup radgAddress;
    RadioButton radHaNoi, radNamDinh, radThaiBinh;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_event);
        edtData = findViewById(R.id.edtData);
        cbAgree = findViewById(R.id.cbAgree);
        tvTitle = findViewById(R.id.tvTitle);
        tvCountText = findViewById(R.id.tvCountText);
        btnClickMe = findViewById(R.id.btnClickMe);
        radgAddress = findViewById(R.id.radgAddress);
        radHaNoi = findViewById(R.id.radHaNoi);
        radNamDinh = findViewById(R.id.radNamDinh);
        radThaiBinh = findViewById(R.id.radThaiBinh);

        // block EditText
        edtData.setEnabled(false);
        // bat su kien nguoi dung tich chon checkbox
        cbAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // tich chon
                    edtData.setEnabled(true);
                } else {
                    // khong tich chon
                    edtData.setEnabled(false);
                }
            }
        });

        // su kien onchange EditText
        edtData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvCountText.setText(String.valueOf(count));
            }

            @Override
            public void afterTextChanged(Editable s) {
                String data = s.toString();
                int countData = data.length();
                tvTitle.setText(data);
                tvCountText.setText(String.valueOf(countData));
            }
        });
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radgAddress.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String address = radioButton.getText().toString().trim().toLowerCase();
                if (address.equals("ha noi")){
                    edtData.setEnabled(true);
                } else {
                    edtData.setEnabled(false);
                }
                Toast.makeText(DemoEventActivity.this, address, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
