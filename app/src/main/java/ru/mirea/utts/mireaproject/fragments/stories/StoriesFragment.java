package ru.mirea.utts.mireaproject.fragments.stories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ru.mirea.utts.mireaproject.App;
import ru.mirea.utts.mireaproject.AppDB;
import ru.mirea.utts.mireaproject.R;

public class StoriesFragment extends Fragment {

    private FloatingActionButton fab;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        //view.findViewById(R.id.add).setOnClickListener(this::onClickAddHistory);

        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddStoryFragment addHistoryFragment = new AddStoryFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(((ViewGroup)getView().getParent()).getId(), addHistoryFragment, null)
                        .addToBackStack(null)
                        .commit();
            }
        });

        AppDB db = App.getInstance().getDatabase();
        StoryDAO storyDAO =  db.storyDAO();

        List<Story> historyList = storyDAO.getAll();

        StoryAdapter adapter =  new StoryAdapter(getActivity(), historyList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void onClickAddHistory(View view){

        AddStoryFragment addHistoryFragment = new AddStoryFragment();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), addHistoryFragment, "findThisFragment")
                .addToBackStack(null)
                .commit();

        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }
}