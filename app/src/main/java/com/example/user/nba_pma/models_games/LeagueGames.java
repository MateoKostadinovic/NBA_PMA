package com.example.user.nba_pma.models_games;

import com.example.user.nba_pma.models_standings.Standings;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LeagueGames {
    @SerializedName("standard")
    public ArrayList<StandardGames> standardGames;

    public ArrayList<StandardGames> getStandardGames() {
        return standardGames;
    }

    public void setStandardGames(ArrayList<StandardGames> standardGames) {
        this.standardGames = standardGames;
    }
}
