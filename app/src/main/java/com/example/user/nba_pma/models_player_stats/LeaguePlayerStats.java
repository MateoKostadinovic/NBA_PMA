package com.example.user.nba_pma.models_player_stats;

import com.google.gson.annotations.SerializedName;

public class LeaguePlayerStats {
    @SerializedName("standard")
    public StandardPlayerStats standardPlayerStats;

    public StandardPlayerStats getStandardPlayerStats() {
        return standardPlayerStats;
    }

    public void setStandardPlayerStats(StandardPlayerStats standardPlayerStats) {
        this.standardPlayerStats = standardPlayerStats;
    }
}
