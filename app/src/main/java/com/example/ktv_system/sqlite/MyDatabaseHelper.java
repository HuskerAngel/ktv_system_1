package com.example.ktv_system.sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.example.ktv_system.R;
import com.example.ktv_system.dao.GequfenleiProduct;
import com.example.ktv_system.dao.GexingProduct;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public MyDatabaseHelper(@NonNull Context context){
        super(context,"ktv.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "create table singer (singer_name varchar(50) primary key," +
                "singer_sex varchar(50) not null," +
                "singer_nation varchar(50) not null," +
                "singer_picture varchar(50) not null)" ;
        db.execSQL(sql1);
        String sql2 = "create table music_info (id integer primary key autoincrement,"+
                "music_name varchar(50) not null,"+
                "music_time varchar(50) not null,"+
                "music_type varchar(50) not null,"+
                "singer_name varchar(50) not null," +
                "foreign key (singer_name) references singer (singer_name))";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<GexingProduct> getAllGexingProduct () {
        List<GexingProduct> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM singer";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor!=null){
            while(cursor.moveToNext()){
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("singer_name"));
                @SuppressLint("Range") String img = cursor.getString(cursor.getColumnIndex("singer_picture"));
                list.add(new GexingProduct(img,title));
            }
        }
        return list;
    }
}
