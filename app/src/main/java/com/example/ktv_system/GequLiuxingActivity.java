package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ktv_system.adapter.GequAdapter;
import com.example.ktv_system.dao.GequProduct;
import com.example.ktv_system.sqlite.MyDatabaseHelper;

import java.util.List;

public class GequLiuxingActivity extends AppCompatActivity {


    private List<GequProduct> list;
    private ListView mlv;
    private ImageView miv;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gequ_liuxing);

        mlv = findViewById(R.id.liuxing_listview);
        miv = findViewById(R.id.liuxing_backgruond);
        Intent intent = getIntent();
        switch(intent.getBundleExtra("extra").getString("分类")){
            case "民谣":
                miv.setImageResource(R.drawable.minyao);
                break;
            case "欧美":
                miv.setImageResource(R.drawable.oumei);
                break;
            case "摇滚":
                miv.setImageResource(R.drawable.yaogun);
                break;
            case "流行":
                miv.setImageResource(R.drawable.liuxing);
                break;
        }
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        list = myDatabaseHelper.searchGequProduct(intent.getBundleExtra("extra").getString("分类"));
        Log.i("数据test", list.toString());
        GequAdapter gequAdapter  = new GequAdapter(list,this);
        mlv.setAdapter(gequAdapter);
    }
}