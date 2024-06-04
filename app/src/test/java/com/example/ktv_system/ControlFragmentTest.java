package com.example.ktv_system;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import com.example.ktv_system.fragment.ControlFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

//@RunWith(JUnit4.class)
@RunWith(RobolectricTestRunner.class)
public class ControlFragmentTest {
    private ControlFragment controlFragment;

//    public FragmentScenario<ControlFragment> controlFragment;
    private Context context;

    @Before
    public void setUp() throws Exception {
//        context = ApplicationProvider.getApplicationContext();
//        controlFragment = FragmentScenario.launchInContainer(ControlFragment.class);
//        controlFragment = FragmentScenario.launchInContainer(ControlFragment.class);
        controlFragment = new ControlFragment();
    }


    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void YxReduce() {
        controlFragment.onYxReduceClick();
        assertEquals(10, controlFragment.getYxvolume());
//        controlFragment.onFragment(controlFragment1 -> {
//           controlFragment1.onYxReduceClick();
//            assertEquals(10, controlFragment1.getYxvolume());
//        });
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