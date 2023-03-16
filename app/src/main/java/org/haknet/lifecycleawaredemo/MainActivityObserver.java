package org.haknet.lifecycleawaredemo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class MainActivityObserver implements DefaultLifecycleObserver {
    private static final String TAG = MainActivityObserver.class.getSimpleName();
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.i(TAG, "Observer ON_CREATE");
    }
}
