package com.example.timers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("info",String.valueOf(millisUntilFinished/100));

            }

            @Override
            public void onFinish() {
                Log.i("we are done", "done");

            }


        }.start();
       /*final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("Info","one second passed!!!");
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);
      */
    }
}
