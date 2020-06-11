package com.rajkamani.popnews;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.widget.Toolbar;

import com.github.ybq.android.spinkit.SpinKitView;

import java.util.Objects;


public class AboutArticleDetail extends OnOptionMenuCreated {
    WebView webView;
    Toolbar toolbar;
    SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_article_detail);
        webView = findViewById(R.id.webview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spinKitView = findViewById(R.id.spin_kit2);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Detail Article");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        webView.setVisibility(View.INVISIBLE);
        String url = getIntent().getStringExtra("Url");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                spinKitView.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);

            }
        });
        webView.loadUrl(url);

    }
}