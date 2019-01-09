package com.example.user.nba_pma.models_standings;

public class East {
    public String teamId;
    public String win;
    public String loss;
    public String winPctV2;
    public String gamesBehind;
    public String streak;

    public String getTeamId() {
        return teamId;
    }

    public String getWin() {
        return win;
    }

    public String getLoss() {
        return loss;
    }

    public String getWinPctV2() {
        return winPctV2;
    }

    public String getGamesBehind() {
        return gamesBehind;
    }

    public String getStreak() {
        return streak;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public void setLoss(String loss) {
        this.loss = loss;
    }

    public void setWinPctV2(String winPctV2) {
        this.winPctV2 = winPctV2;
    }

    public void setGamesBehind(String gamesBehind) {
        this.gamesBehind = gamesBehind;
    }

    public void setStreak(String streak) {
        this.streak = streak;
    }
}
