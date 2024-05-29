package com.example.ktv_system.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.ktv_system.App;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        Mylistener mylistener = null;
        if(convertView == null){
            mylistener = new Mylistener(position);
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_gequ_liuxing_listview,null);
            viewHolder = new ViewHolder();

            viewHolder.music_name= convertView.findViewById(R.id.gequ_liuxing_listview_geming);
            viewHolder.singer= convertView.findViewById(R.id.gequ_liuxing_listview_geshou);
            viewHolder.diange= convertView.findViewById(R.id.gequ_liuxing_listview_diange);
            convertView.setTag(viewHolder);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.music_name.setText(list.get(position).getMusic_name());

        viewHolder.singer.setText(list.get(position).getSinger());

        viewHolder.diange.setOnClickListener(null);
//        viewHolder.diange.setOnClickListener(mylistener);
        viewHolder.diange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).getMusic_name(), Toast.LENGTH_SHORT).show();
                App app = (App) context.getApplicationContext();
                List<GequProduct> templist = app.getDiangelist();
                Log.i("添加前", list.toString());
                templist.add(new GequProduct(list.get(position).getMusic_name(),list.get(position).getSinger()));
                Log.i("添加后", list.toString());
                app.setDiangelist(templist);
            }
        });
        return convertView;
    }

    private class Mylistener implements View.OnClickListener{
        int position;

        public Mylistener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, list.get(position).getMusic_name(), Toast.LENGTH_LONG).show();
            App app = (App) context.getApplicationContext();
            List<GequProduct> templist = app.getDiangelist();
            Log.i("添加前", list.toString());
            templist.add(new GequProduct(list.get(position).getMusic_name(),list.get(position).getSinger()));
            Log.i("添加后", list.toString());
            app.setDiangelist(templist);
        }
    }
    class ViewHolder{
        TextView music_name;
        TextView singer;
        Button diange;
    }
}
