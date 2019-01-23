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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_east_con,container,false);

        /*ListView listView = (ListView)view.findViewById(R.id.listViewEast);

        String[][] content = {
                {"Toronto", "733"},
                {"Milwaukee", "721"},
                {"Indiana", "674"},
                {"Philadelphia", "644"},
                {"Boston", "581"},
                {"Miami", "500"},
                {"Brooklyn", "489"},
                {"Charlotte", "465"},
                {"Orlando", "442"},
                {"Detroit", "429"},
                {"Washington", "409"},
                {"Atlanta", "318"},
                {"New York", "233"},
                {"Chicago", "227"},
                {"Cleveland", "205"}
        };

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1
        );
        for(int i = 0; i < content.length; i++) {
            String s = content[i][0] + " " + content[i][1];
            listViewAdapter.add(s);
        }
        listView.setAdapter(listViewAdapter);*/

        //nesto za probu sa fiksnim poljima
        /*Log.d("iza","iza");
        EastAdapter eastAdapter = new EastAdapter();
        listView.setAdapter(eastAdapter);*/



        Call<TeamsResponse> callResponseTeams = RetrofitManager.getInstance().getApi().getTeamsLeague();
        callResponseTeams.enqueue(new Callback<TeamsResponse>() {
            @Override
            public void onResponse(Call<TeamsResponse> call, Response<TeamsResponse> response) {
                String textTeam;
                if(response.isSuccessful() && response.body() != null)
                {
                    //OVDJE UDE !!!!
                    leagueTeams = response.body().getLeagueTeams(); //UVIJEK JE NULL !!!!!!!!!!
                    Log.d("teams: ","teams");
                    setUpData(leagueTeams,league);
                }
                else
                {
                    textTeam = "nista od toga";
                }
                //setText(textTeam);
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
                String text;
                if(response.isSuccessful() && response.body() != null)
                {
                    league = response.body().getLeague();
                    Log.d("east: ","east");
                    Log.d("east league ",league.getStandard().getConference().getEast().toString());
                    setUpData(leagueTeams,league);
                }
                else
                {
                    text = "nista od toga";
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
    void setUpData(LeagueTeams leagueTeams, League league)
    {
        Log.d("daTAf ","DATAf");
        if(league == null)//fali jos: || leagueTeams == null
        {
            return;
        }
        else
        {
            eastStandings = league.getStandard().getConference().getEast();
            /*teamsStandard = leagueTeams.getStandardTeams();
            teamsAfrica = leagueTeams.getAfrica();
            teamsSacramento = leagueTeams.getSacramento();
            teamsUtah = leagueTeams.getUtah();
            teamsVegas = leagueTeams.getVegas();*/
            Log.d("daTA ","DATA");
            for(East east : eastStandings)
            {
                Log.d("east win: ",east.getWinPctV2());
                for(Team standard : teamsStandard)
                {
                    if(east.getTeamId() == standard.getTeamId())
                    {
                        standingsModel = new StandingsModel(standard.getTeamId(), standard.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                        standingsModelsList.add(standingsModel);
                    }
                }
                for(Team africa : teamsAfrica)
                {
                    if(east.getTeamId() == africa.getTeamId())
                    {
                        standingsModel = new StandingsModel(africa.getTeamId(), africa.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                        standingsModelsList.add(standingsModel);
                    }
                }
                for(Team sacramento : teamsSacramento)
                {
                    if(east.getTeamId() == sacramento.getTeamId())
                    {
                        standingsModel = new StandingsModel(sacramento.getTeamId(), sacramento.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                        standingsModelsList.add(standingsModel);
                    }
                }
                for(Team utah : teamsUtah)
                {
                    if(east.getTeamId() == utah.getTeamId())
                    {
                        standingsModel = new StandingsModel(utah.getTeamId(), utah.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                        standingsModelsList.add(standingsModel);
                    }
                }
                for(Team vegas : teamsVegas)
                {
                    if(east.getTeamId() == vegas.getTeamId())
                    {
                        standingsModel = new StandingsModel(vegas.getTeamId(), vegas.getFullName(), east.getWin(), east.getLoss(), east.getWinPctV2(), east.getGamesBehind());
                        standingsModelsList.add(standingsModel);
                    }
                }
            }

            Log.d("SIZE: ",String.format("value = %d" ,standingsModelsList.size()));
            for (StandingsModel standings : standingsModelsList)
            {
                Log.i("Name: ", standings.getTeamName());
            }
        }

    }
}
