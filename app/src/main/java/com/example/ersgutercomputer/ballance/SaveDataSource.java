package com.example.ersgutercomputer.ballance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georg on 13.11.2016.
 */

public class SaveDataSource {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = { DatabaseHelper._ID,
            DatabaseHelper.LEVEL,DatabaseHelper.PLAYER,DatabaseHelper.TIME };

    public SaveDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Save createSave(int level, String player, String time){
        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.LEVEL, level);
        values.put(DatabaseHelper.PLAYER, player);
        values.put(DatabaseHelper.TIME, time);
        Log.d("setSaves","saved to Database");

        database.insert(DatabaseHelper.TABLE_NAME, null, values);

        long insertId = database.insert(DatabaseHelper.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,
                allColumns, DatabaseHelper._ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Save newSave = cursorToSave(cursor);
        cursor.close();
        return newSave;
    }

    public void deleteSave(Save save){
        long id = save.getId();
        System.out.println("Comment deleted with id: " + id);
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID
                + " = " + id, null);
    }

    public List<Save> getAllSaves() {
        List<Save> saves = new ArrayList<>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Save save = cursorToSave(cursor);
            saves.add(save);
            cursor.moveToNext();
        }
        cursor.close();
        return saves;
    }

    public List<Save> getHighScores(){

        String where = null;
        String whereArgs[];
        String groupBy = null;
        String having = null;
        String order = DatabaseHelper.TIME +" asc";


        List<Save> saves = new ArrayList<>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,
                allColumns, null, null, null, null, order);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Save save = cursorToSave(cursor);
            saves.add(save);
            cursor.moveToNext();
        }
        cursor.close();
        return saves;
    }

    private Save cursorToSave(Cursor cursor) {
        Save save = new Save();
        save.setId(cursor.getLong(0));
        save.setLevel(cursor.getInt(1));
        save.setPlayer(cursor.getString(2));
        save.setTime(cursor.getString(3));
        return save;
    }

}
