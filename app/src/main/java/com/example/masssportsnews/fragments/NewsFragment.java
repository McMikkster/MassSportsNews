package com.example.masssportsnews.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.masssportsnews.R;
import com.example.masssportsnews.adapter.LiveAdapter;
import com.example.masssportsnews.adapter.NewsAdapter;
import com.example.models.LiveScore;
import com.example.models.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class NewsFragment extends Fragment {

    public static final String API_KEY = "https://api.nytimes.com/svc/topstories/v2/sports.json?api-key=0yN0D0bpaK0jpx9smLbhRzVRpuvqQd9p";
    public static final String TAG = "NewsFragment";
    RecyclerView rvNews;
    NewsAdapter newsAdapter;
    List<News> newsList;


    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        newsList = new ArrayList<>();


        rvNews = view.findViewById(R.id.rvNews);

        newsAdapter = new NewsAdapter(getContext(), newsList);

        rvNews.setAdapter(newsAdapter);

        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(API_KEY, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {

                Log.d(TAG, "OnSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results  = jsonObject.getJSONArray("results");
                    Log.i(TAG, "Results: " + results.toString());

                    newsList.addAll(News.fromJSONArray(results));



                    newsAdapter.notifyDataSetChanged();
                    Log.i(TAG, "Movies: " + newsList.size());
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception", e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.d(TAG, "OnFailure");
            }
        });
    }
}
