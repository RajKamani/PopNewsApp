package com.rajkamani.popnews;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends OnOptionMenuCreated {
    RecyclerView recyclerView;
    ArrayList<Article> articlesList;
    List<Source> sourcesList = new ArrayList<>();
    RequestQueue requestQueue;
    SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        spinKitView = findViewById(R.id.spin_kit);
        articlesList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        apiFetch();
    }

    private void apiFetch() {
        spinKitView.setVisibility(View.VISIBLE);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Constants.getUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject ArticleNews = jsonArray.getJSONObject(i);
                        Article article = new Article();
                        String author = ArticleNews.getString("author");
                        String title = ArticleNews.getString("title");
                        String des = ArticleNews.getString("description");
                        String articleUrl = ArticleNews.getString("url");
                        String imageUrl = ArticleNews.getString("urlToImage");
                        String time = ArticleNews.getString("publishedAt");
                        Source source = new Source();
                        JSONObject jsonObjectSource = ArticleNews.getJSONObject("source");
                        String publishername = jsonObjectSource.getString("name");

                        article.setAuthor(author);
                        article.setTitle(title);
                        article.setDescription(des);
                        article.setUrlToArticle(articleUrl);
                        article.setUrlToImage(imageUrl);
                        article.setPublishedAt(time);
                        articlesList.add(article);
                        source.setName(publishername);
                        sourcesList.add(source);
                        RecycleAdapter recycleAdapter = new RecycleAdapter(MainActivity.this, articlesList, sourcesList);
                        recyclerView.setAdapter(recycleAdapter);
                        spinKitView.setVisibility(View.GONE);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error In respons", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage() + "On error", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll(Constants.getUrl());
        }

    }
}