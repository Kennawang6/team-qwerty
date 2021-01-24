package com.example.qwertracker.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to qwertracker: a mood tracker designed to fit all of your needs");
    }

    public LiveData<String> getText() {
        return mText;
    }
}