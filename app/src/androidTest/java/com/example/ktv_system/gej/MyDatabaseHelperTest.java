package com.example.ktv_system.gej;

import static org.junit.Assert.*;

import android.app.Application;
import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.ktv_system.dao.GequProduct;
import com.example.ktv_system.dao.GexingProduct;
import com.example.ktv_system.sqlite.MyDatabaseHelper;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class MyDatabaseHelperTest extends TestCase {
    private MyDatabaseHelper myDatabaseHelper;
    private Context context;

    @Before
    public void setUp() throws Exception {
        context = ApplicationProvider.getApplicationContext();
        myDatabaseHelper = new MyDatabaseHelper(context);
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void getAllGexingProduct() {
        List<GexingProduct> list= myDatabaseHelper.getAllGexingProduct();
        assertNotNull(list);
    }

    @Test
    public void searchGequProduct() {
        assertNotNull(myDatabaseHelper.searchGequProduct("taylor"));
    }
}