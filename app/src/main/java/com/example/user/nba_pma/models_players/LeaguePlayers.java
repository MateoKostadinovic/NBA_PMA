package com.example.user.nba_pma.models_players;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LeaguePlayers {
    @SerializedName("standard")
    public ArrayList<StandardPlayers> standardPlayers;

    public ArrayList<StandardPlayers> getStandardPlayers() {
        return standardPlayers;
    }

    public void setStandardPlayers(ArrayList<StandardPlayers> standardPlayers) {
        this.standardPlayers = standardPlayers;
    }
}
