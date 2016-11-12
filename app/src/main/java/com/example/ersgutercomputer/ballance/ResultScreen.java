package com.example.ersgutercomputer.ballance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ResultScreen extends AppCompatActivity {

private String timeString;
private String playerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);
        ListView saveList = (ListView) findViewById(R.id.save_list2);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        String[] from = new String[] {DatabaseTables.PLAYER,DatabaseTables.TIME};
        int[] to = new int[] {R.id.save_playerName,R.id.save_time};

        SimpleCursorAdapter sa = new SimpleCursorAdapter(this, R.layout.save_row, databaseHelper.getSaveCursor(),from, to);

        saveList.setAdapter(sa);

        /*Intent intent = getIntent();
        timeString = intent.getStringExtra(Intent.EXTRA_TEXT);
        TextView timeView = (TextView) findViewById(R.id.timeView);
        timeView.setText(timeString);*/
    }

    /*void onSave(View v){
        EditText name = (EditText) findViewById(R.id.playerName);
        playerString = name.getText().toString();

    }

    void onRestartGame(View v){
        Intent i = new Intent(this, Start.class);
        startActivity(i);
    }*/
}
