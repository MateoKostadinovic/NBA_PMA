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
import android.widget.TextView;

import com.example.user.nba_pma.R;
import com.example.user.nba_pma.adapter.RecyclerViewClubGamesAdapter;
import com.example.user.nba_pma.models.ClubGamesModel;
import com.example.user.nba_pma.models.StandingsModel;
import com.example.user.nba_pma.models_games.GamesResponse;
import com.example.user.nba_pma.models_games.LeagueGames;
import com.example.user.nba_pma.models_games.StandardGames;
import com.example.user.nba_pma.models_games.TeamGames;
import com.example.user.nba_pma.models_teams.LeagueTeams;
import com.example.user.nba_pma.models_teams.Team;
import com.example.user.nba_pma.models_teams.TeamsResponse;
import com.example.user.nba_pma.network.RetrofitManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubGamesFragment  extends Fragment {
    public static ClubGamesFragment newInstance() {
        
        Bundle args = new Bundle();

        ClubGamesFragment fragment = new ClubGamesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LeagueTeams leagueTeams;
    LeagueGames leagueGames;

    ArrayList<Team> teamsStandard = new ArrayList<>();

    ArrayList<StandardGames> standardGames = new ArrayList<>();

    ClubGamesModel clubGamesModel;
    ArrayList<ClubGamesModel> clubGamesModelList = new ArrayList<>();

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view=inflater.inflate(R.layout.fragment_club_games,container,false);

        String sTeamdID = getActivity().getIntent().getExtras().getString("team_id");
        Integer nTeamID = Integer.parseInt(sTeamdID);

        Call<TeamsResponse> callResponseTeams = RetrofitManager.getInstance().getApi().getTeamsLeague();
        callResponseTeams.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                String textTeam;
                if(response.isSuccessful() && response.body() != null)
                {
                    leagueTeams = response.body().getLeagueTeams();
                    setUpData(leagueTeams, leagueGames, view);
                }
                else
                {
                    textTeam = "nista od toga";
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                //setText("Doslo je do greske: " + t.getMessage());
            }
        });

        Call<GamesResponse> callResponseTeamGames = RetrofitManager.getInstance().getApi().getTeamGames(nTeamID);
        callResponseTeamGames.enqueue(new Callback<GamesResponse>() {
            @Override
            public void onResponse(Call<GamesResponse> call, Response<GamesResponse> response) {
                String textTeam;
                if(response.isSuccessful() && response.body() != null)
                {
                    leagueGames = response.body().getLeagueGames();
                    setUpData(leagueTeams, leagueGames, view);
                }
                else
                {
                    textTeam = "nista od toga";
                }
            }

            @Override
            public void onFailure(Call<GamesResponse> call, Throwable t) {
                //setText("Doslo je do greske: " + t.getMessage());
            }
        });

        return view;
    }

    void setUpData(LeagueTeams leagueTeams, LeagueGames leagueGames, View view)
    {
        if(leagueGames == null || leagueTeams == null)
        {
            return;
        }

        teamsStandard = leagueTeams.getStandardTeams();
        standardGames = leagueGames.getStandardGames();

        for(StandardGames oStandardGames : standardGames) {
            TeamGames oTeamH = oStandardGames.gethTeam();
            TeamGames oTeamV = oStandardGames.getvTeam();

            String sTeamHName="";
            String sTeamHScore="";
            String sTeamVName="";
            String sTeamVScore="";
            for (Team standard : teamsStandard) {
                if (oTeamH.getTeamId().equals(standard.getTeamId())) {
                    sTeamHName = standard.getFullName();
                    sTeamHScore = oTeamH.getScore();
                }
                if (oTeamV.getTeamId().equals(standard.getTeamId()))
                {
                    sTeamVName = standard.getFullName();
                    sTeamVScore = oTeamV.getScore();
                }
            }
            clubGamesModel = new ClubGamesModel(sTeamVName, sTeamHName, sTeamVScore, sTeamHScore);
            clubGamesModelList.add(clubGamesModel);

            Log.d(getClass().getName(), String.format("value = %d", clubGamesModelList.size()));
        }

        recyclerView = view.findViewById(R.id.recycler_view_club_games);
        RecyclerViewClubGamesAdapter adapter = new RecyclerViewClubGamesAdapter(getContext(), clubGamesModelList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
