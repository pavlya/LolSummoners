package com.tbg.pavlya.lol.fragmentstest.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavlya on 4/11/2015.
 */
public class ChampionDataSource extends AbstractDataSource{


    public ChampionDataSource(Context context) {
        super(context);
    }

    public void addDumbChampions(){
        List<Champion> dumbChamps = new ArrayList<>();
        dumbChamps.add(new Champion(15, 22, "Ahri", 2, 4));
        dumbChamps.add(new Champion(16, 23, "Malphite", 5, 2));
        dumbChamps.add(new Champion(17, 24, "Tristana", 3, 1));
        dumbChamps.add(new Champion(18, 25, "Caitlyn", 5, 0));
        for (Champion champ: dumbChamps){
            addChampion(champ);
        }
    }

    public void clearTable(){
        // Delete all data in the table
        database.execSQL("delete from " + MySqliteHelper.CHAMPIONS_TABLE);
    }

    public void addChampion(Champion champion){
        // add champion to table
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySqliteHelper.ID, champion.getId());
        contentValues.put(MySqliteHelper.SUMMONER_ID, champion.getSummonerId());
        contentValues.put(MySqliteHelper.CHAMP_NAME, champion.getChampName());
        contentValues.put(MySqliteHelper.CHAMP_WINS, champion.getChampWins());
        contentValues.put(MySqliteHelper.CHAMP_LOSSES, champion.getChampLosses());
        database.insert(MySqliteHelper.CHAMPIONS_TABLE, null, contentValues);
    }

    public Champion getChampion(){
        return null;
    }

    public List<Champion> getAllChamps(){
        List<Champion> champions = new ArrayList<Champion>();
        Cursor cursor = database.query(MySqliteHelper.CHAMPIONS_TABLE,null,null,null,null,null,null);

        if(cursor.moveToFirst() && cursor.getCount() > 0){
            while(!cursor.isAfterLast()){
                Champion champion = cursorToChampion(cursor);
                champions.add(champion);
                cursor.moveToNext();
            }
        }
        // close cursor
        cursor.close();
        return champions;
    }

    private Champion cursorToChampion(Cursor cursor) {
        Champion champ = new Champion();
//        champ.setId(cursor.getInt(cursor.getColumnIndex(MySqliteHelper.ID)));
//        champ.setSummonerId(cursor.getInt(cursor.getColumnIndex(MySqliteHelper.SUMMONER_ID)));
//        champ.setChampName(cursor.getString(cursor.getColumnIndex(MySqliteHelper.CHAMP_NAME)));
//        champ.setChampWins(cursor.getInt(cursor.getColumnIndex(MySqliteHelper.CHAMP_WINS)));
//        champ.setChampLosses(cursor.getInt(cursor.getColumnIndex(MySqliteHelper.CHAMP_LOSSES)));
        champ.setId(cursor.getInt(0));
        champ.setSummonerId(cursor.getInt(1));
        champ.setChampName(cursor.getString(2));
        champ.setChampWins(cursor.getInt(3));
        champ.setChampLosses(cursor.getInt(4));
        return champ;
    }
}
