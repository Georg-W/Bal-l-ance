package com.example.ersgutercomputer.ballance;

import android.provider.BaseColumns;

/**
 * Created by Georg on 12.11.2016.
 */

public class DatabaseTables implements BaseColumns{

    public static final String TABLE_NAME = "highScores";
    public static final String TIME = "time";
    public static final String PLAYER = "player";

    public static final String CREATE_QUERY = "create table " + TABLE_NAME + " (" +
            _ID + " INTEGER, " +
            PLAYER + " TEXT, " +
            TIME + " TEXT)";

    public static final String DROP_QUERY = "drop table " + TABLE_NAME;
    public static final String SELECT_QUERY = "select * from " + TABLE_NAME;

}
