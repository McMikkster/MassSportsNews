package com.example.models;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;
import org.parceler.Transient;

import java.util.ArrayList;
import java.util.List;


@Parcel
public class LiveScore
{
    String sportTitle;
    String homeTeam;
    String awayTeam;

    Boolean complete;
    String commenceTime; // 2020-01-02T23:10:00Z

    String homeScore;
    String awayScore;
    String lastUpdate;

    public LiveScore() {}

    public LiveScore(JSONObject jsonObject) throws JSONException
    {
        sportTitle = jsonObject.getString("sport_title");
        homeTeam = jsonObject.getString("home_team");
        awayTeam = jsonObject.getString("away_team");
        complete = jsonObject.getBoolean("completed");
        commenceTime = jsonObject.getString("commence_time");

        lastUpdate = jsonObject.getString("last_update");

         if(jsonObject.has("scores") && !jsonObject.isNull("scores"))
         {
             homeScore = jsonObject.getJSONArray("scores").getJSONObject(0).getString("score");
             awayScore = jsonObject.getJSONArray("scores").getJSONObject(1).getString("score");
         }
         else
         {
              homeScore = "0";
              awayScore = "0";
         }


    }

    public static List<LiveScore> fromJSONArray(JSONArray liveScoreJsonArray) throws JSONException
    {
        List<LiveScore> liveScoreList = new ArrayList<>();
        for(int i = 0; i < liveScoreJsonArray.length(); i++)
        {
                liveScoreList.add(new LiveScore(liveScoreJsonArray.getJSONObject(i)));
        }

        return liveScoreList;
    }

    public String getSportTitle() {
        return sportTitle;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Boolean getComplete() {
        return complete;
    }

    public String getCommenceTime() {
        return commenceTime;
    }

    public String getHomeScore() {
        return homeScore;
    }

    public String getAwayScore() {
        return awayScore;
    }

}
