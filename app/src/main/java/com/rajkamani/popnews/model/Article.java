package com.rajkamani.popnews.model;

public class Article {
    String Author;
    String Title;
    String Description;
    String urlToArticle;
    String urlToImage;
    String PublishedAt;

    public Article() {
    }

    public Article(String Author, String Title, String Description, String urlToArticle, String urlToImage, String PublishedAt) {
        this.Author = Author;
        this.Title = Title;
        this.Description = Description;
        this.urlToArticle = urlToArticle;
        this.urlToImage = urlToImage;
        this.PublishedAt = PublishedAt;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrlToArticle() {
        return urlToArticle;
    }

    public void setUrlToArticle(String urlToArticle) {
        this.urlToArticle = urlToArticle;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return PublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        PublishedAt = publishedAt;
    }
}
