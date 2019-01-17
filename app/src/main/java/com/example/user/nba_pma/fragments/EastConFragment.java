package com.example.user.nba_pma.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.nba_pma.R;
import com.example.user.nba_pma.models_standings.Conference;
import com.example.user.nba_pma.models_standings.East;
import com.example.user.nba_pma.models_standings.League;
import com.example.user.nba_pma.models_standings.Standard;
import com.example.user.nba_pma.models_standings.StandingsResponse;
import com.example.user.nba_pma.models_standings.West;
import com.example.user.nba_pma.models_teams.Africa;
import com.example.user.nba_pma.models_teams.LeagueTeams;
import com.example.user.nba_pma.models_teams.Sacramento;
import com.example.user.nba_pma.models_teams.StandardTeams;
import com.example.user.nba_pma.models_teams.TeamsResponse;
import com.example.user.nba_pma.models_teams.Utah;
import com.example.user.nba_pma.models_teams.Vegas;
import com.example.user.nba_pma.network.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<StandardTeams> teamsStandard = new ArrayList<>();
        ArrayList<Africa> teamsAfrica = new ArrayList<>();
        ArrayList<Sacramento> teamsSacramento = new ArrayList<>();
        ArrayList<Utah> teamsUtah = new ArrayList<>();
        ArrayList<Vegas> teamsVegas = new ArrayList<>();

        ArrayList<East> eastStandings = new ArrayList<>();
        ArrayList<West> westStandings = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_east_con,container,false);
        textViewEast = (TextView)view.findViewById(R.id.textViewEast);

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
                    LeagueTeams leagueTeams = response.body().getLeagueTeams();
                    /*ArrayList<StandardTeams> standardTeams = leagueTeams.getStandardTeams();//baca neki error da je null
                    ArrayList<Africa> africaTeams = leagueTeams.getAfrica();
                    ArrayList<Sacramento> sacramentoTeams = leagueTeams.getSacramento();
                    ArrayList<Utah> utahTeams = leagueTeams.getUtah();
                    ArrayList<Vegas> vegasTeams = leagueTeams.getVegas();

                    textTeam = sacramentoTeams.toString();
                    for(StandardTeams oStandardTeams : standardTeams)
                    {
                        teamsStandard.add(new StandardTeams(oStandardTeams.getFullName(), oStandardTeams.getTeamId()));
                    }

                    for(Africa oAficaTeams : africaTeams)
                    {
                        teamsAfrica.add(new Africa(oAficaTeams.getFullName(), oAficaTeams.getTeamId()));
                    }

                    for(Sacramento oSacramentoTeams : sacramentoTeams)
                    {
                        teamsSacramento.add(new Sacramento(oSacramentoTeams.getFullName(), oSacramentoTeams.getTeamId()));
                    }

                    for(Utah oUtahTeams : utahTeams)
                    {
                        teamsUtah.add(new Utah(oUtahTeams.getFullName(), oUtahTeams.getTeamId()));
                    }

                    for(Vegas oVegasTeams : vegasTeams)
                    {
                        teamsVegas.add(new Vegas(oVegasTeams.getFullName(), oVegasTeams.getTeamId()));
                    }*/

                }
                else
                {
                    //textTeam = "nista od toga";
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
                    League league = response.body().getLeague();
                    Standard standard = league.getStandard();
                    Conference conference = standard.getConference();
                    ArrayList<East> east = conference.getEast();
                    text = east.toString();


                    for(East oEastStandings : east)
                    {
                        eastStandings.add(new East(oEastStandings.getTeamId(), oEastStandings.getWin(), oEastStandings.getLoss(), oEastStandings.getWinPctV2(), oEastStandings.getGamesBehind(), oEastStandings.getStreak()));
                    }

                }
                else
                {
                    text = "nista od toga";
                }
                setText(text);
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
}
