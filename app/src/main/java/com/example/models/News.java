package com.example.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class News {
    String title;
    String description;
    String byline;
    String createdDate;

    public News() {}

    public News(JSONObject jsonObject) throws JSONException
    {
        title = jsonObject.getString("title");
        description = jsonObject.getString("abstract");
        byline = jsonObject.getString("byline");
        createdDate = jsonObject.getString("created_date");
    }

    public static List<News> fromJSONArray(JSONArray newsJsonArray) throws JSONException
    {
        List<News> newsList = new ArrayList<>();
        for(int i = 0; i < newsJsonArray.length(); i++)
        {
            newsList.add(new News(newsJsonArray.getJSONObject(i)));
        }
        return newsList;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getByline() {
        return byline;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}
