package com.example.ktv_system.gej;

import static org.junit.Assert.*;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.App;
import com.example.ktv_system.dao.GequProduct;
import com.example.ktv_system.dao.GexingProduct;
import com.example.ktv_system.fragment.MusicFragment;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class MusicFragmentTest extends TestCase {

    private FragmentScenario<MusicFragment> fragmentScenario;
    @Before
    public void setUp() throws Exception {
        List<GequProduct> list =new ArrayList<>();
        list.add(new GequProduct("Fortnight","Taylor Swift"));
        App app = (App) ApplicationProvider.getApplicationContext();
        app.setDiangelist(list);
        fragmentScenario = FragmentScenario.launch(MusicFragment.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onViewCreated() {
        fragmentScenario.moveToState(Lifecycle.State.CREATED);
        fragmentScenario.onFragment(musicFragment -> {
           assertEquals("Fortnight",musicFragment.getList().get(0).getMusic_name());
        });
    }

}