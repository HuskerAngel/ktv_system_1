package com.example.ktv_system.dr;

import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.FazhufuActivity;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FazhufuActivityTest extends TestCase {

    private ActivityScenario<FazhufuActivity> activityScenario;
    @Before
    public void setUp() throws Exception {
        activityScenario = ActivityScenario.launch(FazhufuActivity.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {
    }

    @Test
    public void onbtnclick() {
        activityScenario.onActivity(fazhufuactivity->{
           fazhufuactivity.onbtnclick();
        });
    }

    @Test
    public void onbtn4click() {
    }

    @Test
    public void onbtn3click() {
    }

    @Test
    public void onbtn2click() {
    }

    @Test
    public void onbtn1click() {
    }

    @Test
    public void onuploadclick() {
    }

    @Test
    public void onActivityResult() {
    }

    @Test
    public void stasrtFadeOut() {
    }

    @Test
    public void initDanmaku() {
    }

    @Test
    public void addDanmaku() {
    }

    @Test
    public void initializePlayer() {
    }

    @Test
    public void onBackPressed() {
    }
}