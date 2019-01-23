package com.example.user.nba_pma.models;

import java.util.ArrayList;

public class StandingsModel {
    public String TeamId;
    public String TeamName;
    public String TeamWin;
    public String TeamLoss;
    public String TeamWinPctV2;
    public String TeamGamesBehind;
    //public String TeamStreak;

    public StandingsModel(String teamId, String teamName, String teamWin, String teamLoss, String teamWinPctV2, String teamGamesBehind) {
        TeamId = teamId;
        TeamName = teamName;
        TeamWin = teamWin;
        TeamLoss = teamLoss;
        TeamWinPctV2 = teamWinPctV2;
        TeamGamesBehind = teamGamesBehind;
    }

    public String getTeamId() {
        return TeamId;
    }

    public void setTeamId(String teamId) {
        TeamId = teamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getTeamWin() {
        return TeamWin;
    }

    public void setTeamWin(String teamWin) {
        TeamWin = teamWin;
    }

    public String getTeamLoss() {
        return TeamLoss;
    }

    public void setTeamLoss(String teamLoss) {
        TeamLoss = teamLoss;
    }

    public String getTeamWinPctV2() {
        return TeamWinPctV2;
    }

    public void setTeamWinPctV2(String teamWinPctV2) {
        TeamWinPctV2 = teamWinPctV2;
    }

    public String getTeamGamesBehind() {
        return TeamGamesBehind;
    }

    public void setTeamGamesBehind(String teamGamesBehind) {
        TeamGamesBehind = teamGamesBehind;
    }
}
