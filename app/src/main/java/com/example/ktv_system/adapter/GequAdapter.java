package com.example.ktv_system.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.ktv_system.R;
import com.example.ktv_system.dao.GequProduct;
import com.example.ktv_system.dao.GequfenleiProduct;

import java.util.List;

public class GequAdapter extends BaseAdapter {
    private List<GequProduct> list;

    private Context context;

    public GequAdapter(List<GequProduct> list, Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){

            convertView = LayoutInflater.from(context).inflate(R.layout.activity_gequ_liuxing_listview,null);
            viewHolder = new ViewHolder();
            viewHolder.music_name= convertView.findViewById(R.id.gequ_liuxing_listview_geming);
            viewHolder.singer= convertView.findViewById(R.id.gequ_liuxing_listview_geshou);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.music_name.setText(list.get(position).getMusic_name());

        viewHolder.singer.setText(list.get(position).getSinger());
        return convertView;
    }
    class ViewHolder{
        TextView music_name;
        TextView singer;
    }
}
