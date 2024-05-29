package com.example.ktv_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class FazhufuActivity extends AppCompatActivity {

    private VideoView videoView;

    private EditText editText;
    private ToggleButton btn1;
    private ToggleButton btn2;
    private ToggleButton btn3;
    private ToggleButton btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazhufu);

        videoView=findViewById(R.id.shipin);
        editText=findViewById(R.id.fabianzhufu);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                editText.setText("祝你生日快乐");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setChecked(false);
                btn3.setChecked(false);
                btn4.setChecked(false);
                editText.setText("愿我们的友情地久天长");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn1.setChecked(false);
                btn4.setChecked(false);
                editText.setText("愿我们的爱情如夏日的阳光，温暖而明亮，照亮彼此的生命之路");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btn2.setChecked(false);
                btn3.setChecked(false);
                btn1.setChecked(false);
                editText.setText("岁月悠悠，又迎新年，祝我们新年快乐，心想事成，步步高升");
            }
        });

    }
}