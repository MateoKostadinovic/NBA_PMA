package com.example.user.nba_pma.models_club_players;

import com.google.gson.annotations.SerializedName;

public class ClubPlayer {
    @SerializedName("personId")
    public String sClubPlayerId;

    public String getsClubPlayerId() {
        return sClubPlayerId;
    }

    public void setsClubPlayerId(String sClubPlayerId) {
        this.sClubPlayerId = sClubPlayerId;
    }
}
