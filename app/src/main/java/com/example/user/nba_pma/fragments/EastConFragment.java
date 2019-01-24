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
import com.example.user.nba_pma.adapter.RecyclerViewStandingsAdapter;
import com.example.user.nba_pma.models.StandingsModel;
import com.example.user.nba_pma.models_standings.Conference;
import com.example.user.nba_pma.models_standings.East;
import com.example.user.nba_pma.models_standings.League;
import com.example.user.nba_pma.models_standings.Standard;
import com.example.user.nba_pma.models_standings.StandingsResponse;
import com.example.user.nba_pma.models_standings.West;
import com.example.user.nba_pma.models_teams.LeagueTeams;
import com.example.user.nba_pma.models_teams.Team;
import com.example.user.nba_pma.models_teams.TeamsResponse;
import com.example.user.nba_pma.network.RetrofitManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class EastConFragment extends Fragment {
    public static EastConFragment newInstance() {
        
        Bundle args = new Bundle();
        
        EastConFragment fragment = new EastConFragment();
        fragment.setArguments(args);
        return fragment;
    }


        TextView textViewEast;
        ArrayList<Team> teamsStandard = new ArrayList<>();
        ArrayList<Team> teamsAfrica = new ArrayList<>();
        ArrayList<Team> teamsSacramento = new ArrayList<>();
        ArrayList<Team> teamsUtah = new ArrayList<>();
        ArrayList<Team> teamsVegas = new ArrayList<>();

        ArrayList<East> eastStandings = new ArrayList<>();

        LeagueTeams leagueTeams;
        League league;

        StandingsModel standingsModel;
        ArrayList<StandingsModel> standingsModelsList = new ArrayList<>();

        RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view=inflater.inflate(R.layout.fragment_east_con,container,false);

        Log.d(getClass().getName(), String.format("value = %d", standingsModelsList.size()));

        Call<TeamsResponse> callResponseTeams = RetrofitManager.getInstance().getApi().getTeamsLeague();
        callResponseTeams.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                String textTeam;
                if(response.isSuccessful() && response.body() != null)
                {
                    leagueTeams = response.body().getLeagueTeams();
                    setUpData(leagueTeams, league, view);
                }
                else
                {
                    textTeam = "nista od toga";
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                setText("Doslo je do greske: " + t.getMessage());
            }
        });

        Call<StandingsResponse> callResponseTeamsStandings = RetrofitManager.getInstance().getApi().getStandingsLeague();
        callResponseTeamsStandings.enqueue(new Callback<StandingsResponse>() {
            @Override
            public void onResponse(Call<StandingsResponse> call, Response<StandingsResponse> response) {
                if(response.isSuccessful() && response.body() != null)
                {
                    league = response.body().getLeague();
                    setUpData(leagueTeams, league, view);
                }
                else
                {
                    setText("nista od toga");
                }
            }

            @Override
            public void onFailure(Call<StandingsResponse> call, Throwable t) {
                setText("Doslo je do greske: " + t.getMessage());
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    void setText(String text)
    {
        textViewEast.setText(text);
    }
    void setUpData(LeagueTeams leagueTeams, League league, View view)
    {
        if(leagueTeams == null || league == null)
        {
            return;
        }
        eastStandings = league.getStandard().getConference().getEast();
        teamsStandard = leagueTeams.getStandardTeams();
        teamsAfrica = leagueTeams.getAfrica();
        teamsSacramento = leagueTeams.getSacramento();
        teamsUtah = leagueTeams.getUtah();
        teamsVegas = leagueTeams.getVegas();

        for(East east : eastStandings) {
            Log.i("EAST_ID: ",east.getTeamId());
            for (Team standard : teamsStandard) {
                if (east.getTeamId().equals(standard.getTeamId())) {
                    Log.i("STANDARD_FULL_NAME: ",standard.getFullName());
                    standingsModel = new StandingsModel(standard.getTeamId(), standard.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                    standingsModelsList.add(standingsModel);
                }
            }
            for (Team africa : teamsAfrica) {
                if (east.getTeamId().equals(africa.getTeamId())) {
                    standingsModel = new StandingsModel(africa.getTeamId(), africa.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                    standingsModelsList.add(standingsModel);
                }
            }
            for (Team sacramento : teamsSacramento) {
                if (east.getTeamId().equals(sacramento.getTeamId())) {
                    standingsModel = new StandingsModel(sacramento.getTeamId(), sacramento.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                    standingsModelsList.add(standingsModel);
                }
            }
            for (Team utah : teamsUtah) {
                if (east.getTeamId().equals(utah.getTeamId())) {
                    standingsModel = new StandingsModel(utah.getTeamId(), utah.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                    standingsModelsList.add(standingsModel);
                }
            }
            for (Team vegas : teamsVegas) {
                if (east.getTeamId().equals(vegas.getTeamId())) {
                    standingsModel = new StandingsModel(vegas.getTeamId(), vegas.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                    standingsModelsList.add(standingsModel);
                }
            }
            Log.d(getClass().getName(), String.format("value = %d", standingsModelsList.size()));
        }
        /*for (StandingsModel standings : standingsModelsList)
        {
            Log.i("Name: ", standings.getTeamName());
        }*/
        //Log.d(getClass().getName(), String.format("value = %d", standingsModelsList.size()));
        recyclerView = view.findViewById(R.id.recycler_view_east);
        RecyclerViewStandingsAdapter adapter = new RecyclerViewStandingsAdapter(getContext(), standingsModelsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
