package com.example.ktv_system.dr;

import static org.junit.Assert.*;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.SousuoActivity;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SousuoActivityTest extends TestCase {

    private ActivityScenario<SousuoActivity> activityScenario;
    @Before
    public void setUp() throws Exception{
        Intent intenttosousuo = new Intent();
        Bundle sousuobundle = new Bundle();
        sousuobundle.putString("搜索内容","taylor");
        intenttosousuo.putExtra("extra",sousuobundle);
        intenttosousuo.setAction("搜索");
        intenttosousuo.addCategory(Intent.CATEGORY_DEFAULT);
        activityScenario = ActivityScenario.launch(intenttosousuo);
    }
    @Test
    public void onCreate() {
        activityScenario.moveToState(Lifecycle.State.CREATED);
        activityScenario.onActivity(sousuoactivity->{
           assertNotNull(sousuoactivity.getList());
        });
    }

    @Test
    public void onResume() {
    }
}