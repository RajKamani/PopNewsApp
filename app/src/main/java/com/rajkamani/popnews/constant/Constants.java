package com.rajkamani.popnews.constant;

public class Constants {

    static final String BaseUrl ="https://newsapi.org/v2/top-headlines?country=in&apiKey=";
    static final String API_KEY="bee53889b04747d19b1ba23ec67e8756";
    public static final String Tech_url="http://newsapi.org/v2/top-headlines?country=in&category=technology&apiKey=bee53889b04747d19b1ba23ec67e8756";
    public  static  final  String business_url="http://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=bee53889b04747d19b1ba23ec67e8756";
    public  static  final  String entertain_url="http://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=bee53889b04747d19b1ba23ec67e8756";
    public  static  final  String health_url="http://newsapi.org/v2/top-headlines?country=in&category=health&apiKey=bee53889b04747d19b1ba23ec67e8756";
    public  static  final  String science_url="http://newsapi.org/v2/top-headlines?country=in&category=science&apiKey=bee53889b04747d19b1ba23ec67e8756";
    public  static  final  String sports_url="http://newsapi.org/v2/top-headlines?country=in&category=sports&apiKey=bee53889b04747d19b1ba23ec67e8756";
    public




    static String getUrl()
     {
         return BaseUrl+API_KEY;
     }
}
