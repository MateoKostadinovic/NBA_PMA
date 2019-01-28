package com.example.user.nba_pma.network;

import com.example.user.nba_pma.models_games.GamesResponse;
import com.example.user.nba_pma.models_standings.StandingsResponse;
import com.example.user.nba_pma.models_teams.TeamsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NbaApi {
    @GET("prod/v1/current/standings_conference.json")
    Call<StandingsResponse> getStandingsLeague();

    @GET("prod/v2/2018/teams.json")
    Call<TeamsResponse> getTeamsLeague();

    @GET("prod/v1/2018/teams/{teamId}/schedule.json")
    Call<GamesResponse> getTeamGames(@Path("teamId") int id);
}
