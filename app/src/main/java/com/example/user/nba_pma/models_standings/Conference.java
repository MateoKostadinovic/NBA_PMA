package com.example.user.nba_pma.models_standings;

import java.util.ArrayList;

public class Conference {
    public ArrayList<Standings> east;
    public ArrayList<Standings> west;

    public ArrayList<Standings> getEast() {
        return east;
    }

    public ArrayList<Standings> getWest() {
        return west;
    }

    public void setEast(ArrayList<Standings> east) {
        this.east = east;
    }

    public void setWest(ArrayList<Standings> west) {
        this.west = west;
    }
}
