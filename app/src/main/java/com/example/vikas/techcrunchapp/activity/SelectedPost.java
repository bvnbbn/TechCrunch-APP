package com.example.vikas.techcrunchapp.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.vikas.techcrunchapp.R;
import com.example.vikas.techcrunchapp.model.SelecetdPost;
import com.example.vikas.techcrunchapp.rest.ApiClient;
import com.example.vikas.techcrunchapp.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vikas on 30/9/17.
 */

public class SelectedPost extends AppCompatActivity {

    private int post_id;
    private Toolbar mToolbar;
    private String TAG=MainActivity.class.getSimpleName();
    private ImageView selected_post_image;
    private TextView selected_post_title;
    private TextView selected_post_content;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_post);
        selected_post_image =(ImageView)findViewById(R.id.post_image);
        selected_post_title = (TextView)findViewById(R.id.post_title);
        selected_post_content =(TextView)findViewById(R.id.post_content);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        // mToolbar.setTitleTextColor(0xFFFFF);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("TechCrunch");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //function for making collapsing toolbar
        initCollapsingToolbar();

        //retrieving post Id

        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            post_id=extras.getInt("post_id");
        }

        //calling api for  particular post
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        final Call<SelecetdPost>  selectedPostCall = apiInterface.getPostDetails(post_id);

        selectedPostCall.enqueue(new Callback<SelecetdPost>() {
            @Override
            public void onResponse(Call<SelecetdPost> call, Response<SelecetdPost> response) {
                SelecetdPost post_selected = response.body();

                String image_url = post_selected.getFeatured_image();

                if (!TextUtils.isEmpty(image_url)) {
                    Glide.with(getApplicationContext()).load(image_url)
                            .crossFade()
                            .override(700, 300)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(selected_post_image);


                }

                String title = post_selected.getTitle();
                selected_post_title.setText(title);

                String content = post_selected.getContent();
                selected_post_content.setText(content);


            }

            @Override
            public void onFailure(Call<SelecetdPost> call, Throwable t) {

            }

        });
    }


    /*
     Initializing collapsing toolbar
      Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


}
