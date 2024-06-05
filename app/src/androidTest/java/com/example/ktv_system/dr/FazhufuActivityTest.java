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
    public void onbtnclick() {
        activityScenario.onActivity(fazhufuactivity->{
           fazhufuactivity.onbtnclick();
           assertFalse(fazhufuactivity.getBtn1().isChecked());
           assertFalse(fazhufuactivity.getBtn2().isChecked());
           assertFalse(fazhufuactivity.getBtn3().isChecked());
           assertFalse(fazhufuactivity.getBtn4().isChecked());
        });
    }

    @Test
    public void onbtn4click() {
        activityScenario.onActivity(fazhufuactivity->{
            fazhufuactivity.onbtn4click();
            assertFalse(fazhufuactivity.getBtn1().isChecked());
            assertFalse(fazhufuactivity.getBtn2().isChecked());
            assertFalse(fazhufuactivity.getBtn3().isChecked());
            assertEquals("岁月悠悠，又迎新年，祝我们新年快乐，心想事成，步步高升",fazhufuactivity.getEditText().getText().toString());
        });
    }

    @Test
    public void onbtn3click() {
        activityScenario.onActivity(fazhufuactivity->{
            fazhufuactivity.onbtn3click();
            assertFalse(fazhufuactivity.getBtn1().isChecked());
            assertFalse(fazhufuactivity.getBtn2().isChecked());
            assertFalse(fazhufuactivity.getBtn4().isChecked());
            assertEquals("愿我们的爱情如夏日的阳光，温暖而明亮，照亮彼此的生命之路",fazhufuactivity.getEditText().getText().toString());
        });
    }

    @Test
    public void onbtn2click() {
        activityScenario.onActivity(fazhufuactivity->{
            fazhufuactivity.onbtn2click();
            assertFalse(fazhufuactivity.getBtn1().isChecked());
            assertFalse(fazhufuactivity.getBtn3().isChecked());
            assertFalse(fazhufuactivity.getBtn4().isChecked());
            assertEquals("愿我们的友情地久天长",fazhufuactivity.getEditText().getText().toString());
        });
    }

    @Test
    public void onbtn1click() {
        activityScenario.onActivity(fazhufuactivity->{
            fazhufuactivity.onbtn1click();
            assertFalse(fazhufuactivity.getBtn2().isChecked());
            assertFalse(fazhufuactivity.getBtn3().isChecked());
            assertFalse(fazhufuactivity.getBtn4().isChecked());
            assertEquals("祝你生日快乐",fazhufuactivity.getEditText().getText().toString());
        });
    }
}