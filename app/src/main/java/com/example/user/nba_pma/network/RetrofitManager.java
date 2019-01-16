package com.example.user.nba_pma.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    static private RetrofitManager instance;
    private NbaApi api;

    private RetrofitManager()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.nba.net/10s")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api=retrofit.create(NbaApi.class);
    }

    public static RetrofitManager getInstance()
    {
        if(instance == null)
        {
            instance = new RetrofitManager();
        }
        return instance;
    }

    public NbaApi getApi()
    {
        return api;
    }
}
