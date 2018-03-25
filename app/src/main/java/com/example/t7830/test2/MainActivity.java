package com.example.t7830.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private RadioGroup radioGroup;
    private ImageView imageView;
    private TextView text;
    private LinearLayout wifi;
    private String year, month, day, hour, minute, second;

    public void getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        year = Integer.toString(calendar.get(Calendar.YEAR));
        month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        day = Integer.toString(calendar.get(Calendar.DATE));
        hour = Integer.toString(calendar.get(Calendar.HOUR));
        minute = Integer.toString(calendar.get(Calendar.MINUTE));
        second = Integer.toString(calendar.get(Calendar.SECOND));

    }

    public void getId() {
        toggleButton = findViewById(R.id.button);
        radioGroup = findViewById(R.id.group);
        imageView = findViewById(R.id.image1);
        text = findViewById(R.id.text1);
        wifi = findViewById(R.id.wifi);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getId();
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifi.setVisibility(View.VISIBLE);
                } else {
                    radioGroup.clearCheck();
                    text.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    wifi.setVisibility(View.INVISIBLE);
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.button1:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.drawable.office);
                        text.setVisibility(View.VISIBLE);
                        getCurrentTime();
                        text.setText("当前时间:" + year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second);
                        break;
                    case R.id.button2:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.drawable.meeting);
                        text.setVisibility(View.VISIBLE);
                        getCurrentTime();
                        text.setText("当前时间:" + year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second);
                        break;
                    case R.id.button3:
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageResource(R.drawable.visitor);
                        text.setVisibility(View.VISIBLE);
                        getCurrentTime();
                        text.setText("当前时间:" + year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second);
                        break;

                }
            }
        });


    }
}
