package com.example.qwertracker.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SurveyResponse {
    @PrimaryKey
    public long timestamp; // System.currentTimeMillis() records current time in milliseconds since 1970

    // categories are scored from 1-????
    public int happiness;
    public int anger;
    public int energy;
    public int anxiety;
    // TODO what other categories?
}
