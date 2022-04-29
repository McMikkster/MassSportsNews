package com.example.masssportsnews.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Ticket {

    String name;
    int minimumPrice; //getting the minimum within the priceRange
    String genreName;
    String dates;
    String url;

    public Ticket() {
        //Empty constructor
    }

    public static final String TAG = "Ticket";

    public Ticket(JSONObject jsonObject) throws JSONException {

        //  JSONArray classifications= jsonObject.getJSONArray("classifications");
        JSONObject genre = jsonObject.getJSONArray("classifications").getJSONObject(0).getJSONObject("genre");
        name = jsonObject.getString("name");

        JSONArray imageContainer = jsonObject.getJSONArray("images");

        url = jsonObject.getJSONArray("images").getJSONObject(0).getString("url");


        Log.i(TAG, "[" + url + "]");


        genreName = genre.getString("name");

        if (jsonObject.has("priceRanges")) {

            minimumPrice = jsonObject.getJSONArray("priceRanges").getJSONObject(0).getInt("min");
            dates = jsonObject.getJSONObject("dates").getJSONObject("start").getString("localDate");

        } else {
            minimumPrice = 75;

        }
        //Log.i(TAG, "[name: " + name + "] " + "[genre: " + genreName + "] " +" [min: " + minimumPrice + "]");


    }


    public static List<Ticket> fromJSONArray(JSONArray ticketList) throws JSONException {
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < ticketList.length(); i++) {

            JSONArray classifications = ticketList.getJSONObject(i).getJSONArray("classifications");


            if (!classifications.isNull(0)) {
                JSONObject segment = classifications.getJSONObject(0).getJSONObject("segment");
                if (segment.getString("name").equals("Sports")) {

                    JSONArray images = ticketList.getJSONObject(i).getJSONArray("images");
                    Log.i(TAG, "segment: " + segment.getString("name"));
                    if(!images.isNull(0))
                    {
                        Log.i(TAG, "url :" + images.getJSONObject(0).getString("url"));
                    }

                    Ticket ticket = new Ticket(ticketList.getJSONObject(i));
                    tickets.add(ticket);
                }
            }
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

    public String getUrl() {
        return url;
    }
}
