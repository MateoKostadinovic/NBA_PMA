package com.example.user.nba_pma.models_teams;

public class Utah {
    public String fullName;
    public String teamId;

    public String getFullName() {
        return fullName;
    }

    public Utah(String fullName, String teamId) {
        this.fullName = fullName;
        this.teamId = teamId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
