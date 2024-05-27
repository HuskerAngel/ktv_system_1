package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mbtfadanmu;

    private Button mbtfazhufu;
    private Button mbtgequfenlei;
    private Button mbtgexing;
    private Button mbtyaokong;
    private Button mbtdiange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtfadanmu = findViewById(R.id.fadanmu);
        mbtfazhufu = findViewById(R.id.fazhufu);
        mbtgequfenlei = findViewById(R.id.gequfenlei);
        mbtgexing = findViewById(R.id.gexing);
        mbtyaokong = findViewById(R.id.yaokong);
        mbtdiange = findViewById(R.id.diange);
        Intent intentfadanmu = new Intent();
        Intent intentfazhufu = new Intent();
        Intent intentgequfenlei = new Intent();
        Intent intentgexing = new Intent();
        Intent intentyaokong = new Intent();
        Intent intentdiange = new Intent();
        intentfadanmu.setAction("redirecttofadanmu");
        intentfadanmu.addCategory(Intent.CATEGORY_DEFAULT);
        intentfazhufu.setAction("redirecttofazhufu");
        intentfazhufu.addCategory(Intent.CATEGORY_DEFAULT);
        intentgequfenlei.setAction("redirecttogequfennlei");
        intentgequfenlei.addCategory(Intent.CATEGORY_DEFAULT);
        intentgexing.setAction("redirecttogexing");
        intentgexing.addCategory(Intent.CATEGORY_DEFAULT);
        intentyaokong.setAction("redirecttoyaokong");
        intentyaokong.addCategory(Intent.CATEGORY_DEFAULT);
        intentdiange.setAction("redirecttodiange");
        intentdiange.addCategory(Intent.CATEGORY_DEFAULT);
    }
}