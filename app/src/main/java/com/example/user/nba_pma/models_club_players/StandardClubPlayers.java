package com.example.user.nba_pma.models_club_players;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StandardClubPlayers {
    @SerializedName("players")
    public ArrayList<ClubPlayer> clubPlayers = new ArrayList<>();

    public ArrayList<ClubPlayer> getClubPlayers() {
        return clubPlayers;
    }

    public void setClubPlayers(ArrayList<ClubPlayer> clubPlayers) {
        this.clubPlayers = clubPlayers;
    }
}
