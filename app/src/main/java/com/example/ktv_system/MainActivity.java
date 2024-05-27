package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button mbtfadanmu;
    private Button mbtfazhufu;
    private Button mbtgequfenlei;
    private Button mbtgexing;
    private Button mbtyaokong;
    private Button mbtdiange;

    private GridView mlvgequ_mingdan;
    private ListView mgvgexing_mingdan;
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
        mlvgequ_mingdan = findViewById(R.id.gequ_mingdan);
        mgvgexing_mingdan = findViewById(R.id.gexing_mingdan);
        Intent intentfadanmu = new Intent();
        Intent intentfazhufu = new Intent();
        Intent intentyaokong = new Intent();
        Intent intentdiange = new Intent();
        intentfadanmu.setAction("redirecttofadanmu");
        intentfadanmu.addCategory(Intent.CATEGORY_DEFAULT);
        intentfazhufu.setAction("redirecttofazhufu");
        intentfazhufu.addCategory(Intent.CATEGORY_DEFAULT);
        intentyaokong.setAction("redirecttoyaokong");
        intentyaokong.addCategory(Intent.CATEGORY_DEFAULT);
        intentdiange.setAction("redirecttodiange");
        intentdiange.addCategory(Intent.CATEGORY_DEFAULT);
        mbtfadanmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentfadanmu);
            }
        });
        mbtfazhufu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentfazhufu);
            }
        });
        mbtyaokong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentyaokong);
            }
        });
        mbtdiange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentdiange);
            }
        });
        mbtgequfenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       mbtgexing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}