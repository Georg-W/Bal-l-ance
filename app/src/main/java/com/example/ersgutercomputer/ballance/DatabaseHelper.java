package com.example.ersgutercomputer.ballance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georg on 12.11.2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{


    public static final String TABLE_NAME = "highScores";
    public static final String _ID = "_id";
    public static final String TIME = "time";
    public static final String PLAYER = "player";
    public static final String LEVEL = "level";

    public static final String CREATE_DATABASE = "create table " + TABLE_NAME + " (" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            LEVEL + " INTEGER, " +
            PLAYER + " TEXT, " +
            TIME + " TEXT)";

    public static final String DROP_QUERY = "drop table if exists" + TABLE_NAME;



    public DatabaseHelper(Context context) {
        super(context, "Saves", null, 1);
        Log.d("helper","helper got created!");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATABASE);
        Log.d("helper","tables got created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        sqLiteDatabase.execSQL(DROP_QUERY);
        onCreate(sqLiteDatabase);
    }

}
