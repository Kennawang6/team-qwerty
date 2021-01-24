package com.example.qwertracker.ui.questions;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qwertracker.MainActivity;
import com.example.qwertracker.data.AppDatabase;
import com.example.qwertracker.data.SurveyResponseDao;

public class Question1Fragment extends Fragment {
    AppDatabase db;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO move this entire block to the end of the survey please
        MainActivity activity = ((MainActivity) getActivity());
        SurveyResponseDao accessor;
        if (activity == null) {
            // BIG TROUBLE, shouldn't happen
            System.err.println("Question1 Fragment could not find activity. This is a problem!");
        } else {
            accessor = activity.getAccessor();
        }
        /* TODO the following code might (I didn't try it) be able to insert a survey response into the database
        SurveyResponse response = new SurveyResponse();
        response.timestamp = System.getTimeMillis();
        response.happiness = ...;
        response.anger = ...;
        response.energy = ...;
        response.anxiety = ...;
        accessor.insert(response);
         */
    }
}
