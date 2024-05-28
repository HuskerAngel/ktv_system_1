package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GequLiuxingActivity extends AppCompatActivity {

    private TextView mtv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gequ_liuxing);
        mtv = findViewById(R.id.zanshi);
        Intent intent = getIntent();
        mtv.setText(intent.getBundleExtra("extra").getString("分类"));
    }
}