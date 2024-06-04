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
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



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
//        controlFragment.onYxReduceClick();
//        assertEquals(10, controlFragment.getYxvolume());
        controlFragment.onFragment(controlFragment1 -> {
           controlFragment1.onYxReduceClick();
            assertEquals(10, controlFragment1.getYxvolume());
        });
    }
    @Test
    public void onYxAddClick() {

    }
    @Test
    public void onHtReduceClick() {
    }

    @Test
    public void onHtAddClick() {
    }

    @Test
    public void initMediaPlayer() {
    }

    @Test
    public void onResume() {
    }

    @Test
    public void onbtn2Click() {
    }

    @Test
    public void onbtn1Click() {
    }

    @Test
    public void onbtn3Click() {
    }

    @Test
    public void btn4onCheckedChange() {
    }

    @Test
    public void onDestroy() {
    }
}