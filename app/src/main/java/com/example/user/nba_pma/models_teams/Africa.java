package com.example.user.nba_pma.models_teams;

public class Africa {
    public String fullName;
    public String teamId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Africa(String fullName, String teamId) {
        this.fullName = fullName;
        this.teamId = teamId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
