package com.example.user.nba_pma.models;

public class ClubGamesModel {
    public String sTeamVName;
    public String sTeamHName;
    public String sTeamVScore;
    public String sTeamHScore;
    public String sDate;

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getsTeamVName() {
        return sTeamVName;
    }

    public void setsTeamVName(String sTeamVName) {
        this.sTeamVName = sTeamVName;
    }

    public String getsTeamHName() {
        return sTeamHName;
    }

    public void setsTeamHName(String sTeamHName) {
        this.sTeamHName = sTeamHName;
    }

    public String getsTeamVScore() {
        return sTeamVScore;
    }

    public void setsTeamVScore(String sTeamVScore) {
        this.sTeamVScore = sTeamVScore;
    }

    public String getsTeamHScore() {
        return sTeamHScore;
    }

    public void setsTeamHScore(String sTeamHScore) {
        this.sTeamHScore = sTeamHScore;
    }

    public ClubGamesModel(String sTeamVName, String sTeamHName, String sTeamVScore, String sTeamHScore, String sDate) {
        this.sTeamVName = sTeamVName;
        this.sTeamHName = sTeamHName;
        this.sTeamVScore = sTeamVScore;
        this.sTeamHScore = sTeamHScore;
        this.sDate = sDate;
    }
}
