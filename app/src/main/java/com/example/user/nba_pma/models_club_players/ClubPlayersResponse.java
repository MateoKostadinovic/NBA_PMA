package com.example.user.nba_pma.models_club_players;

import com.google.gson.annotations.SerializedName;

public class ClubPlayersResponse {
    @SerializedName("league")
    public LeagueClubPlayers leagueClubPlayers;

    public LeagueClubPlayers getLeagueClubPlayers() {
        return leagueClubPlayers;
    }

    public void setLeagueClubPlayers(LeagueClubPlayers leagueClubPlayers) {
        this.leagueClubPlayers = leagueClubPlayers;
    }
}
