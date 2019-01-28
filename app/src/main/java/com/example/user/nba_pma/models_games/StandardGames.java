package com.example.user.nba_pma.models_games;

public class StandardGames {
    public TeamGames vTeam;
    public TeamGames hTeam;

    public TeamGames getvTeam() {
        return vTeam;
    }

    public void setvTeam(TeamGames vTeam) {
        this.vTeam = vTeam;
    }

    public TeamGames gethTeam() {
        return hTeam;
    }

    public void sethTeam(TeamGames hTeam) {
        this.hTeam = hTeam;
    }
}
