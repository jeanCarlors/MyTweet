package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

/**
 * Created by Rony BIEN-AIME on 2/25/2018.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{

    private List<Tweet> mTweets;
    Context context;
    private TweetAdapterListener mListener;

    public interface TweetAdapterListener{
        public void onItemSelected(View view, int position);
    }


    public TweetAdapter(List<Tweet> tweets, TweetAdapterListener listener){
        mTweets=tweets;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        View tweetView=inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder=new ViewHolder(tweetView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Tweet tweet=mTweets.get(position);

       holder.tvUsername.setText(tweet.user.name);
       holder.tvBody.setText(tweet.body);
       Glide.with(context).load(tweet.user.profileImageUrl).into(holder.ivProfileImage);
    }

    @Override
    public int getItemCount() {return mTweets.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivProfileImage;
        public TextView tvUsername;
        public TextView tvBody;

        public ViewHolder(View itemView){
            super(itemView);
            ivProfileImage=(ImageView) itemView.findViewById(R.id.ivProfileImage);
            tvUsername=(TextView) itemView.findViewById(R.id.tvUserName);
            tvBody=(TextView) itemView.findViewById(R.id.tvBody);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                   if(mListener != null){
                       int position = getAdapterPosition();
                       mListener.onItemSelected(view, position);
                   }
                }
            });
        }
    }
}
