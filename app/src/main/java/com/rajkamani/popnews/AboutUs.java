package com.rajkamani.popnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;


public class AboutUs extends AppCompatActivity {
    Intent intent;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
       Objects.requireNonNull(getSupportActionBar()).setTitle("About Developer");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void LinkLoad(View view) {
        switch (view.getId()) {
            case R.id.Linkin:

                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rajkamani"));
                startActivity(intent);
                break;

            case R.id.github:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RajKamani"));
                startActivity(intent);
                break;
        }
    }
}