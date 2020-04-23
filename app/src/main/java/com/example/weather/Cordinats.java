package com.example.weather;

import io.realm.RealmObject;

public class Cordinats extends RealmObject {
    private double lon;
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
