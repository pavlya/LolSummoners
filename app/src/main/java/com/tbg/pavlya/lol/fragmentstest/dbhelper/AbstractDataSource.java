package com.tbg.pavlya.lol.fragmentstest.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.PriorityQueue;

/**
 * Created by Pavlya on 17/04/2015.
 */
public abstract class AbstractDataSource {
    protected MySqliteHelper sqliteHelper;
    protected SQLiteDatabase database;
    public AbstractDataSource(Context context){
        sqliteHelper = new MySqliteHelper(context);
    }
    public void open(){
        database = sqliteHelper.getWritableDatabase();
    }

    public void close(){
        if(sqliteHelper != null) {
            sqliteHelper.close();
        }
    }

    public abstract void clearTable();
}
