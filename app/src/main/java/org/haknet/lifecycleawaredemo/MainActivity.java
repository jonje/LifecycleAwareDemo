package org.haknet.lifecycleawaredemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    private MainActivityDataGenerator data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        this.data = viewModelProvider.get(MainActivityDataGenerator.class);
        String myRandomNumber = this.data.getNumber();
        TextView txNumber = findViewById(R.id.txNumber);
        txNumber.setText(myRandomNumber);
        Log.i(TAG, "Random Number Set");
        Log.i(TAG, "Owner onCreate()");
        getLifecycle().addObserver(new MainActivityObserver());
    }
}