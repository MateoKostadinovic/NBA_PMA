package com.example.user.nba_pma.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.nba_pma.R;
import com.example.user.nba_pma.adapter.RecyclerViewClubPlayersAdapter;
import com.example.user.nba_pma.models_club_players.ClubPlayer;
import com.example.user.nba_pma.models_club_players.ClubPlayersResponse;
import com.example.user.nba_pma.models_club_players.LeagueClubPlayers;
import com.example.user.nba_pma.models_club_players.StandardClubPlayers;
import com.example.user.nba_pma.models_players.LeaguePlayers;
import com.example.user.nba_pma.models_players.PlayersResponse;
import com.example.user.nba_pma.models_players.StandardPlayers;
import com.example.user.nba_pma.network.RetrofitManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubPlayersFragment extends Fragment {
    public static ClubPlayersFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ClubPlayersFragment fragment = new ClubPlayersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LeaguePlayers leaguePlayers;
    LeagueClubPlayers leagueClubPlayers;

    ArrayList<StandardPlayers> standardPlayers = new ArrayList<>();

    StandardClubPlayers standardClubPlayers;
    ArrayList<ClubPlayer> clubPlayers = new ArrayList<>();

    StandardPlayers standardPlayersModel;
    ArrayList<StandardPlayers> standardPlayersModelList = new ArrayList<>();

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view=inflater.inflate(R.layout.fragment_club_players,container,false);

        String sTeamdID = getActivity().getIntent().getExtras().getString("team_id");
        Integer nTeamID = Integer.parseInt(sTeamdID);

        Call<PlayersResponse> callResponsePlayers = RetrofitManager.getInstance().getApi().getPlayers();
        callResponsePlayers.enqueue(new Callback<PlayersResponse>() {
            @Override
            public void onResponse(Call<PlayersResponse> call, Response<PlayersResponse> response) {
                String textTeam;
                if(response.isSuccessful() && response.body() != null)
                {
                    leaguePlayers = response.body().getLeaguePlayers();
                    setUpData(leaguePlayers, leagueClubPlayers, view);
                }
                else
                {
                    textTeam = "nista od toga";
                }
            }

            @Override
            public void onFailure(Call<PlayersResponse> call, Throwable t) {
                //setText("Doslo je do greske: " + t.getMessage());
            }
        });

        Call<ClubPlayersResponse> callResponseTeamPlayers = RetrofitManager.getInstance().getApi().getTeamPlayers(nTeamID);
        callResponseTeamPlayers.enqueue(new Callback<ClubPlayersResponse>() {
            @Override
            public void onResponse(Call<ClubPlayersResponse> call, Response<ClubPlayersResponse> response) {
                String textTeam;
                if(response.isSuccessful() && response.body() != null)
                {
                    leagueClubPlayers = response.body().getLeagueClubPlayers();
                    setUpData(leaguePlayers, leagueClubPlayers, view);
                }
                else
                {
                    textTeam = "nista od toga";
                }
            }

            @Override
            public void onFailure(Call<ClubPlayersResponse> call, Throwable t) {
                //setText("Doslo je do greske: " + t.getMessage());
            }
        });

        return view;
    }
    void setUpData(LeaguePlayers leaguePlayers, LeagueClubPlayers leagueClubPlayers, View view)
    {
        if(leaguePlayers == null || leagueClubPlayers == null)
        {
            return;
        }

        standardPlayers = leaguePlayers.getStandardPlayers();
        standardClubPlayers = leagueClubPlayers.getStandardClubPlayers();
        clubPlayers = standardClubPlayers.getClubPlayers();


        for(ClubPlayer oClubPlayer : clubPlayers) {
            for (StandardPlayers players : standardPlayers) {
                if (oClubPlayer.getsClubPlayerId().equals(players.getPersonIdPlayer())) {
                    standardPlayersModel = new StandardPlayers(players.getFirstNamePlayer(), players.getLastNamePlayer(), players.getPersonIdPlayer(), players.getJerseyPlayer(), players.getPositionPlayer());
                    standardPlayersModelList.add(standardPlayersModel);
                }
            }
        }

        recyclerView = view.findViewById(R.id.recycler_view_club_players);
        RecyclerViewClubPlayersAdapter adapter = new RecyclerViewClubPlayersAdapter(getContext(), standardPlayersModelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
