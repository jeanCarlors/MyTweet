package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rony BIEN-AIME on 2/25/2018.
 */

public class User {
    public String name;
    public long uid;
    public String screenName;
    public String profileImageUrl;

    public String tagLine;
    public int followersCount;
    public int followingCount;

    public static User fromJSON(JSONObject json) throws JSONException{
        User user=new User();
        user.name=json.getString("name");
        user.uid=json.getLong("id");
        user.screenName=json.getString("screen_name");
        user.profileImageUrl=json.getString("profile_image_url");

        user.tagLine = json.getString("description");
        user.followersCount = json.getInt("followers_count");
        user.followingCount = json.getInt("friends_count");
        return user;

    }
}
