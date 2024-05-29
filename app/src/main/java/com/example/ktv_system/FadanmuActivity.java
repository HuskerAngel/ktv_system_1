package com.example.ktv_system;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class FadanmuActivity extends AppCompatActivity {

    private VideoView videoView;

    private EditText editText;
    private ToggleButton btn1;
    private ToggleButton btn2;
    private ToggleButton btn3;
    private ToggleButton btn4;
    private Button btn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fadanmu);

        videoView=findViewById(R.id.shiping);
        editText= findViewById(R.id.fandanmu_et);
        btn1=findViewById(R.id.fadanmu_btn1);
        btn2=findViewById(R.id.fandanmu_btn2);
        btn3=findViewById(R.id.fandanmu_btn3);
        btn4=findViewById(R.id.fandanmu_btn4);
        btn=findViewById(R.id.fadanmu_fason);

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                editText.setText("狂击6666~");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                editText.setText("听你的歌，真的需要勇气");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn1.setChecked(false);
                btn4.setChecked(false);
                editText.setText("有毛病呀，唱这么好听干嘛");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn1.setChecked(false);
                editText.setText("想要的都拥有，得不到的都释怀。生日快乐");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn1.setChecked(false);
                btn4.setChecked(false);
                View view = LayoutInflater.from(FadanmuActivity.this).inflate(R.layout.activity_duihuankuan,null);

                AlertDialog.Builder builder=new AlertDialog.Builder(FadanmuActivity.this);//要改view的背景颜色，需要再values加一个styles。(MainActivity2.this,R.style.dialog)通过一个资源文件来得到一个圆角
                builder.setView(view);
                builder.create().show();

            }
        });
    }

}