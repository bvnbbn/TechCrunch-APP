package com.example.vikas.techcrunchapp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.vikas.techcrunchapp.R;
import com.example.vikas.techcrunchapp.adapter.PostsAdapter;

import com.example.vikas.techcrunchapp.model.Posts;
import com.example.vikas.techcrunchapp.model.PostsResponse;
import com.example.vikas.techcrunchapp.rest.ApiClient;
import com.example.vikas.techcrunchapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PostsAdapter.PostAdapterListener {

    private static final String TAG=MainActivity.class.getSimpleName();

    private CoordinatorLayout coordinatorLayout;
    private PostsAdapter movieAdapter;
    private RecyclerView recyclerView;
    private List<Posts> postList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinate_layout);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));



       // recyclerView.setItemAnimator(new DefaultItemAnimator());


        //calling api of posts
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<PostsResponse> call= apiInterface.getNewPosts();
        call.enqueue(new Callback<PostsResponse>()
        {
            @Override
            public void onResponse(Call<PostsResponse> call, Response<PostsResponse> response)
            {

                postList= response.body().getPosts();
                Log.e(TAG, "Number of posts received: " + postList.size());
                recyclerView.setAdapter(new PostsAdapter(postList, R.layout.recycler_item_view_post, getApplicationContext(),MainActivity.this));




            }

            @Override
            public void onFailure(Call<PostsResponse> call, Throwable t)
            {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Please Check your Internet Connection", Snackbar.LENGTH_LONG);

                snackbar.show();
                Log.e(TAG, t.toString());

            }
        });

    }

    @Override
    public void onItemClicked(int position)
    {
        Posts posts = postList.get(position);
        Toast.makeText(getApplicationContext(), "read: "+ posts.getID(), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),SelectedPost.class);
        i.putExtra("post_id",posts.getID());
        startActivity(i);
    }

}



