package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ktv_system.adapter.GequAdapter;
import com.example.ktv_system.dao.GequProduct;
import com.example.ktv_system.sqlite.MyDatabaseHelper;

import java.util.List;

public class SousuoActivity extends AppCompatActivity {

    private ListView mlv;

    private List<GequProduct> list;
    private  GequAdapter gequAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sousuo);
        mlv = findViewById(R.id.sousuo_lv);
        Intent intent = getIntent();
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        list = myDatabaseHelper.searchGequProduct(intent.getBundleExtra("extra").getString("搜索内容"));
        gequAdapter = new GequAdapter(list,this);
        mlv.setAdapter(gequAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        gequAdapter.notifyDataSetChanged();
        mlv.setAdapter(gequAdapter);
    }
}