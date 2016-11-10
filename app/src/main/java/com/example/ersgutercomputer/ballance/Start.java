package com.example.ersgutercomputer.ballance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    void start(View v){
        Log.d("asd", "test");
        Intent i = new Intent(this, GameView.class);
        startActivity(i);
    }



}
