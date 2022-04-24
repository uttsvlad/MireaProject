package ru.mirea.utts.mireaproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.utts.mireaproject.fragments.stories.Story;
import ru.mirea.utts.mireaproject.fragments.stories.StoryDAO;

@Database(entities = {Story.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    public abstract StoryDAO storyDAO();
}
