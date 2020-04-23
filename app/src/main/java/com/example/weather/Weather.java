package com.example.weather;

import io.realm.RealmObject;

public class Weather extends RealmObject {
    private int id;
    private String main;
    private String description;

    public Weather() {
    }

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }
}
