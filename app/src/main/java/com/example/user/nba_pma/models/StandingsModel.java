package com.example.user.nba_pma.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class StandingsModel implements Parcelable {
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

    protected StandingsModel(Parcel in) {
        TeamId = in.readString();
        TeamName = in.readString();
        TeamWin = in.readString();
        TeamLoss = in.readString();
        TeamWinPctV2 = in.readString();
        TeamGamesBehind = in.readString();
    }

    public static final Creator<StandingsModel> CREATOR = new Creator<StandingsModel>() {
        @Override
        public StandingsModel createFromParcel(Parcel in) {
            return new StandingsModel(in);
        }

        @Override
        public StandingsModel[] newArray(int size) {
            return new StandingsModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TeamId);
        dest.writeString(TeamName);
    }
}
