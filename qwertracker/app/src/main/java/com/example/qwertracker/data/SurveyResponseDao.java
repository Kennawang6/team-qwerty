package com.example.qwertracker.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SurveyResponseDao {
    @Insert
    void insert(SurveyResponse surveyResponse);

    // gets all survey responses between the start and end times
    @Query("SELECT * FROM surveyResponse WHERE timestamp BETWEEN :start  AND :end")
    public List<SurveyResponse> getResponsesBetween(long start, long end);

    // gets all survey responses ever
    @Query("SELECT * FROM surveyResponse")
    public List<SurveyResponse> getAllResponses();

    // gets happiness levels from all survey responses between the start and end times
    @Query("SELECT timestamp, happiness FROM surveyResponse WHERE timestamp BETWEEN :start  AND :end")
    public List<HappinessResponse> getHappinessResponsesBetween(long start, long end);

    // gets happiness levels from all survey responses ever
    @Query("SELECT timestamp, happiness FROM surveyResponse")
    public List<HappinessResponse> getAllHappinessResponses();

    @Query("SELECT timestamp, anger FROM surveyResponse WHERE timestamp BETWEEN :start  AND :end")
    public List<AngerResponse> getAngerResponsesBetween(long start, long end);

    @Query("SELECT timestamp, anger FROM surveyResponse")
    public List<AngerResponse> getAllAngerResponses();

    @Query("SELECT timestamp, energy FROM surveyResponse WHERE timestamp BETWEEN :start  AND :end")
    public List<EnergyResponse> getEnergyResponsesBetween(long start, long end);

    @Query("SELECT timestamp, energy FROM surveyResponse")
    public List<EnergyResponse> getAllEnergyResponses();

    @Query("SELECT timestamp, anxiety FROM surveyResponse WHERE timestamp BETWEEN :start  AND :end")
    public List<AnxietyResponse> getAnxietyResponsesBetween(long start, long end);

    @Query("SELECT timestamp, anxiety FROM surveyResponse")
    public List<AnxietyResponse> getAllAnxietyResponses();
}
