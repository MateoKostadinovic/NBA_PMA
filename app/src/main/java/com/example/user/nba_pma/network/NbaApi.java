package com.example.user.nba_pma.network;

import com.example.user.nba_pma.models_standings.StandingsResponse;
import com.example.user.nba_pma.models_teams.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NbaApi {
    @GET("prod/v1/current/standings_conference.json")
    Call<StandingsResponse> getStandingsLeague();

    @GET("prod/v2/2018/teams.json")
    Call<TeamsResponse> getTeamsLeague();
}
