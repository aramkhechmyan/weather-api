package com.example.weather;

import io.realm.RealmObject;

public class Sys extends RealmObject {
    private int type;
    private int id;
    private String country;
    private int sunrise;
    private int sunset;
    private int y;

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public int getY() {
        return y;
    }
}
