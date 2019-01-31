package com.example.user.nba_pma.models;

public class PlayerPositionComparison {
    public String positionKey;
    public String positionValue;

    public PlayerPositionComparison(String positionKey, String positionValue) {
        this.positionKey = positionKey;
        this.positionValue = positionValue;
    }

    public String getPositionKey() {
        return positionKey;
    }

    public void setPositionKey(String positionKey) {
        this.positionKey = positionKey;
    }

    public String getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(String positionValue) {
        this.positionValue = positionValue;
    }
}
