package com.example.user.nba_pma.models_teams;
import java.util.ArrayList;
public class League {
    public ArrayList<Standard> standard;
    public ArrayList<Africa> africa;
    public ArrayList<Sacramento> sacramento;
    public ArrayList<Vega> vegas;
    public ArrayList<Utah> utah;

    public ArrayList<Standard> getStandard() {
        return standard;
    }

    public void setStandard(ArrayList<Standard> standard) {
        this.standard = standard;
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

    public ArrayList<Vega> getVegas() {
        return vegas;
    }

    public void setVegas(ArrayList<Vega> vegas) {
        this.vegas = vegas;
    }

    public ArrayList<Utah> getUtah() {
        return utah;
    }

    public void setUtah(ArrayList<Utah> utah) {
        this.utah = utah;
    }
}
