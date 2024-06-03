package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.ktv_system.adapter.GequAdapter;
import com.example.ktv_system.dao.GequProduct;
import com.example.ktv_system.sqlite.MyDatabaseHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GexingXinxiActivity extends AppCompatActivity {

    private ListView mlv;
    private ImageView miv;
    private List<GequProduct> list;
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gexing_xinxi);
        mlv = findViewById(R.id.gequ_xinxi_listview);
        miv = findViewById(R.id.gequ_xinxi_imagview);
        Intent intent = getIntent();
        Bitmap bitmap = getBitmapFromAssets(intent.getBundleExtra("extra").getString("歌手图片"));
        if (bitmap!=null){
            miv.setImageBitmap(bitmap);
        }else{
            Log.e("AssetError", "failed to load image:"+intent.getBundleExtra("extra").getString("歌手图片"));
            bitmap = getBitmapFromAssets("unknown.png");
            miv.setImageBitmap(bitmap);
        }
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        list = myDatabaseHelper.searchGequProduct(intent.getBundleExtra("extra").getString("歌手名"));
        GequAdapter gequAdapter = new GequAdapter(list,this);
        mlv.setAdapter(gequAdapter);
    }

    public Bitmap getBitmapFromAssets(String fileName){
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try{
            inputStream = assetManager.open(fileName);
            return BitmapFactory.decodeStream(inputStream);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}