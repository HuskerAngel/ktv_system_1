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
    public void onBtn4Click() {
        activityScenario.onActivity(fadanmuactivity->{
            fadanmuactivity.onBtn4Click();
            assertEquals("想要的都拥有，得不到的都释怀。生日快乐",fadanmuactivity.getEditText().getText().toString());
        });
    }

    @Test
    public void onBtn3Click() {
        activityScenario.onActivity(fadanmuactivity->{
            fadanmuactivity.onBtn3Click();
            assertEquals("有毛病呀，唱这么好听干嘛",fadanmuactivity.getEditText().getText().toString());
        });
    }

    @Test
    public void onBtn2Click() {
        activityScenario.onActivity(fadanmuactivity->{
            fadanmuactivity.onBtn2Click();
            assertEquals("听你的歌，真的需要勇气",fadanmuactivity.getEditText().getText().toString());
        });
    }


    @Test
    public void onBtn1Click() {
        activityScenario.onActivity(fadanmuactivity->{
           fadanmuactivity.onBtn1Click();
           assertEquals("狂击6666",fadanmuactivity.getEditText().getText().toString());
        });
    }


}