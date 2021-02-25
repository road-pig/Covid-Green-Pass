package com.example.covidgreenpass.ui.QRCode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QRCodeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QRCodeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}