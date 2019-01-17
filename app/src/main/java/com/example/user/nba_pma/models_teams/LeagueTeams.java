package com.example.user.nba_pma.models_teams;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
public class LeagueTeams {
    @SerializedName("standard")
    public ArrayList<Team> standardTeams;
    public ArrayList<Team> africa;
    public ArrayList<Team> sacramento;
    public ArrayList<Team> vegas;
    public ArrayList<Team> utah;

    public ArrayList<Team> getStandardTeams() {
        return standardTeams;
    }

    public void setStandardTeams(ArrayList<Team> standardTeams) {
        this.standardTeams = standardTeams;
    }

    public ArrayList<Team> getAfrica() {
        return africa;
    }

    public void setAfrica(ArrayList<Team> africa) {
        this.africa = africa;
    }

    public ArrayList<Team> getSacramento() {
        return sacramento;
    }

    public void setSacramento(ArrayList<Team> sacramento) {
        this.sacramento = sacramento;
    }

    public ArrayList<Team> getVegas() {
        return vegas;
    }

    public void setVegas(ArrayList<Team> vegas) {
        this.vegas = vegas;
    }

    public ArrayList<Team> getUtah() {
        return utah;
    }

    public void setUtah(ArrayList<Team> utah) {
        this.utah = utah;
    }




}
