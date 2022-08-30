package com.ander.mystagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class MyStagramApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("JwmyBRR3btaolZhRwZi1UC8hk7uVx2zlqsjvQeWk")
                .clientKey("nlyj3Fn2QrlwdxVBROr98NrLhXgn31wtjF82E61Y")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
