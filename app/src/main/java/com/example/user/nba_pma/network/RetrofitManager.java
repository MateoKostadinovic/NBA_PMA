package com.example.user.nba_pma.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    static private RetrofitManager instance;
    private NbaApiTeams teams;
    private NbaApiStandings standings;

    private RetrofitManager()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.nba.net/10s")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        teams=retrofit.create(NbaApiTeams.class);
        standings=retrofit.create(NbaApiStandings.class);
    }

    public static RetrofitManager getInstance()
    {
        if(instance == null)
        {
            instance = new RetrofitManager();
        }
        return instance;
    }

    public NbaApiTeams getTeams()
    {
        return teams;
    }

    public NbaApiStandings getStandings()
    {
        return standings;
    }
}
