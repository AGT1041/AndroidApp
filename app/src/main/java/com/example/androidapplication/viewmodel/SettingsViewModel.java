package com.example.androidapplication.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidapplication.AppDatabase;
import com.example.androidapplication.AppDatabaseSingleton;
import com.example.androidapplication.entity.Settings;

import java.util.List;

public class SettingsViewModel extends ViewModel  {

    public LiveData<List<Settings>> loadSettings(Context context) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        return db.settingsDao().getSettings();
    }

    public void saveSettings(Context context, Settings... settings) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.settingsDao().saveSettings(settings);
        });
    }





}
