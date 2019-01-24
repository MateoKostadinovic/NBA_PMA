package com.example.user.nba_pma.models_teams;

import com.google.gson.annotations.SerializedName;

public class TeamsResponse {
    @SerializedName("league")
    public LeagueTeams leagueTeams;


    public LeagueTeams getLeagueTeams() {
        return leagueTeams;
    }

    public void setLeagueTeams(LeagueTeams leagueTeams) {
        this.leagueTeams = leagueTeams;
    }
}
