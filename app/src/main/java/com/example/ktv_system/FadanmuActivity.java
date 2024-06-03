package com.example.ktv_system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ToggleButton;
import android.widget.VideoView;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.SpannedCacheStuffer;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;
import master.flame.danmaku.danmaku.parser.android.BiliDanmukuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class FadanmuActivity extends AppCompatActivity {

    private VideoView videoView;

    private EditText editText;
    private ToggleButton btn1;
    private ToggleButton btn2;
    private ToggleButton btn3;
    private ToggleButton btn4;
    private Button btn;
    private DanmakuView danmaku;
    private boolean showDanmaku;
    private DanmakuContext danmakuContext;

    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadanmu);

        videoView=findViewById(R.id.shiping);
        editText= findViewById(R.id.fandanmu_et);
        btn1=findViewById(R.id.fadanmu_btn1);
        btn2=findViewById(R.id.fandanmu_btn2);
        btn3=findViewById(R.id.fandanmu_btn3);
        btn4=findViewById(R.id.fandanmu_btn4);
        btn=findViewById(R.id.fadanmu_fason);
        danmaku=findViewById(R.id.fadanmu_danmaku);
        initDanmaku();


        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.shipin1);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);//让视频循环播放
            }
        });

        btn1.setOnClickListener(this::onBtn1Click);
        btn2.setOnClickListener(this::onBtn2Click);
        btn3.setOnClickListener(this::onBtn3Click);
        btn4.setOnClickListener(this::onBtn4Click);
        btn.setOnClickListener(this::onBtnClick);
    }

    public void onBtnClick(View v) {
        btn2.setChecked(false);
        btn3.setChecked(false);
        btn1.setChecked(false);
        btn4.setChecked(false);
        View view = LayoutInflater.from(FadanmuActivity.this).inflate(R.layout.activity_duihuankuan,null);

        AlertDialog.Builder builder=new AlertDialog.Builder(FadanmuActivity.this);//要改view的背景颜色，需要再values加一个styles。(MainActivity2.this,R.style.dialog)通过一个资源文件来得到一个圆角
        builder.setView(view)
                .setCancelable(true);
        final AlertDialog dlg = builder.create();
        dlg.show();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                Intent intent1 = new Intent();
                intent1.setClass(FadanmuActivity.this, FadanmuActivity.class);
                dlg.dismiss();
            }
        }, 500);


        String content = editText.getText().toString();
        if (!TextUtils.isEmpty(content)) {
            addDanmaku(content, true);     // 添加一条弹幕
            editText.setText("");
        }
    }

    public void onBtn4Click(View view) {
        btn2.setChecked(false);
        btn3.setChecked(false);
        btn1.setChecked(false);
        editText.setText("想要的都拥有，得不到的都释怀。生日快乐");
    }

    public void onBtn3Click(View view) {
        btn2.setChecked(false);
        btn1.setChecked(false);
        btn4.setChecked(false);
        editText.setText("有毛病呀，唱这么好听干嘛");
    }

    public void onBtn2Click(View view) {
        btn1.setChecked(false);
        btn3.setChecked(false);
        btn4.setChecked(false);
        editText.setText("听你的歌，真的需要勇气");
    }

    public void onBtn1Click(View view) {
        btn2.setChecked(false);
        btn3.setChecked(false);
        btn4.setChecked(false);
        editText.setText("狂击6666~");
    }


    private void initDanmaku(){
        danmaku.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                showDanmaku = true;
                danmaku.start();    // 开始弹幕// 随机生成弹幕的方法
            }
            @Override
            public void updateTimer(DanmakuTimer timer) {
            }
            @Override
            public void danmakuShown(BaseDanmaku danmaku) {
            }
            @Override
            public void drawingFinished() {
            }
        });


        // 创建 DanmakuContext 上下文对象
        danmakuContext = DanmakuContext.create();
        // 开始缓存
        danmaku.enableDanmakuDrawingCache(true);
        // 弹幕view准备  --- 传入解析器
        danmaku.prepare(parser,danmakuContext);

    }
    // 添加弹幕
    private void addDanmaku(String content, boolean border) {
        // 创建弹幕对象，设置从右向左滚动
        BaseDanmaku baseDanmaku = danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        baseDanmaku.text = content;     // 设置内容
        baseDanmaku.padding = 6;        // 设置边距
        baseDanmaku.textSize = 25;      // 设置弹幕字体大小
        baseDanmaku.textColor = Color.WHITE;
        baseDanmaku.time=danmaku.getCurrentTime();// 设置弹幕字体颜色
        // 设置当前时间
        if (border){
            baseDanmaku.borderColor = Color.BLUE;       // 设置边框颜色
        }
        // 添加弹幕至弹幕视图组件中
        danmaku.addDanmaku(baseDanmaku);
    }



}


