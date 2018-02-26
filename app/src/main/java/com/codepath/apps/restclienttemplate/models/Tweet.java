package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rony BIEN-AIME on 2/25/2018.
 */

public class Tweet {
    //list out the attributes
    public String body;
    public long uid;//data ID for the tweet
    public User user;
    public String createdAt;

    //deserialize the JSON
    public static  Tweet fromJSON(JSONObject jsonObject) throws JSONException{
        Tweet tweet=new Tweet();

        tweet.body=jsonObject.getString("text");
        tweet.uid=jsonObject.getLong("id");
        tweet.createdAt=jsonObject.getString("created_at");
        tweet.user=User.fromJSON(jsonObject.getJSONObject("user"));
        return tweet;
    }
}
