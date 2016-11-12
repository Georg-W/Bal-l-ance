package com.example.ersgutercomputer.ballance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultScreen extends AppCompatActivity {

    public static final String Saved_Results = "SavedResults";

private String timeString;
private String playerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        Intent intent = getIntent();
        timeString = intent.getStringExtra(Intent.EXTRA_TEXT);
        TextView timeView = (TextView) findViewById(R.id.timeView);
        timeView.setText(timeString);

        SharedPreferences settings = getSharedPreferences(Saved_Results, 0);
        String lastResult = settings.getString("timeResult","17");
        Toast.makeText(this, ""+lastResult, Toast.LENGTH_SHORT).show();
    }

    void onSave(View v){
        EditText name = (EditText) findViewById(R.id.playerName);
        playerString = name.getText().toString();

        SharedPreferences settings = getSharedPreferences(Saved_Results, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("timeResult", timeString);
        editor.putString("playerName", playerString);
        editor.commit();
    }

    void onRestartGame(View v){
        Intent i = new Intent(this, Start.class);
        startActivity(i);
    }
}
