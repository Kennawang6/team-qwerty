package com.example.qwertracker.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AnxietyResponse {
    @PrimaryKey
    public long timestamp;

    public int anxiety;
}
