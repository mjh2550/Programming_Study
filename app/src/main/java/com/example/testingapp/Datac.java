package com.example.testingapp;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Datac {
    private String text;

    private int count = 0;
    //private ObservableField<String> buttonText = new ObservableField<>();
    private MutableLiveData<String> buttonText = new MutableLiveData<>();

    public Datac() {
        updateButtonText();
    }

    public LiveData<String> getButtonText() {
        return buttonText;
    }

    public void updateButtonText() {
        buttonText.setValue(count+" checked");
    }

    public void onButtonClick() {
        ++count;
        updateButtonText();
    }
}
