package com.example.user.nba_pma.models_player_stats;

import com.google.gson.annotations.SerializedName;

public class PlayerStatsResponse {
    @SerializedName("league")
    public LeaguePlayerStats leaguePlayerStats;

    public LeaguePlayerStats getLeaguePlayerStats() {
        return leaguePlayerStats;
    }

    public void setLeaguePlayerStats(LeaguePlayerStats leaguePlayerStats) {
        this.leaguePlayerStats = leaguePlayerStats;
    }
}
