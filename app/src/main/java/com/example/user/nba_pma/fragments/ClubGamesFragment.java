package com.example.user.nba_pma.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.nba_pma.R;
import com.example.user.nba_pma.models.StandingsModel;

import java.util.ArrayList;

public class ClubGamesFragment  extends Fragment {
    public static ClubGamesFragment newInstance() {
        
        Bundle args = new Bundle();

        ClubGamesFragment fragment = new ClubGamesFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view=inflater.inflate(R.layout.fragment_club_games,container,false);

        Log.d(getClass().getName(),getActivity().getIntent().getExtras().getString("team_id"));

        return view;
    }
}
