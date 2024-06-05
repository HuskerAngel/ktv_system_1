package com.example.ktv_system.zxc;

import static android.app.Activity.RESULT_OK;
import static com.google.common.base.Verify.verify;
import static org.junit.Assert.*;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;

import com.example.ktv_system.FadanmuActivity;
import com.example.ktv_system.FazhufuActivity;
import com.example.ktv_system.R;

import org.junit.Before;
import org.junit.Test;

import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.ui.widget.DanmakuView;

public class FazhufuActivityTest {

    private DanmakuContext danmakuContext;
    private DanmakuView danmakuView;
//    private ArgumentCaptor<BaseDanmaku>danmakuCaptor;
    private  FadanmuActivity fadanmuActivity;

    @Before
    public void setUp() throws Exception {

//        fadanmuActivity=new FadanmuActivity(danmakuContext,danmakuView);
    }

    @Test
    public void onCreate() {
    }

//    @Test
//    public void onActivityResult() {
//        Intent intent = new Intent();
//        Uri uri = Uri.parse("content://media/external/images/media/123");
//        intent.setData(uri);
//
//        // 调用onActivityResult方法
//        FadanmuActivity.onActivityResult(2, RESULT_OK, intent);
//
//        // 验证函数行为是否符合预期
//        verify(FadanmuActivity).setImageURI(uri);
//    }

    @Test
    public void stasrtFadeOut(){

    }
    @Test
    public  void initDanmaku(){

    }

    @Test
//    public void  addDanmaku(){
//        String content = "Test content";
//        boolean border = true;
//        when(danmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL))
//                .thenReturn(mock(BaseDanmaku.class));
//
//        // Act
//        FazhufuActivity.addDanmaku(content, border);
//
//        // Assert
//        verify(danmakuContext.mDanmakuFactory).createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
//        verify(danmakuView).addDanmaku(danmakuCaptor.capture());
//        BaseDanmaku capturedDanmaku = danmakuCaptor.getValue();
//        assertNotNull(capturedDanmaku);
//        assertEquals(content, capturedDanmaku.text);
//        assertEquals(6, capturedDanmaku.padding);
//        assertEquals(25, capturedDanmaku.textSize);
//        assertEquals(Color.WHITE, capturedDanmaku.textColor);
//        assertEquals(border ? Color.BLUE : Color.TRANSPARENT, capturedDanmaku.borderColor);
//    }

//    }
//    @Test
    public void initializePlayer(){

    }
    @Test
    public void onBackPressed() {
    }
}