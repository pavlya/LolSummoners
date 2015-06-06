package com.tbg.pavlya.lol.fragmentstest.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavlya on 17/04/2015.
 */
public class SummonerDataSource extends AbstractDataSource {

    public SummonerDataSource(Context context) {
        super(context);
    }

    @Override
    public void clearTable() {
        // Delete all data in the table
        database.execSQL("delete from " + MySqliteHelper.USERS_TABLE);
    }

    public void addSummoner(Summoner summoner){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.ID, summoner.getId());
        contentValues.put(MySqliteHelper.SUMMONER_ID, summoner.getSummonerId());
        contentValues.put(MySqliteHelper.SUMMONER_NAME, summoner.getSummonerName());
        contentValues.put(MySqliteHelper.UPDATE_TIME, summoner.getUpdateTime());
    }

    public List<Summoner> getAllSummoners(){
        List<Summoner> summoners = new ArrayList<>();
        Cursor cursor = database.query(MySqliteHelper.USERS_TABLE, null, null, null, null, null,null);
        if(cursor.moveToFirst() && cursor.getCount() > 0){
            while(!cursor.isAfterLast()){
                Summoner summoner = cursorToSummoner(cursor);
                summoners.add(summoner);
                cursor.moveToNext();
            }
        }
        return summoners;
    }

    public Summoner cursorToSummoner(Cursor cursor){
        Summoner summoner = new Summoner();
        summoner.setId(cursor.getInt(0));
        summoner.setSummonerId(cursor.getInt(1));
        summoner.setSummonerName(cursor.getString(2));
        summoner.setUpdateTime(cursor.getString(3));

        return summoner;
    }

    public void addDumbSummoners(){
        List<Summoner> summoners = new ArrayList<>();
        summoners.add(new Summoner(111, 211, "Vasya", "12.09.1986 15:55"));
        summoners.add(new Summoner(112, 212, "Petya", "12.02.1986 14:55"));
        summoners.add(new Summoner(113, 213, "Kolya", "12.03.1986 13:55"));
    }
}

