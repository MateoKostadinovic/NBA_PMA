package com.example.user.nba_pma.models_games;

import com.google.gson.annotations.SerializedName;

public class GamesResponse {
    @SerializedName("league")
    public LeagueGames leagueGames;

    public LeagueGames getLeagueGames() {
        return leagueGames;
    }

    public void setLeagueGames(LeagueGames leagueGames) {
        this.leagueGames = leagueGames;
    }
}
