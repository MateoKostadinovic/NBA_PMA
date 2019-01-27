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
import com.example.user.nba_pma.models_standings.League;
import com.example.user.nba_pma.models_standings.Standings;
import com.example.user.nba_pma.models_standings.StandingsResponse;
import com.example.user.nba_pma.models_teams.LeagueTeams;
import com.example.user.nba_pma.models_teams.Team;
import com.example.user.nba_pma.models_teams.TeamsResponse;
import com.example.user.nba_pma.network.RetrofitManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class StandingsConFragment extends Fragment {

        public static int CONFERENCE_EAST=0;
        public static int CONFERENCE_WEST=1;
        private static  String EXTRA_CONFERENCE_TYPE = "conf_type";

    public static StandingsConFragment newInstance(int conferenceType) {
        
        Bundle args = new Bundle();
        args.putInt(EXTRA_CONFERENCE_TYPE,conferenceType);
        StandingsConFragment fragment = new StandingsConFragment();
        fragment.setArguments(args);
        return fragment;
    }

        int conferenceType = CONFERENCE_EAST;

        TextView textViewEast;
        ArrayList<Team> teamsStandard = new ArrayList<>();
        ArrayList<Team> teamsAfrica = new ArrayList<>();
        ArrayList<Team> teamsSacramento = new ArrayList<>();
        ArrayList<Team> teamsUtah = new ArrayList<>();
        ArrayList<Team> teamsVegas = new ArrayList<>();

        ArrayList<Standings> standings = new ArrayList<>();

        LeagueTeams leagueTeams;
        League league;

        StandingsModel standingsModel;
        ArrayList<StandingsModel> standingsModelsList = new ArrayList<>();

        RecyclerView recyclerView;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null)
            {
                conferenceType = getArguments().getInt(EXTRA_CONFERENCE_TYPE);
            }
        }

        @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View view=inflater.inflate(R.layout.fragment_standings_con,container,false);


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
        if(conferenceType == CONFERENCE_EAST)
        {
            standings = league.getStandard().getConference().getEast();
        }
        else
        {
            standings = league.getStandard().getConference().getWest();
        }

        teamsStandard = leagueTeams.getStandardTeams();
        teamsAfrica = leagueTeams.getAfrica();
        teamsSacramento = leagueTeams.getSacramento();
        teamsUtah = leagueTeams.getUtah();
        teamsVegas = leagueTeams.getVegas();

        for(Standings oStandings : standings) {
            for (Team standard : teamsStandard) {
                if (oStandings.getTeamId().equals(standard.getTeamId())) {
                    standingsModel = new StandingsModel(standard.getTeamId(), standard.getFullName(), oStandings.getWin(), oStandings.getLoss(), oStandings.getWinPctV2(), oStandings.getGamesBehind());
                    standingsModelsList.add(standingsModel);
                    Log.i("TEAM_NAME: ",standingsModel.getTeamName());
                }
            }
            Log.d(getClass().getName(), String.format("value = %d", standingsModelsList.size()));
        }

        recyclerView = view.findViewById(R.id.recycler_view_standings);
        RecyclerViewStandingsAdapter adapter = new RecyclerViewStandingsAdapter(getContext(), standingsModelsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
