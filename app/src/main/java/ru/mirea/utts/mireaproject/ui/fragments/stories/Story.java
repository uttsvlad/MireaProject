package ru.mirea.utts.mireaproject.ui.fragments.stories;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Story {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String story;

    public long getId() {
        return this.id;
    }

    public String getStory() {
        return this.story;
    }
}