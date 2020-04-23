package com.example.weather;

import io.realm.RealmObject;

public class Wind extends RealmObject {
    private double speed;

    public double getSpeed() {
        return speed;
    }
}
