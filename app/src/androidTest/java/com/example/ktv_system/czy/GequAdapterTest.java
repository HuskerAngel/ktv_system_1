package com.example.ktv_system.czy;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.App;
import com.example.ktv_system.adapter.DiangeAdapter;
import com.example.ktv_system.adapter.GequAdapter;
import com.example.ktv_system.adapter.GexingAdapter;
import com.example.ktv_system.dao.GequProduct;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class GequAdapterTest extends TestCase {
    private GequAdapter gequAdapter;
    private List<GequProduct> list;
    private Context context;

    @Before
    public void setUp() throws Exception {
        context = ApplicationProvider.getApplicationContext();
        App app = ApplicationProvider.getApplicationContext();
        list = new ArrayList<>();
        list.add(new GequProduct("123","123"));
        gequAdapter = new GequAdapter(list,context);
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCount() {assertEquals(1,gequAdapter.getCount());}

    @Test
    public void getItem() {assertNotNull(gequAdapter.getItem(0));}

    @Test
    public void getItemId() {assertNotNull(gequAdapter.getItemId(1));}

    @Test
    public void onViewHolderdiangeClick() {
        App app =ApplicationProvider.getApplicationContext();
        List<GequProduct> updatedList = app.getDiangelist();
        assertEquals("123","123");
    }
}