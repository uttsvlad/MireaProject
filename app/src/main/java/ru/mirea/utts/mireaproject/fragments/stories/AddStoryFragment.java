package ru.mirea.utts.mireaproject.fragments.stories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.mirea.utts.mireaproject.App;
import ru.mirea.utts.mireaproject.AppDB;
import ru.mirea.utts.mireaproject.R;


public class AddStoryFragment extends Fragment {

    private EditText storyEditText;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_story, container, false);
        storyEditText = view.findViewById(R.id.editTextStory);

        view.findViewById(R.id.saveStoryBtn).setOnClickListener(this::onClickSaveStory);

        return view;
    }

    public void onClickSaveStory(View view){

        AppDB db = App.getInstance().getDatabase();
        StoryDAO historyDao = db.storyDAO();

        Story story = new Story();
        story.story = storyEditText.getText().toString();

        historyDao.insert(story);


        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();

    }
}