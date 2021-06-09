package com.example.androidapplication;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.androidapplication.entity.Settings;

import java.util.List;
@Dao
public interface SettingsDao {

    @Query("SELECT * FROM settings" )
    LiveData<List<Settings>> getSettings();



    // Update settings entity in db
//    @Update
//    void updateSettings(Settings... settings);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveSettings(Settings... settings);


}
