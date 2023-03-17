package org.haknet.lifecycleawaredemo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityDataGenerator extends ViewModel {
    private final static String TAG = MainActivityDataGenerator.class.getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber() {
        Log.i(TAG, "Get Number");

        if (this.myRandomNumber == null) {
            this.myRandomNumber = new MutableLiveData<>();
            this.createNumber();
        }

        return this.myRandomNumber;
    }

    public void createNumber() {
        Log.i(TAG, "Create new number");
        Random random = new Random();
        this.myRandomNumber.setValue("Number: " + (random.nextInt(10 - 1) + 1));
    }
}
