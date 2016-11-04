package client.hatwo.mx.hatwoclient.gui;

/**
 * Created by Pattyntel on 01/11/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import client.hatwo.mx.hatwoclient.R;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplash extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private boolean mbActive;
    private static final int SPLASH_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//Con Progress Bar y Timer
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Intent mainIntent = new Intent().setClass(ActivitySplash.this, ActivityMain.class);
                // startActivity(mainIntent);
                Intent intent = new Intent(ActivitySplash.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_TIME);
    }
}