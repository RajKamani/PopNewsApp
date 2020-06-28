package com.rajkamani.popnews;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.github.ybq.android.spinkit.SpinKitView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ApiCall {
    SpinKitView spinKitView;
    String url;
    Context context;
    RecyclerView recyclerView;
    boolean isConnected;


    public ApiCall(String url, Context context, RecyclerView recyclerView, SpinKitView spinKitView) {
        this.url = url;
        this.context = context;
        this.recyclerView = recyclerView;
        this.spinKitView = spinKitView;
    }

    public void apiFetch() {

        spinKitView.setVisibility(View.VISIBLE);


        final ArrayList<Article> articlesList = new ArrayList<>();
        final List<Source> sourcesList = new ArrayList<>();
        RequestQueue queue = VolleySingleton.getInstance(context).getRequestQueue();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
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


                        RecycleAdapter recycleAdapter = new RecycleAdapter(context, articlesList, sourcesList);
                        recyclerView.setAdapter(recycleAdapter);
                        spinKitView.setVisibility(View.INVISIBLE);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(context, "Error In respons", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Thread T = new Thread() {

                    @Override
                    public void run() {
                        while (true) {
                            ConnectivityManager cm =
                                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

                            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                            isConnected = activeNetwork != null &&
                                    activeNetwork.isConnectedOrConnecting();
                            if (isConnected) {
                                apiFetch();
                                break;
                                //Log.e("C","NO InternetConnetion");
                                //  Toast.makeText(context, "No internet Connection", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                };
                T.start();
                    if (!isConnected) {

                        Toast.makeText(context, "No internet Connection", Toast.LENGTH_SHORT).show();
                    }

            }
        });
        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
