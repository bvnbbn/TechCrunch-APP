package com.example.vikas.techcrunchapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vikas on 30/9/17.
 */

public class SelecetdPost {


    @SerializedName("ID")
    private int ID;
    @SerializedName("site_ID")
    private int site_ID;


    @SerializedName("title")
    private String title;


    @SerializedName("date")
    private String date;


    @SerializedName("content")
    private String content;

    @SerializedName("URL")
    private String URL;

    @SerializedName("excerpt")
    private String excerpt;

    @SerializedName("featured_image")
    private String featured_image;



    public SelecetdPost(int ID, int site_ID, String title, String date, String content, String URL, String excerpt, String featured_image) {

        this.ID = ID;
        this.site_ID = site_ID;
        this.title = title;
        this.date = date;
        this.content = content;
        this.URL = URL;
        this.excerpt = excerpt;
        this.featured_image = featured_image;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSite_ID() {
        return site_ID;
    }

    public void setSite_ID(int site_ID) {
        this.site_ID = site_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getFeatured_image() {
        return featured_image;
    }

    public void setFeatured_image(String featured_image) {
        this.featured_image = featured_image;
    }




}
