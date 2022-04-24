package ru.mirea.utts.mireaproject;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {

    public static App instance;
    private AppDB database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDB.class, "database")
                .allowMainThreadQueries()
                .build();
    }
    public static App getInstance() {
        return instance;
    }
    public AppDB getDatabase() {
        return database;
    }
}
