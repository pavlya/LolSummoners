package com.tbg.pavlya.lol.fragmentstest.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavlya on 17/04/2015.
 */
public class LeaguesDataSource extends AbstractDataSource {
    public LeaguesDataSource(Context context) {
        super(context);
    }

    @Override
    public void clearTable() {
        // Delete all data in the table
        database.execSQL("delete from " + MySqliteHelper.LEAGUES_TABLE);
    }

    public void addLeague(League league){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.ID, league.getId());
        contentValues.put(MySqliteHelper.SUMMONER_ID, league.getSummonerId());
        contentValues.put(MySqliteHelper.QUEUE, league.getQueue());
        contentValues.put(MySqliteHelper.LEAGUE_NAME, league.getLeagueName());
        contentValues.put(MySqliteHelper.TIER, league.getTier());
        contentValues.put(MySqliteHelper.DIVISION, league.getDivision());
        contentValues.put(MySqliteHelper.PLAYER_NAME, league.getPlayerName());
        contentValues.put(MySqliteHelper.WINS, league.getWins());
        contentValues.put(MySqliteHelper.LOSSES, league.getLosses());
        database.insert(MySqliteHelper.LEAGUES_TABLE, null, contentValues);
    }

//    public League getLeague(int leagueID){
//        return null;
//    }

    public List<League> getAllLeagues(int summonerID){
        List<League> leagues = new ArrayList<>();
        Cursor cursor = database.query(MySqliteHelper.LEAGUES_TABLE, null,null,null,null,null,null);
        if(cursor.moveToFirst() && cursor.getCount() > 0){
            while (!cursor.isAfterLast()){
                League league = cursorToLeague(cursor);
                leagues.add(league);
                cursor.moveToNext();
            }
        }
        return leagues;
    }

    public League cursorToLeague(Cursor cursor){
        League league = new League();
        league.setId(cursor.getInt(0));
        league.setSummonerId(cursor.getInt(1));
        league.setQueue(cursor.getString(2));
        league.setLeagueName(cursor.getString(3));
        league.setTier(cursor.getString(4));
        league.setDivision(cursor.getString(5));
        league.setPlayerName(cursor.getString(6));
        league.setWins(cursor.getInt(7));
        league.setLosses(cursor.getInt(8));
        return league;
    }

    public void addDumbLeagues(){
        List<League> dumbLeagues = new ArrayList<>();
        dumbLeagues.add(new League(31, 14, "Some queue", "League name", "Ties", "Second division", "Player name", 5, 3));
        dumbLeagues.add(new League(31, 14, "Another queue", "League name", "Tier", "Second division", "Player name", 5, 3));
        dumbLeagues.add(new League(31, 14, "And another queue", "League name", "Tier", "bronze division", "Nepuh", 15, 1));
        for (League league: dumbLeagues){
            addLeague(league);
        }
    }
}
