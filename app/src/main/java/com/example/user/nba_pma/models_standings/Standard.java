package com.example.user.nba_pma.models_standings;

public class Standard {
    public int seasonYear;
    public int seasonStageId;
    public Conference conference;

    public int getSeasonYear() {
        return seasonYear;
    }

    public int getSeasonStageId() {
        return seasonStageId;
    }

    public Conference getConference() {
        return conference;
    }

    public void setSeasonYear(int seasonYear) {
        this.seasonYear = seasonYear;
    }

    public void setSeasonStageId(int seasonStageId) {
        this.seasonStageId = seasonStageId;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
