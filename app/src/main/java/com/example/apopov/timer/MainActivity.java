package com.example.apopov.timer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.apopov.timer.src.view.activity.CircularSeekBar;
import com.example.apopov.timer.src.view.activity.CircularSeekBar.OnCircularSeekBarChangeListener;

public class MainActivity extends AppCompatActivity implements OnCircularSeekBarChangeListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CircularSeekBar seekbar = (CircularSeekBar) findViewById(R.id.circularSeekBar);
        seekbar.getProgress();
        seekbar.setProgress(0);
    }

    @Override
    public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
    }

    @Override
    public void onStopTrackingTouch(CircularSeekBar seekBar) {
    }

    @Override
    public void onStartTrackingTouch(CircularSeekBar seekBar) {
    }



}
