package com.example.androidapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.androidapplication.entity.Settings;

@Database(entities = {Settings.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SettingsDao settingsDao();
}
