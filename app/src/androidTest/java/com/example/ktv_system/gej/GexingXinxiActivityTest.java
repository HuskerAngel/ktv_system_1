package com.example.ktv_system.gej;

import static org.junit.Assert.*;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.GexingXinxiActivity;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GexingXinxiActivityTest extends TestCase {

    private ActivityScenario<GexingXinxiActivity> activityScenario;
    @Before
    public void setUp() throws Exception {
        Intent intenttogexingxinxi = new Intent();
        Bundle gexingxinxibundle = new Bundle();
        gexingxinxibundle.putString("歌手名","Taylor Swift");
        gexingxinxibundle.putString("歌手图片","taylorswift.png");
        intenttogexingxinxi.putExtra("extra",gexingxinxibundle);
        intenttogexingxinxi.setAction("歌星曲目列表");
        intenttogexingxinxi.addCategory(Intent.CATEGORY_DEFAULT);
        activityScenario = ActivityScenario.launch(intenttogexingxinxi);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {
        activityScenario.moveToState(Lifecycle.State.CREATED);
        activityScenario.onActivity(gexingXinxiActivity->{
            assertNotNull(gexingXinxiActivity.getList());
        });
    }

    @Test
    public void getBitmapFromAssets() {
        activityScenario.onActivity(gexingXinxiActivity->{
            assertNotNull(gexingXinxiActivity.getBitmapFromAssets("taylorswift.png"));
        });
    }
}