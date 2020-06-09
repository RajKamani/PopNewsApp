package com.rajkamani.popnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageView img = (ImageView) findViewById(R.id.logo);

        Thread ime = new Thread() {
            @Override
            public void run() {

                try {
                    sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent splaceIntent = new Intent("com.rajkamani.popnews.MAINACTIVITY");
                    startActivity(splaceIntent);
                    finish();
                }
            }
        };
        ime.start();

    }
}