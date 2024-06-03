package com.example.ktv_system;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import com.example.ktv_system.adapter.Fragmentadapter;
import com.example.ktv_system.adapter.GequfenleiAdapter;
import com.example.ktv_system.fragment.ControlFragment;
import com.example.ktv_system.fragment.MainFragment;
import com.example.ktv_system.fragment.MusicFragment;
import com.example.ktv_system.sqlite.MyDatabaseHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private String DB_PATH = "/data/data/com.example.ktv_system/databases/";
    private String DB_NAME = "ktv.db";
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        cloneData();

        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        viewPager2 = findViewById(R.id.viewpager2bottom);
        bottomNavigationView = findViewById(R.id.bootomnav2);



        bottomNavigationView.setItemIconTintList(null);
        fragmentList.add(new MainFragment());
        fragmentList.add(new ControlFragment());
        fragmentList.add(new MusicFragment());
        Fragmentadapter fragmentadapter =
                new Fragmentadapter(this,fragmentList);
        viewPager2.setAdapter(fragmentadapter);
        viewPager2.setUserInputEnabled(false);

        bottomNavigationView.setOnItemSelectedListener(this::OnBottomNavigationViewItemSelected);
    }
    public boolean OnBottomNavigationViewItemSelected(@NonNull MenuItem item) {
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

    private void cloneData() {
        if ((new File(DB_PATH + DB_NAME)).exists() == false) {
            Log.e("数据库是否存在", "cloneData: "+"不存在" );
            // 如 SQLite 数据库文件不存在，再检查一下 database 目录是否存在
            File f = new File(DB_PATH);
            // 如 database 目录不存在，新建该目录
            Log.e("目录路径", "cloneData: "+f );
            if (!f.exists()) {
                f.mkdir();
            }
            try {
                // 得到 assets 目录下我们实现准备好的 SQLite 数据库作为输入流
                InputStream is = getBaseContext().getAssets().open(DB_NAME);
                // 输出流
                OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);
                // 文件写入
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                // 关闭文件流
                os.flush();
                os.close();
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            Log.e("数据库是否存在", "cloneData: 存在数据库");
            Log.e("存在目录", "cloneData: "+(new File(DB_PATH + DB_NAME)).getAbsolutePath());
        }

    }


}
