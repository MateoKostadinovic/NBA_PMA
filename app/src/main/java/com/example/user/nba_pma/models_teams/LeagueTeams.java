package com.example.user.nba_pma.models_teams;
import java.util.ArrayList;
public class LeagueTeams {
    public ArrayList<StandardTeams> standardTeams;
    public ArrayList<Africa> africa;
    public ArrayList<Sacramento> sacramento;
    public ArrayList<Vegas> vegas;
    public ArrayList<Utah> utah;

    public ArrayList<StandardTeams> getStandardTeams() {
        return standardTeams;
    }

    public void setStandardTeams(ArrayList<StandardTeams> standardTeams) {
        this.standardTeams = standardTeams;
    }

    public ArrayList<Africa> getAfrica() {
        return africa;
    }

    public void setAfrica(ArrayList<Africa> africa) {
        this.africa = africa;
    }

    public ArrayList<Sacramento> getSacramento() {
        return sacramento;
    }

    public void setSacramento(ArrayList<Sacramento> sacramento) {
        this.sacramento = sacramento;
    }

    public ArrayList<Vegas> getVegas() {
        return vegas;
    }

    public void setVegas(ArrayList<Vegas> vegas) {
        this.vegas = vegas;
    }

    public ArrayList<Utah> getUtah() {
        return utah;
    }

    public void setUtah(ArrayList<Utah> utah) {
        this.utah = utah;
    }
}
