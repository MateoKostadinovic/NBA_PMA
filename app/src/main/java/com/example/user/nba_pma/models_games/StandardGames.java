package com.example.user.nba_pma.models_games;

import java.util.Date;

public class StandardGames {
    public TeamGames vTeam;
    public TeamGames hTeam;
    public String startTimeUTC;

    public String getStartTimeUTC() {
        return startTimeUTC;
    }

    public void setStartTimeUTC(String startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

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
