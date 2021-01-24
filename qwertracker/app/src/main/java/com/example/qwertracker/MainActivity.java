package com.example.qwertracker;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qwertracker.data.AppDatabase;
import com.example.qwertracker.data.SurveyResponseDao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;

    public SurveyResponseDao getAccessor() {
        return db.surveyResponseDao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // TODO check
        Context context = getApplicationContext();
        // attempt to import db from save file
        // if file is inaccessible, create new blank db
        File file = new File(context.getFilesDir(), "responses.dat");
        if (!file.exists()) {
            try {
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
            } catch (IOException e) {
                System.err.println("Error creating file for db storage: " + e.getMessage());
            }
            db = Room.databaseBuilder(context, AppDatabase.class, "surveyResponse").build();
        } else if (!file.canRead()) {
            file.setWritable(true);
            file.setReadable(true);
            db = Room.databaseBuilder(context, AppDatabase.class, "surveyResponse").build();
        } else {
            db = Room.databaseBuilder(context, AppDatabase.class, "surveyResponse")
                    .createFromFile(file).build();
        }
    }

    @Override
    protected void onDestroy() {
        // TODO check
        Context context = getApplicationContext();
        // tries to save db to file
        File file = new File(context.getFilesDir(), "responses.dat");
        try {
            if (!file.exists()) {
                file.createNewFile();
                file.setWritable(true);
                file.setReadable(true);
            } else if (!file.canWrite()) {
                file.setWritable(true);
                file.setReadable(true);
            }
            new FileWriter(file).write(db.toString());
        } catch (IOException e) {
            System.err.println("could not back up db to file " + e.getMessage());
        }
        super.onDestroy();
    }
}