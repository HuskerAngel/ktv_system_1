package com.example.ktv_system.czy;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.FadanmuActivity;
import com.example.ktv_system.R;
import com.example.ktv_system.fragment.MainFragment;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.RoundingMode;

@RunWith(AndroidJUnit4.class)
public class MainFragmentTest extends TestCase {
    private FragmentScenario<MainFragment> fragmentScenario;
    @Before
    public void setUp() throws Exception {
        fragmentScenario = FragmentScenario.launch(MainFragment.class);
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void onMrgCheckedChange() {
        fragmentScenario.onFragment(mainFragment -> {
            mainFragment.onMrgCheckedChange(mainFragment.getMrg(), R.id.radiobutton1);
            assertEquals(0x00000000,mainFragment.getMgvgequ_mingdan().getVisibility());
            assertEquals(0x00000008,mainFragment.getMlvgexing_mingdan().getVisibility());
            mainFragment.onMrgCheckedChange(mainFragment.getMrg(), R.id.radiobutton2);
            assertEquals(0x00000008,mainFragment.getMgvgequ_mingdan().getVisibility());
            assertEquals(0x00000000,mainFragment.getMlvgexing_mingdan().getVisibility());
        });
    }

    @Test
    public void onMrb2CheckedChange() {
        fragmentScenario.onFragment(mainFragment -> {
            mainFragment.onMrgCheckedChange(mainFragment.getMrg(), R.id.radiobutton1);
            assertEquals(0x00000000,mainFragment.getMgvgequ_mingdan().getVisibility());
            assertEquals(0x00000008,mainFragment.getMlvgexing_mingdan().getVisibility());
        });
    }

    @Test
    public void onMrb1CheckedChange() {
        fragmentScenario.onFragment(mainFragment -> {
            mainFragment.onMrgCheckedChange(mainFragment.getMrg(), R.id.radiobutton2);
            assertEquals(0x00000008,mainFragment.getMgvgequ_mingdan().getVisibility());
            assertEquals(0x00000000,mainFragment.getMlvgexing_mingdan().getVisibility());

        });
    }

}