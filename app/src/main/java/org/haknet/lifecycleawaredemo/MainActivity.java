package org.haknet.lifecycleawaredemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    private MainActivityDataGenerator data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txNumber = findViewById(R.id.txNumber);
        Button button = findViewById(R.id.bRandom);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        this.data = viewModelProvider.get(MainActivityDataGenerator.class);
        LiveData<String> myRandomNumber = this.data.getNumber();
        myRandomNumber.observe(this, (Observer<String>) number -> {
            txNumber.setText(number);
            Log.i(TAG, "Random Number Set");
        });

        button.setOnClickListener(view -> {
            data.createNumber();
        });

        Log.i(TAG, "Owner onCreate()");
        getLifecycle().addObserver(new MainActivityObserver());
    }
}