package com.rajkamani.popnews;

public class Constants {

    static final String BaseUrl ="https://newsapi.org/v2/top-headlines?country=in&apiKey=";
    static final String API_KEY="bee53889b04747d19b1ba23ec67e8756";

    static String getUrl()
     {
         return BaseUrl+API_KEY;
     }
}
