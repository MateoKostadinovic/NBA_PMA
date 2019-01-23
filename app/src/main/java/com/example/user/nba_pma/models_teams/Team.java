package com.example.user.nba_pma.models_teams;

import android.support.annotation.NonNull;

public class Team {
    public String fullName;
    public String teamId;

    public Team(String fullName, String teamId) {
        this.fullName = fullName;
        this.teamId = teamId;
    }

    public String getFullName() {
        return fullName;
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

    @NonNull
    @Override
    public String toString() {
        return "NAZIV: " + fullName;
    }
}
