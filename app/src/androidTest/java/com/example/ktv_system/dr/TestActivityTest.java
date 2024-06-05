package com.example.ktv_system.dr;

import static org.junit.Assert.*;

import static java.nio.file.Files.exists;

import android.view.MenuItem;

import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.R;
import com.example.ktv_system.TestActivity;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(AndroidJUnit4.class)
public class TestActivityTest extends TestCase {

    private ActivityScenario<TestActivity> activityScenario;
    @Before
    public void setUp() throws Exception {
        activityScenario = ActivityScenario.launch(TestActivity.class);
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void cloneData() {
        activityScenario.onActivity(testactivity->{
            testactivity.cloneData();
            assertNotNull(new File("/data/data/com.example.ktv_system/databases/ktv.db").exists());
        });
    }
}