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

import com.example.ktv_system.GequfenleiProduct;
import com.example.ktv_system.GexingProduct;
import com.example.ktv_system.R;

import java.util.List;

public class GexingAdapter extends BaseAdapter {
    private List<GexingProduct> list;

    private Context context;

    public GexingAdapter(List<GexingProduct> list, Context context) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.activity_gexing_mindan,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView= convertView.findViewById(R.id.gexing_mingdan_imageview);
            viewHolder.title= convertView.findViewById(R.id.gexing_mingdan_textview);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(list.get(position).getImg());

        Bitmap bitmap = BitmapFactory.decodeResource(viewHolder.imageView.getResources(),list.get(position).getImg());
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(viewHolder.imageView.getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        viewHolder.imageView.setImageDrawable(roundedBitmapDrawable);

        viewHolder.title.setText(list.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView title;
    }
}
