package com.rajkamani.popnews;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.tabs.TabLayout;

//import com.github.ybq.android.spinkit.SpinKitView;

public class MainActivity extends OnOptionMenuCreated {
   /* RecyclerView recyclerView;
    ArrayList<Article> articlesList;
    List<Source> sourcesList = new ArrayList<>();
    RequestQueue requestQueue;
   // SpinKitView spinKitView;*/

   TabLayout tabLayout;
   ViewPager viewPager;
   PagerAdapter PagerAdapter;
   Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

      /* recyclerView = findViewById(R.id.recycleView);
        spinKitView = findViewById(R.id.spin_kit);
        articlesList = new ArrayList<>();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        apiFetch();*/

        PagerAdapter sectionsPagerAdapter = new PagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }

}

    /*private void apiFetch() {
        //spinKitView.setVisibility(View.VISIBLE);
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
                       // spinKitView.setVisibility(View.GONE);


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
    }*/

   /* @Override
    protected void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll(Constants.getUrl());
        }

    }*/
