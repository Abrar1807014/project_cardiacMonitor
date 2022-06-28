package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    ProgressBar progressBar;
    Timer timer;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar=findViewById(R.id.progressBar);
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(count<100)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                    progressBar.setProgress(count);
                    count++;
                }
                else{
                    timer.cancel();
                    Intent intent=new Intent(Splash.this, login.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 0, 30);
    }
}