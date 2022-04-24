package ru.mirea.utts.mireaproject.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.utts.mireaproject.services.MusicService;
import ru.mirea.utts.mireaproject.R;

public class MusicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_music, container, false);
        view.findViewById(R.id.startButton).setOnClickListener(this::onClickPlayMusic);
        view.findViewById(R.id.stopButton).setOnClickListener(this::onClickStopMusic);

        return view;
    }

    public void onClickPlayMusic(View view) {
        getActivity().startService(new Intent(getActivity(), MusicService.class));
    }

    public void onClickStopMusic(View view) {
        getActivity().stopService(new Intent(getActivity(), MusicService.class));
    }
}