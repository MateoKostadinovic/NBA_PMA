package com.example.user.nba_pma.models_player_stats;

import com.google.gson.annotations.SerializedName;

public class StandardPlayerStats {
    @SerializedName("stats")
    public StatsPlayer statsPlayer;

    public StatsPlayer getStatsPlayer() {
        return statsPlayer;
    }

    public void setStatsPlayer(StatsPlayer statsPlayer) {
        this.statsPlayer = statsPlayer;
    }
}
