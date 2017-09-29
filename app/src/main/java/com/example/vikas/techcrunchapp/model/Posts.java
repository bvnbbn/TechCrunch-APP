package com.example.vikas.techcrunchapp.model;

/**
 * Created by vikas on 29/9/17.
 */
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;


public class Posts {
    @SerializedName("ID")
    private int ID;
    @SerializedName("site_ID")
    private int site_ID;

    @SerializedName("title")
    private String title;


    @SerializedName("URL")
    private String URL;

    @SerializedName("excerpt")
    private String excerpt;

    @SerializedName("featured_image")
    private String featured_image;

  /*  @SerializedName("author")
    private List<Author> author = new ArrayList<>();*/

    public Posts(int ID, int site_ID, String title, String URL, String excerpt, String featured_image) {
        this.ID = ID;
        this.site_ID = site_ID;
        this.title = title;
        this.URL = URL;
        this.excerpt = excerpt;
        this.featured_image = featured_image;
      //  this.author = author;
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

  /*  public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }*/
}