package com.example.ktv_system.dao;

public class GequProduct {
    String music_name;

    String singer;

    public GequProduct(String music_name, String singer) {
        this.music_name = music_name;
        this.singer = singer;
    }

    public String getMusic_name() {
        return music_name;
    }

    public String getSinger() {
        return singer;
    }
}
