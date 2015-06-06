package com.tbg.pavlya.lol.fragmentstest.dbhelper;

/**
 * Created by Pavlya on 3/31/2015.
 */
public class League {
    private int id;
    private int summonerId;
    private String queue;
    private String leagueName;
    private String tier;
    private String division;
    private String playerName;
    private int wins;
    private int losses;

    public League(){

    }

    public League(int id, int summonerId, String queue, String leagueName, String tier, String division, String playerName, int wins, int losses) {
        this.id = id;
        this.summonerId = summonerId;
        this.queue = queue;
        this.leagueName = leagueName;
        this.tier = tier;
        this.division = division;
        this.playerName = playerName;
        this.wins = wins;
        this.losses = losses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(int summonerId) {
        this.summonerId = summonerId;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
