package com.ander.mystagram;

import android.app.Application;

import com.parse.Parse;

public class MyStagramApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("WIdGgiLi2Odb5DpfyfiBhWWStuozMdQsl619AV9j")
                .clientKey("InCCGuM7Y6I0Opmv2u5SarGZcsx9riYfuKSHDWpI")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
