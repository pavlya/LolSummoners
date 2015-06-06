package com.tbg.pavlya.lol.fragmentstest.dbhelper;

/**
 * Created by Pavlya on 3/31/2015.
 */
public class Summoner {
    private int id;
    private long summonerId;
    private String summonerName;
    private String updateTime;

    public Summoner(){

    }

    public Summoner(int id, long summonerId, String summonerName, String updateTime) {
        this.id = id;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
