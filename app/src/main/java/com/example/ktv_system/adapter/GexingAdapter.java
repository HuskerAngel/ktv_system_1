package com.example.ktv_system.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import com.example.ktv_system.dao.GexingProduct;
import com.example.ktv_system.R;

import java.io.IOException;
import java.io.InputStream;
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
        Bitmap bitmap = getBitmapFromAssets(list.get(position).getImg());
        if (bitmap!=null){
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(viewHolder.imageView.getResources(),bitmap);
            roundedBitmapDrawable.setCircular(true);
            viewHolder.imageView.setImageDrawable(roundedBitmapDrawable);
        }else{
            Log.e("AssetError", "failed to load image:"+list.get(position).getImg());
            bitmap = getBitmapFromAssets("unknown.png");
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(viewHolder.imageView.getResources(),bitmap);
            roundedBitmapDrawable.setCircular(true);
            viewHolder.imageView.setImageDrawable(roundedBitmapDrawable);
        }
        /*viewHolder.imageView.setImageResource(list.get(position).getImg());
        Bitmap bitmap = BitmapFactory.decodeResource(viewHolder.imageView.getResources(),list.get(position).getImg());
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(viewHolder.imageView.getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        viewHolder.imageView.setImageDrawable(roundedBitmapDrawable);*/
        viewHolder.title.setText(list.get(position).getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView imageView;
        TextView title;
    }

    public Bitmap getBitmapFromAssets(String fileName){
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;
        try{
            inputStream = assetManager.open(fileName);
            return BitmapFactory.decodeStream(inputStream);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
