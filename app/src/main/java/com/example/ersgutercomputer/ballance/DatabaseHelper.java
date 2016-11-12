package com.example.ersgutercomputer.ballance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Georg on 12.11.2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(Context context) {
        super(context, "Saves", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseTables.CREATE_QUERY);
        setSaves(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DatabaseTables.DROP_QUERY);
        sqLiteDatabase.execSQL(DatabaseTables.CREATE_QUERY);
    }

    private void setSaves(SQLiteDatabase sqLiteDatabase){

        List<Save> saves = asList(
                new Save("Georg","1:23"),
                new Save("Flo","5:23"),
                new Save("Tobi","7:23"),
                new Save("Michael","2:33"),
                new Save("Tobias","1:13"));

        for (Save save: saves) {
            ContentValues values = new ContentValues();
            values.put(DatabaseTables.PLAYER, save.getPlayerString());
            values.put(DatabaseTables.TIME, save.getTimeString());

            sqLiteDatabase.insert(DatabaseTables.TABLE_NAME, null, values);
        }
    }

    public Cursor getSaveCursor() {
        return this.getWritableDatabase().rawQuery(DatabaseTables.SELECT_QUERY, null);
    }
}
