package com.example.apopov.timer;


import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.apopov.timer.methods.Methods;


public class MainActivity extends AppCompatActivity {

    int iProgress=0;
    public static int hours=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CircularSeekBar csbTimerFirst= (CircularSeekBar) findViewById(R.id.csbFirstTimer);
        final TextView tvTimerView = (TextView) findViewById(R.id.tvViewTime);

        csbTimerFirst.setMax(360);

        csbTimerFirst.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                if (csbTimerFirst.getProgress()==360 && iProgress != progress){
                    hours++;
                    iProgress = progress;
                }
                if (csbTimerFirst.getProgress()==0 && hours!=0 && iProgress != progress){
                    hours--;
                    iProgress = progress;
                }
                tvTimerView.setText(String.valueOf(new Methods().StringForTextViewTimer(progress, hours)));
            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }
        });
    }



}
