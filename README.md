# PopNewsApp

Hello friends,<br>
I have created a very Basic News App. which fetch data from API. 

<h2>Screenshot </h2>

<img src="https://user-images.githubusercontent.com/35796349/85946186-29f2d300-b960-11ea-9313-89432c388e6f.jpg" width="300" eight="550"/><span><img src="https://user-images.githubusercontent.com/35796349/85946187-2cedc380-b960-11ea-818e-4be013629f95.jpg" width="300" eight="550"/></span>

<b>further details as follow : </b>

<h2>API Used </h2>
 https://newsapi.org/
 <p> If You want to create your app like i have created then you must find news API from above link and generate a Key.
<br> After Getting your key You must have to place key in<b> Constants.java </b> file.<p>
   
    static final String BaseUrl ="https://newsapi.org/v2/top-headlines?country=in&apiKey=";
    static final String API_KEY="Your Api key goes here";

<h2>Network Library Used</h2>
  <b>Volley Library</b> here: https://developer.android.com/training/volley<br>
  In this project there is one file where volley Library is used.<br> <b>file Path : PopNewsApp/app/src/main/java/com/rajkamani/popnews/apicall/ApiCall.java </b>
   
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
  
<h2>Other Details</h2>
<p> For display news I have Used Cardview With RecyclerView and you can find recyclerview Adapter <b> here : RecycleAdapter.java file</b> under Adapter folder.</p>
<p> For display multiple category i have used TabLayout and fragments <b>You can find all 7 Fragments in Fragment folder.</b> <br>And Adapter for fragments with tablayout in Adapter Folder <b>PagerAdapter.java</b></p>
