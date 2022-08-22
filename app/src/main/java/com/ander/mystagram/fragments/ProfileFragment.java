package com.ander.mystagram.fragments;

import android.util.Log;

import com.ander.mystagram.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends FeedFragment{

    @Override
    protected void queryPosts() {
        super.queryPosts();
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_UPDATED_AT);
        // Specify the object id
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e !=null){
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                } for (Post post : posts) {
                    Log.i(TAG, "Post: "+ post.getDescription() + ", username: " + post.getUser().getUsername());
                }
                postList.addAll(posts);
                adapter.notifyDataSetChanged();

            }
        });
    }
}
