package com.example.ktv_system.dr;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

//@RunWith(JUnit4.class)
@RunWith(RobolectricTestRunner.class)
public class ControlFragmentTest  {

//    @Mock
//    Context mockContext;
//    @Mock
//    LayoutInflater mockInflater;
//    @Mock
//    View mockView;
//    @Mock
//    ProgressBar mockProgressBar;
//    @Mock
//    AlertDialog.Builder mockBuilder;
//    @Mock
//    AlertDialog mockAlertDialog;
    @Mock
    private ControlFragment controlFragment;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void YxReduce() {
        doCallRealMethod().when(controlFragment).onYxReduceClick();
// Set up the progress bar
//        when(mockProgressBar.getProgress()).thenReturn(50); // Example progress value
//
//        // Call the method
//        controlFragment.onYxReduceClick();
//
//        // Verify YxReduce method is called
//        verify(controlFragment).YxReduce();
//
//        // Verify progress bar is set
//        verify(mockProgressBar).setProgress(anyInt());
//
//        // Verify AlertDialog is created and shown
//        verify(mockBuilder).setView(mockView);
//        verify(mockBuilder).create();
//        verify(mockAlertDialog).show();
//
//        // Verify dismiss after 500ms
//        verify(mockAlertDialog).dismiss();

        doCallRealMethod().when(controlFragment).YxReduce();
        // 执行点击操作
        controlFragment.YxReduce();
        System.out.println(controlFragment.getYxvolume());
        // 验证yxvolume的变化
        assertEquals(10, controlFragment.getYxvolume());
        // 验证ProgressBar的进度
        /*ProgressBar progressBar = controlFragment.getMview().findViewById(R.id.progress2);
        assertNotNull(progressBar);
        assertEquals(40, progressBar.getProgress());*/
    }
    @Test
    public void onYxAddClick() {
        doCallRealMethod().when(controlFragment).onYxAddClick();

        controlFragment.onYxAddClick();
        assertEquals(30,controlFragment.getYxvolume());
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