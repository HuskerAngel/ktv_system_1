package com.example.ktv_system.czy;

import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.FadanmuActivity;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FadanmuActivityTest extends TestCase {

    private ActivityScenario<FadanmuActivity> activityScenario;
    @Before
    public void setUp() throws Exception {
        activityScenario = ActivityScenario.launch(FadanmuActivity.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreate() {
    }

    @Test
    public void onBtnClick() {
    }

    @Test
    public void onBtn4Click() {
    }

    @Test
    public void onBtn3Click() {
    }

    @Test
    public void onBtn2Click() {
    }

    @Test
    public void onBtn1Click() {
        activityScenario.onActivity(fadanmuactivity->{
           fadanmuactivity.onBtn1Click();
           assertEquals("狂击6666",fadanmuactivity.getEditText().getText().toString());
        });
    }

    @Test
    public void addDanmaku() {
    }
}