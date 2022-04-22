package com.example.models;

import android.util.Log;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Ticket
{

    String name;
    int minimumPrice; //getting the minimum within the priceRange
    String genreName;
    String dates;

    public Ticket()
    {
        //Empty constructor
    }

    public static final String TAG = "Ticket";
    public Ticket(JSONObject jsonObject) throws JSONException
    {

      //  JSONArray classifications= jsonObject.getJSONArray("classifications");
        JSONObject genre = jsonObject.getJSONArray("classifications").getJSONObject(0).getJSONObject("genre");
        if(genre.isNull("name"))
            return;

        if (!genre.getString("name").equals("Rock") && !genre.getString("name").equals("Fairs & Festivals")) {
                 name = jsonObject.getString("name");

                 genreName = genre.getString("name");

                if (jsonObject.has("priceRanges")) {

                    minimumPrice = jsonObject.getJSONArray("priceRanges").getJSONObject(0).getInt("min");
                    dates = jsonObject.getJSONObject("dates").getJSONObject("start").getString("localDate");

                } else {
                    minimumPrice = 75;

                }
            //Log.i(TAG, "[name: " + name + "] " + "[genre: " + genreName + "] " +" [min: " + minimumPrice + "]");

        }

    }


    public static List<Ticket> fromJSONArray(JSONArray ticketList) throws JSONException
    {
        List<Ticket> tickets = new ArrayList<>();

        for(int i = 0; i < ticketList.length(); i++)
        {
            Ticket ticket = new Ticket(ticketList.getJSONObject(i));
        }

        return tickets;

    }

    public String getName() {
        return name;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public String getDates() {
        return dates;
    }

    public String getGenreName() {
        return genreName;
    }
}
