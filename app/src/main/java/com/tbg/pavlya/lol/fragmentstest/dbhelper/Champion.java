package com.tbg.pavlya.lol.fragmentstest.dbhelper;

/**
 * Created by Pavlya on 3/31/2015.
 */
public class Champion {
    private int id;
    private int summonerId;
    private String champName;
    private int champWins;
    private int champLosses;

    public Champion(){

    }

    public Champion(int id, int summonerId, String champName, int champWins, int champLosses) {
        this.id = id;
        this.summonerId = summonerId;
        this.champName = champName;
        this.champWins = champWins;
        this.champLosses = champLosses;
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

    public String getChampName() {
        return champName;
    }

    public void setChampName(String champName) {
        this.champName = champName;
    }

    public int getChampWins() {
        return champWins;
    }

    public void setChampWins(int champWins) {
        this.champWins = champWins;
    }

    public int getChampLosses() {
        return champLosses;
    }

    public void setChampLosses(int champLosses) {
        this.champLosses = champLosses;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", summonerId=" + summonerId +
                ", champName='" + champName + '\'' +
                ", champWins=" + champWins +
                ", champLosses=" + champLosses +
                '}';
    }
}
