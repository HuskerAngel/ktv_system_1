package com.example.ktv_system.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.ktv_system.App;
import com.example.ktv_system.FadanmuActivity;
import com.example.ktv_system.R;
import com.example.ktv_system.dao.GequProduct;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ControlFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ControlFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button ht_add,ht_reduce,btn1,btn2,btn3,btn4,yx_add,yx_reduce;
    private ProgressBar mprogressBar;
    private AlertDialog alertDialog1,alertDialog2;
    private View mview;
    private static  int htvolume = 10;
    private static  int yxvolume = 10;
    private static boolean yuanchangbanchang = true;
    private TextView mtvmusicing;





    public ControlFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ControlFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ControlFragment newInstance(String param1, String param2) {
        ControlFragment fragment = new ControlFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        ht_add=view.findViewById(R.id.huantong_add);
        ht_reduce=view.findViewById(R.id.huantong_reduce);
        yx_add=view.findViewById(R.id.yinxiang_add);
        yx_reduce=view.findViewById(R.id.yinxiang_reduce);
        btn1=view.findViewById(R.id.btn1);
        btn2=view.findViewById(R.id.btn2);
        btn3=view.findViewById(R.id.btn3);
        btn4=view.findViewById(R.id.btn4);
        mtvmusicing = view.findViewById(R.id.control_text);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yuanchangbanchang){
                    yuanchangbanchang=false;
                    Toast.makeText(getContext(), "已切换为伴唱模式", Toast.LENGTH_SHORT).show();
                }else{
                    yuanchangbanchang=true;
                    Toast.makeText(getContext(), "已切换为原唱模式", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App app = (App)getContext().getApplicationContext();
                List<GequProduct> templist = app.getDiangelist();
                templist.remove(0);
                app.setDiangelist(templist);
                if(templist.size()!=0){
                    mtvmusicing.setText(templist.get(0).getMusic_name());
                }else{
                    mtvmusicing.setText("暂无播放歌曲");
                }
            }
        });
        ht_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao1,null);
                mprogressBar = mview.findViewById(R.id.progress1);
                int curProgress = mprogressBar.getProgress();
                if(htvolume<100 && htvolume>=0){
                    htvolume+=10;
                    mprogressBar.setProgress(htvolume);
                }else if(htvolume>=100){
                    mprogressBar.setProgress(htvolume);
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(mview);
                alertDialog1 = builder.create();
                alertDialog1.show();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (alertDialog1.isShowing()){
                            alertDialog1.dismiss();
                        }
                    }
                },500);
            }
        });

        ht_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao1,null);
                mprogressBar = mview.findViewById(R.id.progress1);
                int curProgress = mprogressBar.getProgress();
                if(htvolume<=100 && htvolume>0){
                    htvolume-=10;
                    mprogressBar.setProgress(htvolume);
                }else if(htvolume<=0){
                    mprogressBar.setProgress(htvolume);
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(mview);
                alertDialog1 = builder.create();
                alertDialog1.show();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (alertDialog1.isShowing()){
                            alertDialog1.dismiss();
                        }
                    }
                },500);
            }
        });

        yx_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao2,null);
                mprogressBar = mview.findViewById(R.id.progress2);
                int curProgress = mprogressBar.getProgress();
                if(yxvolume<100 && yxvolume>=0){
                    yxvolume+=10;
                    mprogressBar.setProgress(yxvolume);
                }else if(yxvolume>=100){
                    mprogressBar.setProgress(yxvolume);
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(mview);
                alertDialog2 = builder.create();
                alertDialog2.show();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (alertDialog2.isShowing()){
                            alertDialog2.dismiss();
                        }
                    }
                },500);
            }

        });

        yx_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao2,null);
                mprogressBar = mview.findViewById(R.id.progress2);
                int curProgress = mprogressBar.getProgress();
                if(yxvolume<=100 && yxvolume>0){
                    yxvolume-=10;
                    mprogressBar.setProgress(yxvolume);
                }else if(yxvolume<=0){
                    mprogressBar.setProgress(yxvolume);
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(mview);
                alertDialog2 = builder.create();
                alertDialog2.show();

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (alertDialog2.isShowing()){
                            alertDialog2.dismiss();
                        }
                    }
                },500);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        App app = (App)getContext().getApplicationContext();
        List<GequProduct> templist = app.getDiangelist();
        if(templist.size()!=0){
            mtvmusicing.setText(templist.get(0).getMusic_name());
        }else{
            mtvmusicing.setText("暂无播放歌曲");
        }
    }
}