package com.example.masssportsnews.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.masssportsnews.adapter.LiveAdapter;
import com.example.models.LiveScore;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masssportsnews.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveScoreFragment extends Fragment {

    public static final String API_KEY = "https://api.the-odds-api.com/v4/sports/basketball_nba/scores/?daysFrom=3&apiKey=737a700203b8a9e190db2568e43a2e11";
    public static final String TAG = "LiveFragment";
    RecyclerView rvLiveScores;
    LiveAdapter liveAdapter;
    List<LiveScore> liveScoreList;


    public LiveScoreFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static LiveScoreFragment newInstance(String param1, String param2) {
        LiveScoreFragment fragment = new LiveScoreFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_score, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


        liveScoreList = new ArrayList<>();


        rvLiveScores = view.findViewById(R.id.rvLiveScore);

        liveAdapter = new LiveAdapter(getContext(), liveScoreList);

        rvLiveScores.setAdapter(liveAdapter);

        rvLiveScores.setLayoutManager(new LinearLayoutManager(getContext()));

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(API_KEY, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(TAG, "OnSuccess");
                JSONArray results = json.jsonArray;

                try {
                    Log.i(TAG, "Results: " + results.toString());
                    liveScoreList.addAll(LiveScore.fromJSONArray(results));
                    liveAdapter.notifyDataSetChanged();
                    Log.i(TAG, "LiveScoreList: " + liveScoreList.size());
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
