package com.example.ktv_system.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

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
}
