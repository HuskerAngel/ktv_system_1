package com.example.ktv_system;

import android.app.Application;
import android.media.MediaPlayer;

import com.example.ktv_system.dao.GequProduct;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static List<GequProduct> diangelist = new ArrayList<>();

    private static MediaPlayer mediaPlayer = new MediaPlayer();
    private static int currentPosition = 0;

    public static int getCurrentPosition() {
        return currentPosition;
    }
    public  void setCurrentPosition(int currentPosition) {
        App.currentPosition = currentPosition;
    }

    public List<GequProduct> getDiangelist() {
        return diangelist;
    }

    public void setDiangelist(List<GequProduct> diangelist) {
        this.diangelist = diangelist;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}
