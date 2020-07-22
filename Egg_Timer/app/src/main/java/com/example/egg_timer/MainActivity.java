package com.example.egg_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timerTextView;
    SeekBar timerSeekBar;
    Boolean counterisActive = false;
    Button goButton;
    CountDownTimer countDownTimer;
    public void resetTimer(){
        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("GO!");
        counterisActive=false;

    }

    public void buttonPressed(View view){
        if (counterisActive){
            resetTimer();
        }
        else{
        counterisActive=true;
        timerSeekBar.setEnabled(false);
        goButton.setText("STOP!");
            countDownTimer = new CountDownTimer(timerSeekBar.getProgress()*1000+100,1000) {
            @Override
            public void onTick(long l) {
                updateTimer((int)l/1000);
            }

            @Override
            public void onFinish() {
                MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                mplayer.start();
                resetTimer();
            }
        }.start();
    }}
    public void updateTimer(int secondsleft){
        int minutes = secondsleft/60;
        int seconds = secondsleft-(minutes*60);

        String secondString =Integer.toString(seconds);
        if(seconds<=9){
            secondString="0"+secondString;
        }
        timerTextView.setText(Integer.toString(minutes)+":"+secondString);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerSeekBar = findViewById(R.id.TimerSeekBar);
        timerTextView = findViewById(R.id.TimerTextView);
        goButton = findViewById(R.id.button);

        timerSeekBar.setProgress(30);
        timerSeekBar.setMax(600);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
