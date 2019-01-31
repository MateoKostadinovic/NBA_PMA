package com.example.user.nba_pma.models_players;

import com.google.gson.annotations.SerializedName;

public class StandardPlayers {
    @SerializedName("firstName")
    public String firstNamePlayer;
    @SerializedName("lastName")
    public String lastNamePlayer;
    @SerializedName("personId")
    public String personIdPlayer;
    @SerializedName("jersey")
    public String jerseyPlayer;
    @SerializedName("pos")
    public String positionPlayer;

    public StandardPlayers(String firstNamePlayer, String lastNamePlayer, String personIdPlayer, String jerseyPlayer, String positionPlayer) {
        this.firstNamePlayer = firstNamePlayer;
        this.lastNamePlayer = lastNamePlayer;
        this.personIdPlayer = personIdPlayer;
        this.jerseyPlayer = jerseyPlayer;
        this.positionPlayer = positionPlayer;
    }

    public String getFirstNamePlayer() {
        return firstNamePlayer;
    }

    public void setFirstNamePlayer(String firstNamePlayer) {
        this.firstNamePlayer = firstNamePlayer;
    }

    public String getLastNamePlayer() {
        return lastNamePlayer;
    }

    public void setLastNamePlayerM(String lastNamePlayerM) {
        this.lastNamePlayer = lastNamePlayerM;
    }

    public String getPersonIdPlayer() {
        return personIdPlayer;
    }

    public void setPersonIdPlayer(String personIdPlayer) {
        this.personIdPlayer = personIdPlayer;
    }

    public String getJerseyPlayer() {
        return jerseyPlayer;
    }

    public void setJerseyPlayer(String jerseyPlayer) {
        this.jerseyPlayer = jerseyPlayer;
    }

    public String getPositionPlayer() {
        return positionPlayer;
    }

    public void setPositionPlayer(String positionPlayer) {
        this.positionPlayer = positionPlayer;
    }
}
