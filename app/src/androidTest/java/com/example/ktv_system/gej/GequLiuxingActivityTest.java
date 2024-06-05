package com.example.ktv_system.gej;

import static org.junit.Assert.*;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.GequLiuxingActivity;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GequLiuxingActivityTest extends TestCase {

    private ActivityScenario<GequLiuxingActivity> activityScenario;
    @Before
    public void setUp() throws Exception {
        Intent intenttomusiclist = new Intent();
        Bundle musiclistbundle = new Bundle();
        musiclistbundle.putString("分类","欧美");
        intenttomusiclist.putExtra("extra",musiclistbundle);
        intenttomusiclist.setAction("歌曲列表");
        intenttomusiclist.addCategory(Intent.CATEGORY_DEFAULT);
        activityScenario = ActivityScenario.launch(intenttomusiclist);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {
        activityScenario.moveToState(Lifecycle.State.CREATED);
        activityScenario.onActivity(gequliuxingactivity->{
            assertNotNull(gequliuxingactivity.getList());
        });
    }
}