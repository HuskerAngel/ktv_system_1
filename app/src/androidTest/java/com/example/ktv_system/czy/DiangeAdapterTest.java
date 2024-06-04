package com.example.ktv_system.czy;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.adapter.DiangeAdapter;
import com.example.ktv_system.dao.GequProduct;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
@RunWith(AndroidJUnit4.class)
public class DiangeAdapterTest extends TestCase {

    private DiangeAdapter diangeAdapter;
    private List<GequProduct> list;

    private Context context;
    @Before
    public void setUp() throws Exception {
        context = ApplicationProvider.getApplicationContext();
        list = new ArrayList<>();
        list.add(new GequProduct("天外来物","xuezhiqian"));
        diangeAdapter = new DiangeAdapter(list,context);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCount() {
        assertEquals(1,diangeAdapter.getCount());
    }

    @Test
    public void getItem() {
    }

    @Test
    public void getItemId() {
    }

    @Test
    public void getView() {
    }

    @Test
    public void onViewHolderupClick() {
    }

    @Test
    public void onViewHoldercancelClick() {
    }
}