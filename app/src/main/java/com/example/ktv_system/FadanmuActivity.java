package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
    }

}