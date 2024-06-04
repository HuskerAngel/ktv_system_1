package com.example.ktv_system.fragment;

import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.app.Service;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.ktv_system.App;
import com.example.ktv_system.FadanmuActivity;
import com.example.ktv_system.R;
import com.example.ktv_system.TestActivity;
import com.example.ktv_system.dao.GequProduct;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
    private Button ht_add,ht_reduce,btn1,btn2,btn3,yx_add,yx_reduce;
    private CheckBox btn4;
    private ProgressBar mprogressBar;
    private AlertDialog alertDialog1,alertDialog2;
    private View mview;
    private static  int htvolume = 20;
    private static  int yxvolume = 20;
    private static boolean yuanchangbanchang = true;
    private TextView mtvmusicing;
    private SeekBar seekBar;
    private TextView musicLength,musicCur;
    private Timer timer;
    private boolean isSeekBarChanging;//互斥变量，防止进度条与定时器冲突。
    private int currentPosition;//当前音乐播放的进度
    SimpleDateFormat format;

    private AudioManager audioManager;

    private boolean checked;

    private MediaPlayer mediaPlayer;
    App app;
    private LinearLayout linearLayout;

    public static int getHtvolume() {
        return htvolume;
    }

    public static int getYxvolume() {
        return yxvolume;
    }

    public static void setHtvolume(int htvolume) {
        ControlFragment.htvolume = htvolume;
    }

    public static void setYxvolume(int yxvolume) {
        ControlFragment.yxvolume = yxvolume;
    }

    public View getMview() {
        return mview;
    }

    public void setMview(View mview) {
        this.mview = mview;
    }

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
        btn3=view.findViewById(R.id.bnt3);
        btn4=view.findViewById(R.id.btn4);
        mtvmusicing = view.findViewById(R.id.control_text);
        musicLength = view.findViewById(R.id.music_length);
        musicCur = view.findViewById(R.id.music_cur);

        linearLayout = view.findViewById(R.id.time);
        seekBar = view.findViewById(R.id.seekbar);
        App app = (App) getContext().getApplicationContext();
        mediaPlayer = app.getMediaPlayer();

        audioManager = (AudioManager) getContext().getSystemService(Service.AUDIO_SERVICE);
        format = new SimpleDateFormat("mm:ss");

        initMediaPlayer();
        ht_add.setOnClickListener(v -> onHtAddClick());
        ht_reduce.setOnClickListener(v -> onHtReduceClick());
        yx_add.setOnClickListener(v -> onYxAddClick());
        yx_reduce.setOnClickListener(v -> onYxReduceClick());
    }

    public void YxReduce(){
        if(yxvolume<=100 && yxvolume>0){
            yxvolume-=10;
        }else if(yxvolume<=0){
        }

    }
    public void onYxReduceClick() {
        mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao2,null);
        mprogressBar = mview.findViewById(R.id.progress2);
        int curProgress = mprogressBar.getProgress();
        YxReduce();
        mprogressBar.setProgress(yxvolume);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.dialog);
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

    public void onYxAddClick() {
        mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao2,null);
        mprogressBar = mview.findViewById(R.id.progress2);
        int curProgress = mprogressBar.getProgress();
        if(yxvolume<100 && yxvolume>=0){
            yxvolume+=10;
            mprogressBar.setProgress(yxvolume);
        }else if(yxvolume>=100){
            mprogressBar.setProgress(yxvolume);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.dialog);
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

    public void onHtReduceClick() {
        mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao1,null);
        mprogressBar = mview.findViewById(R.id.progress1);
        int curProgress = mprogressBar.getProgress();
        if(htvolume<=100 && htvolume>0){
            htvolume-=10;
            mprogressBar.setProgress(htvolume);
        }else if(htvolume<=0){
            mprogressBar.setProgress(htvolume);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.dialog);
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

    public void onHtAddClick() {
        mview = LayoutInflater.from(getContext()).inflate(R.layout.activity_jindutiao1,null);
        mprogressBar = mview.findViewById(R.id.progress1);
        int curProgress = mprogressBar.getProgress();
        if(htvolume<100 && htvolume>=0){
            htvolume+=10;
            mprogressBar.setProgress(htvolume);
        }else if(htvolume>=100){
            mprogressBar.setProgress(htvolume);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.dialog);
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

    public void initMediaPlayer() {
        try {
            AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.loml);
            mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());//指定音频文件的路径
            mediaPlayer.prepare();//让mediaplayer进入准备状态
//            mediaPlayer.setLooping(true);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    List<GequProduct> templist = app.getDiangelist();
                    if(templist.size()>0) {
                        templist.remove(0);
                        app.setDiangelist(templist);
                        if (templist.size() != 0) {
                            mtvmusicing.setText(templist.get(0).getMusic_name());
                            mediaPlayer.seekTo(0);
                            mediaPlayer.start();
                        } else {
                            mtvmusicing.setText("暂无播放歌曲");
                            seekBar.setVisibility(View.INVISIBLE);
                            linearLayout.setVisibility(View.INVISIBLE);
                            btn4.setChecked(false);
                            currentPosition = 0;
                            btn1.setOnClickListener(null);
                            btn2.setOnClickListener(null);
                            btn3.setOnClickListener(null);
                            btn4.setOnCheckedChangeListener(null);
                        }
                    }

                }
            });
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    seekBar.setMax(mediaPlayer.getDuration());
                    musicLength.setText(format.format(mediaPlayer.getDuration())+"");
                    musicCur.setText("00:00");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        app = (App)getContext().getApplicationContext();
        List<GequProduct> templist = app.getDiangelist();

        if(templist.size()!=0){
            if(mediaPlayer.isPlaying()){
                btn4.setChecked(true);
                timer = new Timer();
                timer.schedule(new TimerTask() {

                    Runnable updateUI = new Runnable() {
                        @Override
                        public void run() {
                            musicCur.setText(format.format(mediaPlayer.getCurrentPosition()) + "");
                        }
                    };

                    @Override
                    public void run() {
                        if (!isSeekBarChanging) {
                            seekBar.setProgress(mediaPlayer.getCurrentPosition());
                            getActivity().runOnUiThread(updateUI);
                        }
                    }
                }, 0, 50);
            }
            mtvmusicing.setText(templist.get(0).getMusic_name());
            initMediaPlayer();
            seekBar.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);

            btn4.setOnCheckedChangeListener(this::btn4onCheckedChange);
            btn3.setOnClickListener(v -> onbtn3Click());
            btn1.setOnClickListener(v -> onbtn1Click());
            btn2.setOnClickListener(v -> onbtn2Click());

        }else{
            mtvmusicing.setText("暂无播放歌曲");
            seekBar.setVisibility(View.INVISIBLE);
            linearLayout.setVisibility(View.INVISIBLE);
            btn4.setChecked(false);
            btn4.setOnCheckedChangeListener(null);
            btn3.setOnClickListener(null);
            btn1.setOnClickListener(null);
            btn2.setOnClickListener(null);
            Toast.makeText(getContext(), "未点歌", Toast.LENGTH_SHORT).show();
        }
    }

    public void onbtn2Click() {
        App app = (App) getContext().getApplicationContext();
        List<GequProduct> templist = app.getDiangelist();
        if(templist.size()>0) {
            templist.remove(0);
            app.setDiangelist(templist);
            if (templist.size() != 0) {
                mtvmusicing.setText(templist.get(0).getMusic_name());
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
                btn4.setChecked(true);
            } else {
                mtvmusicing.setText("暂无播放歌曲");
                seekBar.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.INVISIBLE);
                btn4.setChecked(false);
                currentPosition = 0;
                btn1.setOnClickListener(null);
                btn2.setOnClickListener(null);
                btn3.setOnClickListener(null);
                btn4.setOnCheckedChangeListener(null);
            }
        }
    }

    public void onbtn1Click() {
        if (yuanchangbanchang) {
            yuanchangbanchang = false;
            Toast.makeText(getContext(), "已切换为伴唱模式", Toast.LENGTH_SHORT).show();
        } else {
            yuanchangbanchang = true;
            Toast.makeText(getContext(), "已切换为原唱模式", Toast.LENGTH_SHORT).show();
        }
    }

    public void onbtn3Click() {
        currentPosition = 0;

        mediaPlayer.seekTo(currentPosition);

        //监听播放时回调函数
        timer = new Timer();
        timer.schedule(new TimerTask() {

            Runnable updateUI = new Runnable() {
                @Override
                public void run() {
                    musicCur.setText(format.format(mediaPlayer.getCurrentPosition()) + "");
                }
            };

            @Override
            public void run() {
                if (!isSeekBarChanging) {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    getActivity().runOnUiThread(updateUI);
                }
            }
        }, 0, 50);
    }

    public void btn4onCheckedChange(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();//开始播放
                mediaPlayer.seekTo(currentPosition);

                //监听播放时回调函数
                timer = new Timer();
                timer.schedule(new TimerTask() {

                    Runnable updateUI = new Runnable() {
                        @Override
                        public void run() {
                            musicCur.setText(format.format(mediaPlayer.getCurrentPosition()) + "");
                        }
                    };

                    @Override
                    public void run() {
                        if (!isSeekBarChanging) {
                            seekBar.setProgress(mediaPlayer.getCurrentPosition());
                            getActivity().runOnUiThread(updateUI);
                        }
                    }
                }, 0, 50);
            }
        } else {
            if (mediaPlayer.isPlaying()) {
                currentPosition = mediaPlayer.getCurrentPosition();
                mediaPlayer.pause();//暂停播放
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        isSeekBarChanging = true;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (timer != null){
            timer.cancel();
            timer = null;
        }
    }


}