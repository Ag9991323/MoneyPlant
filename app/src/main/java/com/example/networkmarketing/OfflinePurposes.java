package com.example.networkmarketing;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class OfflinePurposes extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
}
