package com.example.user.nba_pma.models_players;

import com.google.gson.annotations.SerializedName;

public class StandardPlayers {
    @SerializedName("firstName")
    public String firstNamePlayer;
    @SerializedName("lastName")
    public String lastNamePlayerM;
    @SerializedName("personId")
    public String personIdPlayer;
    @SerializedName("jersey")
    public String jerseyPlayer;

    public StandardPlayers(String firstNamePlayer, String lastNamePlayerM, String personIdPlayer, String jerseyPlayer) {
        this.firstNamePlayer = firstNamePlayer;
        this.lastNamePlayerM = lastNamePlayerM;
        this.personIdPlayer = personIdPlayer;
        this.jerseyPlayer = jerseyPlayer;
    }

    public String getFirstNamePlayer() {
        return firstNamePlayer;
    }

    public void setFirstNamePlayer(String firstNamePlayer) {
        this.firstNamePlayer = firstNamePlayer;
    }

    public String getLastNamePlayerM() {
        return lastNamePlayerM;
    }

    public void setLastNamePlayerM(String lastNamePlayerM) {
        this.lastNamePlayerM = lastNamePlayerM;
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
}
