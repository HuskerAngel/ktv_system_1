package com.example.ktv_system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.widget.VideoView;

import java.util.Random;

import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;

public class FazhufuActivity extends AppCompatActivity {

    private VideoView videoView;

    private EditText editText;
    private ToggleButton btn1;
    private ToggleButton btn2;
    private ToggleButton btn3;
    private ToggleButton btn4;
    private DanmakuView danmaku;
    private boolean showDanmaku;
    private DanmakuContext danmakuContext;

    private Button btn;

    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazhufu);

        videoView=findViewById(R.id.shipin);
        editText=findViewById(R.id.fabianzhufu);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn=findViewById(R.id.fazhufu_fason);
        danmaku=findViewById(R.id.fazhufu_danmaku);

        initDanmaku();
        generateDanmakus();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                editText.setText("祝你生日快乐");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                editText.setText("愿我们的友情地久天长");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn1.setChecked(false);
                btn4.setChecked(false);
                editText.setText("愿我们的爱情如夏日的阳光，温暖而明亮，照亮彼此的生命之路");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn1.setChecked(false);
                editText.setText("岁月悠悠，又迎新年，祝我们新年快乐，心想事成，步步高升");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn1.setChecked(false);
                btn4.setChecked(false);

                View view = LayoutInflater.from(FazhufuActivity.this).inflate(R.layout.activity_duihuankuan,null);
                AlertDialog.Builder builder=new AlertDialog.Builder(FazhufuActivity.this);//要改view的背景颜色，需要再values加一个styles。(MainActivity2.this,R.style.dialog)通过一个资源文件来得到一个圆角
                builder.setView(view);
                builder.create().show();



                String content = editText.getText().toString();
                if (!TextUtils.isEmpty(content)){
                    addDanmaku(content,true);     // 添加一条弹幕
                    editText.setText("");
                }

            }
        });


    }




    private void initDanmaku(){
        danmaku.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                showDanmaku = true;
                danmaku.start();    // 开始弹幕
                generateDanmakus(); // 随机生成弹幕的方法
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

    // 随机生成弹幕
    private void generateDanmakus() {
        // 启用线程随机生成弹幕
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (showDanmaku) {
                    int num = new Random().nextInt(300);
                    String content = ""+num;
                    addDanmaku(content,false);
                    try {
                        Thread.sleep(num);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


}