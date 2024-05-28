package com.example.ktv_system;

import android.app.Application;

import com.example.ktv_system.dao.GequProduct;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static List<GequProduct> diangelist = new ArrayList<>();

    public List<GequProduct> getDiangelist() {
        return diangelist;
    }

    public void setDiangelist(List<GequProduct> diangelist) {
        this.diangelist = diangelist;
    }
}
