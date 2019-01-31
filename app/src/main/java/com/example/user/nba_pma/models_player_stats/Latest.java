package com.example.user.nba_pma.models_player_stats;

public class Latest {
    public String mpg;
    public String fgp;
    public String tpp;
    public String ftp;
    public String ppg;
    public String rpg;
    public String apg;
    public String bpg;

    public Latest(String mpg, String fgp, String tpp, String ftp, String ppg, String rpg, String apg, String bpg) {
        this.mpg = mpg;
        this.fgp = fgp;
        this.tpp = tpp;
        this.ftp = ftp;
        this.ppg = ppg;
        this.rpg = rpg;
        this.apg = apg;
        this.bpg = bpg;
    }

    public String getMpg() {
        return mpg;
    }

    public void setMpg(String mpg) {
        this.mpg = mpg;
    }

    public String getFgp() {
        return fgp;
    }

    public void setFgp(String fgp) {
        this.fgp = fgp;
    }

    public String getTpp() {
        return tpp;
    }

    public void setTpp(String tpp) {
        this.tpp = tpp;
    }

    public String getFtp() {
        return ftp;
    }

    public void setFtp(String ftp) {
        this.ftp = ftp;
    }

    public String getPpg() {
        return ppg;
    }

    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    public String getRpg() {
        return rpg;
    }

    public void setRpg(String rpg) {
        this.rpg = rpg;
    }

    public String getApg() {
        return apg;
    }

    public void setApg(String apg) {
        this.apg = apg;
    }

    public String getBpg() {
        return bpg;
    }

    public void setBpg(String bpg) {
        this.bpg = bpg;
    }
}
