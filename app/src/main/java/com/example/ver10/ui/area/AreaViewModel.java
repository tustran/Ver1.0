package com.example.ver10.ui.area;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AreaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AreaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is area fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}