package com.example.ktv_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ktv_system.adapter.Fragmentadapter;
import com.example.ktv_system.fragment.ControlFragment;
import com.example.ktv_system.fragment.MainFragment;
import com.example.ktv_system.fragment.MusicFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    private BottomNavigationView bottomNavigationView;

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        viewPager2 = findViewById(R.id.viewpager2bottom);
        bottomNavigationView = findViewById(R.id.bootomnav2);
        bottomNavigationView.setItemIconTintList(null);
        fragmentList.add(new MainFragment());
        fragmentList.add(new ControlFragment());
        fragmentList.add(new MusicFragment());
        Fragmentadapter fragmentadapter =
                new Fragmentadapter(this,fragmentList);
        viewPager2.setAdapter(fragmentadapter);
        //重点 设置 bottomNavigationView 的item 的点击事件 设置viewPager2的联动
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId){
                    case R.id.main_item:
                        viewPager2.setCurrentItem(0);
                        break;
                    case R.id.control_item:
                        viewPager2.setCurrentItem(1);
                        break;
                    case R.id.music_item:
                        viewPager2.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}