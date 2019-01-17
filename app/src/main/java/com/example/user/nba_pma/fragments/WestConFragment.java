package com.example.user.nba_pma.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.nba_pma.R;
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

public class WestConFragment extends Fragment {
    public static WestConFragment newInstance() {

        Bundle args = new Bundle();

        WestConFragment fragment = new WestConFragment();
        fragment.setArguments(args);
        return fragment;
    }

    ArrayList<Team> teamsStandard = new ArrayList<>();
    ArrayList<Team> teamsAfrica = new ArrayList<>();
    ArrayList<Team> teamsSacramento = new ArrayList<>();
    ArrayList<Team> teamsUtah = new ArrayList<>();
    ArrayList<Team> teamsVegas = new ArrayList<>();

    ArrayList<East> eastStandings = new ArrayList<>();
    ArrayList<West> westStandings = new ArrayList<>();

    LeagueTeams leagueTeams;
    League league;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_west_con, container, false);


        ListView listView = (ListView) view.findViewById(R.id.listViewWest);

        String[][] content = {
                {"Golden State", "682"},
                {"Denver", "674"},
                {"Oklahoma City", "605"},
                {"Houston", "581"},
                {"Portland", "578"},
                {"LA Clippers", "558"},
                {"San Antonio", "556"},
                {"Los Angeles Lakers", "533"},
                {"Utah", "533"},
                {"Sacramento", "523"},
                {"Minnesota", "477"},
                {"New Orleans", "477"},
                {"Dallas", "465"},
                {"Memphis", "442"},
                {"Phoenix", "244"}
        };

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1
        );
        for (int i = 0; i < content.length; i++) {
            String s = content[i][0] + " " + content[i][1];
            listViewAdapter.add(s);
        }
        listView.setAdapter(listViewAdapter);

        //nesto za probu sa fiksnim poljima
        /*Log.d("iza","iza");
        EastAdapter eastAdapter = new EastAdapter();
        listView.setAdapter(eastAdapter);*/


        Call<TeamsResponse> callResponseTeams = RetrofitManager.getInstance().getApi().getTeamsLeague();
        callResponseTeams.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                Log.d("response", "response");
                if (response.isSuccessful() && response.body() != null) {
                    leagueTeams = response.body().getLeagueTeams();
                } else {
                    setText("nista od toga");
                }
            }

            @Override
            public void onFailure(Call<TeamsResponse> call, Throwable t) {
                Log.d("failure", "failure");
                setText("Doslo je do greske: " + t.getMessage());
            }
        });

        Call<StandingsResponse> callResponseTeamsStandings = RetrofitManager.getInstance().getApi().getStandingsLeague();
        callResponseTeamsStandings.enqueue(new Callback<StandingsResponse>() {
            @Override
            public void onResponse(Call<StandingsResponse> call, Response<StandingsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    league = response.body().getLeague();
                    setUpData(leagueTeams, league);
                } else {
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

    void setText(String text) {

    }

    void setUpData(LeagueTeams leagueTeams, League league)
    {
        //if usporedbba ako je jedan null odmah return
    }
}
