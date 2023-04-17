package com.example.wallpero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.MediaController;
import android.widget.VideoView;


public class SplashScreen extends AppCompatActivity {

    VideoView splashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashScreen = findViewById(R.id.splashScreen);
        splashScreen.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.wallpero);
        splashScreen.setSoundEffectsEnabled(false);

        MediaController mediaController = new MediaController(this);
        //link mediaController to videoView
        mediaController.setAnchorView(splashScreen);

        //allow mediaController to control our videoView
        splashScreen.setMediaController(mediaController);
        splashScreen.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }
        },3000);

    }
}