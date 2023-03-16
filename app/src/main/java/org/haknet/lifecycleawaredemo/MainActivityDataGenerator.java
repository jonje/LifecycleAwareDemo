package org.haknet.lifecycleawaredemo;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityDataGenerator extends ViewModel {
    private final static String TAG = MainActivityDataGenerator.class.getSimpleName();
    private String myRandomNumber;

    public String getNumber() {
        Log.i(TAG, "Get Number");

        if (this.myRandomNumber == null || this.myRandomNumber.isEmpty()) {
            this.createNumber();
        }

        return this.myRandomNumber;
    }

    private void createNumber() {
        Log.i(TAG, "Create new number");
        Random random = new Random();
        this.myRandomNumber = "Number: " + (random.nextInt(10 - 1) + 1);
    }
}
