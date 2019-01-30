package com.example.user.nba_pma.models_club_players;

import com.google.gson.annotations.SerializedName;

public class LeagueClubPlayers {
    @SerializedName("standard")
    public StandardClubPlayers standardClubPlayers;

    public StandardClubPlayers getStandardClubPlayers() {
        return standardClubPlayers;
    }

    public void setStandardClubPlayers(StandardClubPlayers standardClubPlayers) {
        this.standardClubPlayers = standardClubPlayers;
    }
}
