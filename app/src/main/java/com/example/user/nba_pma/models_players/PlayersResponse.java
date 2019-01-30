package com.example.user.nba_pma.models_players;

import com.google.gson.annotations.SerializedName;

public class PlayersResponse {
    @SerializedName("league")
    public LeaguePlayers leaguePlayers;

    public LeaguePlayers getLeaguePlayers() {
        return leaguePlayers;
    }

    public void setLeaguePlayers(LeaguePlayers leaguePlayers) {
        this.leaguePlayers = leaguePlayers;
    }
}
