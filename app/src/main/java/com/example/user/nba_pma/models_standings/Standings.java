package com.example.user.nba_pma.models_standings;

public class Standings {
    public String teamId;
    public String win;
    public String loss;
    public String winPctV2;
    public String gamesBehind;
    public String streak;

    public Standings(String teamId, String win, String loss, String winPctV2, String gamesBehind, String streak) {
        this.teamId = teamId;
        this.win = win;
        this.loss = loss;
        this.winPctV2 = winPctV2;
        this.gamesBehind = gamesBehind;
        this.streak = streak;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getLoss() {
        return loss;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public String getWinPctV2() {
        return winPctV2;
    }

    public void setWinPctV2(String winPctV2) {
        this.winPctV2 = winPctV2;
    }

    public String getGamesBehind() {
        return gamesBehind;
    }

    public void setGamesBehind(String gamesBehind) {
        this.gamesBehind = gamesBehind;
    }

    public String getStreak() {
        return streak;
    }

    public void setStreak(String streak) {
        this.streak = streak;
    }
}
