package com.rajkamani.popnews;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.rajkamani.popnews.adapter.PagerAdapter;

public class MainActivity extends OnOptionMenuCreated {


   TabLayout tabLayout;
   ViewPager viewPager;
   com.rajkamani.popnews.adapter.PagerAdapter PagerAdapter;
   Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        PagerAdapter sectionsPagerAdapter = new PagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}

