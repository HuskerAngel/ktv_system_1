package com.example.ktv_system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.DrawableMarginSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.VideoView;

import java.io.IOException;
import java.io.InputStream;
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
    private Context context;

    private TextView textView;
    private ImageView imageView;
    private Button btn;


    private BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };
    /**
     * 创建图文混排模式
     * @param drawable
     * @return
     */
    private SpannableStringBuilder createSpannable(Drawable drawable) {
        //25dp转化为px
        float dp = 25;
        final float scale = getResources().getDisplayMetrics().density;
        //由25dp转化来的px
        int px = (int) (dp * scale + 0.5f);



        SpannableStringBuilder spannableString = new SpannableStringBuilder();
        spannableString.append("小明回复小红：你在干嘛呀。");
        //添加图片
        drawable.setBounds(0, 0, px, px);
        ImageSpan imageSpan1 = new ImageSpan(drawable);
        spannableString.setSpan(imageSpan1, spannableString.length() - 1, spannableString.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        return spannableString;
    }

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

//        initDanmaku();


        SpannableStringBuilder spannableString = new SpannableStringBuilder();
        spannableString.append("暗影IV已经开始暴走了");
        ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher);
        //也可以这样
        //Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        //drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        //ImageSpan imageSpan1 = new ImageSpan(drawable);
        //将index为6、7的字符用图片替代
        spannableString.setSpan(imageSpan, 6, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        textView.setText(spannableString);
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
//                    addDanmakuImage(content,true);     // 添加一条弹幕
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


//    private void addDanmaku(String content, boolean border) {
//        // 创建弹幕对象，设置从右向左滚动
//        BaseDanmaku baseDanmaku = danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
//        baseDanmaku.text = content;     // 设置内容
//        baseDanmaku.padding = 6;        // 设置边距
//        baseDanmaku.textSize = 25;      // 设置弹幕字体大小
//        baseDanmaku.textColor = Color.WHITE;
//        baseDanmaku.time=danmaku.getCurrentTime();// 设置弹幕字体颜色
//        // 设置当前时间
//        if (border){
//            baseDanmaku.borderColor = Color.BLUE;       // 设置边框颜色
//        }
//        // 添加弹幕至弹幕视图组件中
//        danmaku.addDanmaku(baseDanmaku);
//    }


    // 添加弹幕
//    private void addDanmakuImage(String content, boolean islive) {
//        // 创建弹幕对象，设置从右向左滚动
//        BaseDanmaku baseDanmaku = danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
//
//        baseDanmaku.text = spannableString;     // 设置内容
//        baseDanmaku.padding = 6;        // 设置边距
//        baseDanmaku.priority=1;
//        baseDanmaku.isLive=islive;
//        baseDanmaku.textSize = 25;      // 设置弹幕字体大小
//        baseDanmaku.textColor = Color.WHITE;
//        baseDanmaku.textShadowColor=0;
//        baseDanmaku.time=danmaku.getCurrentTime()+1200;// 设置弹幕字体颜色
//       // 设置当前时间
//        if (islive){
//            baseDanmaku.borderColor = Color.BLUE;       // 设置边框颜色
//        }
//        // 添加弹幕至弹幕视图组件中
//        danmaku.addDanmaku(baseDanmaku);
//    }

    // 随机生成弹幕


    }





