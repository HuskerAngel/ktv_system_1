package com.example.ktv_system.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ktv_system.App;
import com.example.ktv_system.R;
import com.example.ktv_system.dao.GequProduct;

import java.util.List;

public class DiangeAdapter extends BaseAdapter {
    private List<GequProduct> list;

    private Context context;

    public DiangeAdapter(List<GequProduct> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.activity_diange_listview,null);
            viewHolder = new ViewHolder();
            viewHolder.music_name= convertView.findViewById(R.id.diange_listview_geming);
            viewHolder.singer= convertView.findViewById(R.id.diange_listview_geshou);
            viewHolder.cancel = convertView.findViewById(R.id.diange_listview_cancle);
            viewHolder.up = convertView.findViewById(R.id.diange_listview_up);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.music_name.setText(list.get(position).getMusic_name());

        viewHolder.singer.setText(list.get(position).getSinger());


        viewHolder.cancel.setOnClickListener(v -> OnViewHoldercancelClick(position));

        viewHolder.up.setOnClickListener(v -> OnViewHolderupClick(position));


        return convertView;
    }

    public void OnViewHolderupClick(int position) {
        App app = (App)context.getApplicationContext();
        List<GequProduct> templist = app.getDiangelist();
        MediaPlayer mediaPlayer = app.getMediaPlayer();
        mediaPlayer.seekTo(0);
        mediaPlayer.start();
        GequProduct gequProduct = templist.remove(position);
        templist.add(0,gequProduct);
        app.setDiangelist(templist);
        notifyDataSetChanged();
    }

    public void OnViewHoldercancelClick(int position) {
        App app = (App)context.getApplicationContext();
        List<GequProduct> templist = app.getDiangelist();
        MediaPlayer mediaPlayer = app.getMediaPlayer();
        if(position==0){
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
        }
        templist.remove(position);
        app.setDiangelist(templist);
        notifyDataSetChanged();
    }

    class ViewHolder{
        TextView music_name;
        TextView singer;

        Button cancel;

        Button up;
    }
}
