package com.example.vikas.techcrunchapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vikas on 29/9/17.
 */

public class Author {

    @SerializedName("ID")
    private int ID;

    @SerializedName("name")
    private String name;

    public Author(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String name) {
        this.name = name;
    }
}
