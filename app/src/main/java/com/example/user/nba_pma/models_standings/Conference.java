package com.example.user.nba_pma.models_standings;

import java.util.ArrayList;

public class Conference {
    public ArrayList<East> east;
    public ArrayList<West> west;

    public ArrayList<East> getEast() {
        return east;
    }

    public ArrayList<West> getWest() {
        return west;
    }

    public void setEast(ArrayList<East> east) {
        this.east = east;
    }

    public void setWest(ArrayList<West> west) {
        this.west = west;
    }
}
