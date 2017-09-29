package com.example.vikas.techcrunchapp.model;

/**
 * Created by vikas on 29/9/17.
 */

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class PostsResponse
{

    @SerializedName("posts")
    private List<Posts> posts;

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public PostsResponse(List<Posts> posts) {

        this.posts = posts;
    }
}

