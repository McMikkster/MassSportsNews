package com.example.masssportsnews;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("P7DszY6smK1VuK6PENz8wEcroXa4as1JrJ0cxYLQ")
                .clientKey("xI01LsgUjcwkidi2pv5lHOj3R8OkaAF57yrPFCzZ")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}