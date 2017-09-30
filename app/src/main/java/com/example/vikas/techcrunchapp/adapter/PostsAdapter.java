package com.example.vikas.techcrunchapp.adapter;

/**
 * Created by vikas on 29/9/17.
 */

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.vikas.techcrunchapp.R;
import com.example.vikas.techcrunchapp.helper.CircleTransformation;
import com.example.vikas.techcrunchapp.model.Posts;

import java.util.List;

import java.util.List;

import retrofit2.Callback;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder>
{
    private static final String TAG=PostsAdapter.class.getSimpleName();

    private List<Posts> posts;
    private int rowLayout;
    private Context context;
    private PostAdapterListener listener;


    public static class PostsViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout postsLayout;
        TextView postsTitle;
        TextView author;
       // TextView content;


        ImageView imageView;


        public PostsViewHolder(View v)
        {
            super(v);
            postsLayout = (RelativeLayout) v.findViewById(R.id.post_layout);
            postsTitle = (TextView) v.findViewById(R.id.post_title);
            author = (TextView) v.findViewById(R.id.post_author);
            imageView=(ImageView)v.findViewById(R.id.post_image);
            //content=(TextView)v.findViewById(R.id.post_content);
        }

    }

    public PostsAdapter(List<Posts> posts, int rowLayout, Context context,PostAdapterListener listener)
    {
        this.posts = posts;
        this.rowLayout = rowLayout;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public PostsAdapter.PostsViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PostsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PostsViewHolder holder, final int position)
    {
        Posts post= posts.get(position);
        //checking if the android version is nougat or not
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {
            holder.postsTitle.setText(Html.fromHtml(posts.get(position).getTitle(),Html.FROM_HTML_MODE_COMPACT));
        }
        else {
            holder.postsTitle.setText(Html.fromHtml(posts.get(position).getTitle()));
        }
       // holder.content.setText(posts.get(position).getExcerpt());
        MovieImage(holder,post);
        applyClickEvents(holder,position);


    }
    private void applyClickEvents(PostsViewHolder holder,final int position)
    {
        holder.postsLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                listener.onItemClicked(position);
            }
        });


    }


    private void MovieImage(PostsViewHolder holder,Posts post)
    {


        String file_Path=post.getFeatured_image();


        if(!TextUtils.isEmpty(file_Path))
        {
            Glide.with(context).load(file_Path)
                    .thumbnail(0.5f)
                    .crossFade()
                    .transform(new CircleTransformation(context))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//storing all sizes of image
                    .into(holder.imageView);
        }
        else
        {
            holder.imageView.setImageResource(R.drawable.circle);
        }

    }

    public interface PostAdapterListener
    {
        void onItemClicked(int position);

    }


    @Override
    public int getItemCount()
    {
        return posts.size();
    }
}
