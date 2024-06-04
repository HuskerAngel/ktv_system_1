package com.example.ktv_system.dr;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;


import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import com.example.ktv_system.R;
import com.example.ktv_system.TestActivity;
import com.example.ktv_system.fragment.ControlFragment;
import com.google.android.exoplayer2.C;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;


//@RunWith(JUnit4.class)
@RunWith(AndroidJUnit4.class)
public class ControlFragmentTest  {
//    private ControlFragment controlFragment;

    public FragmentScenario<ControlFragment> controlFragment;
    private Context context;

    @Before
    public void setUp() throws Exception {
//        context = ApplicationProvider.getApplicationContext();
        controlFragment = FragmentScenario.launch(ControlFragment.class);
//        controlFragment = new ControlFragment();
    }


    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void YxReduce() {
        controlFragment.onFragment(controlFragment1 -> {
           controlFragment1.onYxReduceClick();
            assertEquals(10, controlFragment1.getYxvolume());
        });
    }
    @Test
    public void onYxAddClick() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.onYxAddClick();
            assertEquals(30,controlFragment1.getYxvolume());
        });
    }
    @Test
    public void onHtReduceClick() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.onHtReduceClick();
            assertEquals(10,controlFragment1.getHtvolume());
        });
    }

    @Test
    public void onHtAddClick() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.onHtAddClick();
            assertEquals(30,controlFragment1.getHtvolume());
        });
    }

    @Test
    public void initMediaPlayer() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.initMediaPlayer();
            assertNotNull(controlFragment1.getSeekBar().getMax());
            assertNotNull(controlFragment1.getMusicCur().toString());
            assertNotNull(controlFragment1.getMusicLength().toString());

        });
    }

    @Test
    public void onResume() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.onResume();
            assertFalse(controlFragment1.getBtn4().isChecked());
            assertEquals("暂无播放歌曲",controlFragment1.getMtvmusicing().getText().toString());
            assertEquals(0x00000004,controlFragment1.getSeekBar().getVisibility());

        });
    }

    @Test
    public void onbtn2Click() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.onbtn2Click();
            assertFalse(controlFragment1.getBtn4().isChecked());
            assertEquals("暂无播放歌曲",controlFragment1.getMtvmusicing().getText().toString());
            assertEquals(0x00000004,controlFragment1.getSeekBar().getVisibility());

        });
    }

    @Test
    public void onbtn1Click() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.onbtn1Click();
            assertFalse(controlFragment1.getBtn4().isChecked());
            assertEquals("暂无播放歌曲",controlFragment1.getMtvmusicing().getText().toString());
            assertEquals(0x00000004,controlFragment1.getSeekBar().getVisibility());

        });
    }

    @Test
    public void onbtn3Click() {
        controlFragment.onFragment(controlFragment1 -> {
            controlFragment1.onbtn3Click();
            assertFalse(controlFragment1.getBtn4().isChecked());
            assertEquals("暂无播放歌曲",controlFragment1.getMtvmusicing().getText().toString());
            assertEquals(0x00000004,controlFragment1.getSeekBar().getVisibility());

        });
    }

    @Test
    public void btn4onCheckedChange() {
        controlFragment.onFragment(controlFragment1 -> {
            CompoundButton compoundButton = controlFragment1.getBtn4();
            controlFragment1.btn4onCheckedChange(compoundButton,false);
            assertFalse(controlFragment1.getMediaPlayer().isPlaying());
        });
    }
}