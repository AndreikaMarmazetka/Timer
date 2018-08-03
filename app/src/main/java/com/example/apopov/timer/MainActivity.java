package com.example.apopov.timer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.apopov.timer.methods.ParsingTimeandStringForTime;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;


public  class MainActivity extends AppCompatActivity {

    public CircularSeekBar csbTimerFirst;
    public static TextView tvTimerView;
    public Button bPlayStop;
    private Timer mTimer;
    int iProgress = 0;
    public int hours = 0;
    private ActionTimer actionTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        csbTimerFirst = (CircularSeekBar) findViewById(R.id.csbFirstTimer);
        tvTimerView = (TextView) findViewById(R.id.tvViewTime);
        bPlayStop = (Button) findViewById(R.id.startStop);

        /** Action on CircularSeeKBar and Change wiew CircularSeekBar**/
        csbTimerFirst.setMax(360);
        csbTimerFirst.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
                if (csbTimerFirst.getProgress() == 360 && iProgress != progress) {
                    hours++;

                }
                if (csbTimerFirst.getProgress() == 0 && hours != 0 && iProgress != progress) {
                    hours--;
                    iProgress = progress;
                }
                tvTimerView.setText(String.valueOf(new ParsingTimeandStringForTime().StringForTextViewTimer(progress, hours)));
                iProgress = progress;
            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }
        });

        /** Action on PlayButton**/

        bPlayStop.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimer != null) {
                    mTimer.cancel();
                }
                mTimer = new Timer();
                actionTimer = new ActionTimer();

                Time tTime = new ParsingTimeandStringForTime().parsingTime(tvTimerView.toString());
                long lTime = tTime.getTime() / 1000;
                mTimer.schedule(actionTimer, lTime);

            }
        });
    }
    public class ActionTimer extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    tvTimerView.setText("00:00");
                }
            });

        }
    }

}
