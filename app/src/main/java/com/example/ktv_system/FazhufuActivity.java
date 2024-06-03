package com.example.ktv_system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.LoopingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
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

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
import master.flame.danmaku.danmaku.model.android.BaseCacheStuffer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.model.android.SpannedCacheStuffer;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.danmaku.parser.IDataSource;
import master.flame.danmaku.danmaku.parser.android.BiliDanmukuParser;
import master.flame.danmaku.danmaku.util.IOUtils;
import master.flame.danmaku.ui.widget.DanmakuView;

public class FazhufuActivity extends AppCompatActivity {

    private PlayerView playerView;

    private EditText editText;
    private ToggleButton btn1;
    private ToggleButton btn2;
    private ToggleButton btn3;
    private ToggleButton btn4;
    private IDanmakuView mDanmakuView;
    private boolean showDanmaku;
    private DanmakuView danmaku;
    private ImageView imageView;

    private DanmakuContext danmakuContext;
    private Button btn,upload;
    private View contentView;
    private View progressView;

    private Context context;
    private int mAnimationTime;

    private SimpleExoPlayer player;

    private PlayerView PlayerView;





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

        PlayerView = findViewById(R.id.shipin);
        editText = findViewById(R.id.fabianzhufu);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn = findViewById(R.id.fazhufu_fason);
        danmaku = findViewById(R.id.fazhufu_danmaku);
        upload=findViewById(R.id.upload);
        imageView=findViewById(R.id.fanzhufu_image);

        context = FazhufuActivity.this;
        initializePlayer();
        initDanmaku();
       upload.setOnClickListener(v -> onuploadclick());
       btn1.setOnClickListener(v -> onbtn1click());
       btn2.setOnClickListener(v -> onbtn2click());
       btn3.setOnClickListener(v -> onbtn3click());
       btn4.setOnClickListener(v -> onbtn4click());
       btn.setOnClickListener(v -> onbtnclick());
    }
    public void onbtnclick() {
        btn2.setChecked(false);
        btn3.setChecked(false);
        btn1.setChecked(false);
        btn4.setChecked(false);
        View view = LayoutInflater.from(FazhufuActivity.this).inflate(R.layout.activity_duihuankuan, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(FazhufuActivity.this);//要改view的背景颜色，需要再values加一个styles。(MainActivity2.this,R.style.dialog)通过一个资源文件来得到一个圆角
        builder.setView(view)
                .setCancelable(true);
        final AlertDialog dlg = builder.create();
        dlg.show();
        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                Intent intent1 = new Intent();
                intent1.setClass(FazhufuActivity.this,FazhufuActivity.class);
                dlg.dismiss();
            }
        }, 500);;
        String content = editText.getText().toString();
        if (!TextUtils.isEmpty(content)) {
            addDanmaku(content, true);    // 添加一条弹幕
            editText.setText("");
        }
    }
    public void onbtn4click() {
        btn2.setChecked(false);
        btn3.setChecked(false);
        btn1.setChecked(false);
        editText.setText("岁月悠悠，又迎新年，祝我们新年快乐，心想事成，步步高升");
    }

    public void onbtn3click() {
        btn2.setChecked(false);
        btn1.setChecked(false);
        btn4.setChecked(false);
        editText.setText("愿我们的爱情如夏日的阳光，温暖而明亮，照亮彼此的生命之路");
    }
    public void onbtn2click() {
        btn1.setChecked(false);
        btn3.setChecked(false);
        btn4.setChecked(false);
        editText.setText("愿我们的友情地久天长");
    }
    public void onbtn1click() {
        btn2.setChecked(false);
        btn3.setChecked(false);
        btn4.setChecked(false);
        editText.setText("祝你生日快乐");
    }
    public void onuploadclick() {

        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 2);
        imageView.animate().alpha(1f).setDuration(2500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationCancel(animation);
                        stasrtFadeOut();

                    }
                });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                imageView.setImageURI(uri);
            }
        }
    }
    public void stasrtFadeOut(){
        imageView.animate()
                .alpha(0f)
                .setDuration(2500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                    }
                });
    }
    public void initDanmaku () {
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
        danmaku.prepare(parser, danmakuContext);
    }
    public void addDanmaku (String content,boolean border){
        // 创建弹幕对象，设置从右向左滚动
        BaseDanmaku baseDanmaku = danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
        baseDanmaku.text = content;     // 设置内容
        baseDanmaku.padding = 6;        // 设置边距
        baseDanmaku.textSize = 25;      // 设置弹幕字体大小
        baseDanmaku.textColor = Color.WHITE;
        baseDanmaku.time = danmaku.getCurrentTime();// 设置弹幕字体颜色
        // 设置当前时间
        if (border) {
            baseDanmaku.borderColor = Color.BLUE;       // 设置边框颜色
        }
        // 添加弹幕至弹幕视图组件中
        danmaku.addDanmaku(baseDanmaku);
    }
    public void initializePlayer() {
        player=new SimpleExoPlayer.Builder(this).build();
        PlayerView.setPlayer(player);
        RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(context);
        Uri uri = RawResourceDataSource.buildRawResourceUri(R.raw.shipin1);
        DataSpec dataSpec = new DataSpec(uri);
        try {
            rawResourceDataSource.open(dataSpec);
        } catch (RawResourceDataSource.RawResourceDataSourceException e) {
            e.printStackTrace();
        }
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context,
                Util.getUserAgent(context,"myExoPlayer"));
        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(rawResourceDataSource.getUri());
        LoopingMediaSource loopingMediaSource=new LoopingMediaSource(mediaSource);
        player.prepare(mediaSource);
        player.play();
        player.addListener(new Player.Listener() {

            public void onTimelineChanged(int playbackState) {
                if(playbackState==Player.STATE_ENDED)
                    player.seekTo(0);
                player.prepare(mediaSource);
                player.play();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.release();
    }

}



