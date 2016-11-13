package com.example.ersgutercomputer.ballance;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

public class ResultScreen extends ListActivity {

private SaveDataSource datasource;

private int level = 1;
private String player;
private String time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        datasource = new SaveDataSource(this);
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Save> values = datasource.getHighScores();

        ArrayAdapter<Save> adapter = new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);


        Intent intent = getIntent();
        time = intent.getStringExtra(Intent.EXTRA_TEXT);
        TextView timeView = (TextView) findViewById(R.id.timeView);
        timeView.setText(time);
    }


    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Save> adapter = (ArrayAdapter<Save>) getListAdapter();
        Save save = null;
        switch (view.getId()) {
            case R.id.add:
                EditText name = (EditText) findViewById(R.id.playerText);
                player = name.getText().toString();
                save = datasource.createSave(level,player,time);
                adapter.add(save);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    save = (Save) getListAdapter().getItem(0);
                    datasource.deleteSave(save);
                    adapter.remove(save);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }


    void onRestartGame(View v){
        Intent i = new Intent(this, Start.class);
        startActivity(i);
    }


    @Override
    protected void onResume() {
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}
