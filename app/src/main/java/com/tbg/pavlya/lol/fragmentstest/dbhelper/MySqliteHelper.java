package com.tbg.pavlya.lol.fragmentstest.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Pavlya on 3/29/2015.
 */
public class MySqliteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "summoners.db";
    public static final int DB_VERSION = 1;
    public static final String CHAMPIONS_TABLE = "[champions_table]";
    public static final String ID = "[_id]";
    public static final String SUMMONER_ID = "[summoner_id]";
    public static final String CHAMP_NAME = "[champ_name]";
    public static final String CHAMP_WINS = "[champ_wins]";
    public static final String CHAMP_LOSSES = "[champ_losses]";

    public static final String LEAGUES_TABLE = "[leagues_table]";
    public static final String USERS_TABLE = "[users_table]";

    public static final String QUEUE = "[queue]";
    public static final String LEAGUE_NAME = "[league_name]";
    public static final String TIER = "[tier]";
    public static final String DIVISION = "[division]";
    public static final String PLAYER_NAME = "[player_name]";
    public static final String WINS = "[wins]";
    public static final String LOSSES = "[losses]";
    public static final String SUMMONER_NAME = "[summoner_name]";
    public static final String UPDATE_TIME = "[update_time]";

    public static final String CREATE_CHAMPIONS_TABLE = "CREATE TABLE " + CHAMPIONS_TABLE + " (" +
            "  " + ID + " INT NOT NULL, " +
            "  " + SUMMONER_ID + " BIGINT NOT NULL, " +
            "  " + CHAMP_NAME + " CHAR NOT NULL, " +
            "  " + CHAMP_WINS + " CHAR, " +
            "  " + CHAMP_LOSSES + " CHAR);";

    public static final String CREATE_LEAGUES_TABLE = "CREATE TABLE " + LEAGUES_TABLE + " (" +
            "  " + ID + " INT NOT NULL, " +
            "  " + SUMMONER_ID + " INT, " +
            "  " + QUEUE + " CHAR, " +
            "  " + LEAGUE_NAME + " CHAR, " +
            "  " + TIER + " CHAR, " +
            "  " + DIVISION + " CHAR, " +
            "  " + PLAYER_NAME + " CHAR, " +
            "  " + WINS + " INT, " +
            "  " + LOSSES + " INT);";

    public static final String CREATE_USERS_TABLE = "CREATE TABLE " + USERS_TABLE + " (" +
            "  " + ID + " INT NOT NULL ON CONFLICT ROLLBACK, " +
            "  " + SUMMONER_ID + " BIGINT NOT NULL, " +
            "  " + SUMMONER_NAME + " CHAR NOT NULL, " +
            "  " + UPDATE_TIME + " DATETIME);";


    public MySqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_CHAMPIONS_TABLE);
        db.execSQL(CREATE_LEAGUES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySqliteHelper.class.getName(), "Upgrading database from version "
                + oldVersion + " to version " + newVersion +
                ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS" + USERS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + CHAMPIONS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + LEAGUES_TABLE);

        // create new tables
        onCreate(db);
    }
}
