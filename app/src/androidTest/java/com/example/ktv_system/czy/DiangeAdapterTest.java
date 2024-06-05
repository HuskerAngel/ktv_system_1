package com.example.ktv_system.czy;

import static org.junit.Assert.*;

import android.content.Context;
import android.widget.Adapter;

import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.RecyclerView;
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
public class DiangeAdapterTest extends TestCase {

    private DiangeAdapter diangeAdapter;
    private List<GequProduct> list;

    private Context context;
    @Before
    public void setUp() throws Exception {
        context = ApplicationProvider.getApplicationContext();
        App app = ApplicationProvider.getApplicationContext();
        list = new ArrayList<>();
        list.add(new GequProduct("天外来物","xuezhiqian"));
        list.add(new GequProduct("丑八怪","xuezhiqian"));
        list.add(new GequProduct("你还要我怎样","xuezhiqian"));
        app.setDiangelist(list);
        diangeAdapter = new DiangeAdapter(list,context);
    }

    @Test
    public void getCount() {
        assertEquals(3,diangeAdapter.getCount());
    }

    @Test
    public void getItem() {
        assertNotNull(diangeAdapter.getItem(0));
    }

    @Test
    public void getItemId() {assertNotNull(diangeAdapter.getItemId(1));}

    @Test
    public void onViewHolderupClick() {
        int position = 1;
        diangeAdapter.OnViewHolderupClick(position);
        App app =ApplicationProvider.getApplicationContext();
        List<GequProduct> updatedList = app.getDiangelist();
        assertEquals("丑八怪", updatedList.get(0).getMusic_name());
        assertEquals("天外来物", updatedList.get(1).getMusic_name());
        assertEquals("你还要我怎样", updatedList.get(2).getMusic_name());
    }

    @Test
    public void onViewHoldercancelClick() {
        App app =ApplicationProvider.getApplicationContext();
        diangeAdapter.OnViewHoldercancelClick(0);
        List<GequProduct> updatedList = app.getDiangelist();
        assertEquals(2, updatedList.size());
        assertEquals("丑八怪", updatedList.get(0).getMusic_name());
        assertEquals("你还要我怎样", updatedList.get(1).getMusic_name());
    }
}