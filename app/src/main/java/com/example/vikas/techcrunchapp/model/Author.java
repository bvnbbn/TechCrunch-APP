package com.example.vikas.techcrunchapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vikas on 29/9/17.
 */

public class Author {

    @SerializedName("ID")
    private int ID;

    @SerializedName("name")
    private String title;

    public Author(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
