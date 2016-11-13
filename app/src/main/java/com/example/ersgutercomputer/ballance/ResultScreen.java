package com.example.ersgutercomputer.ballance;


import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class ResultScreen extends ListActivity {

private SaveDataSource datasource;


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

        List<Save> values = datasource.getAllSaves();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Save> adapter = new ArrayAdapter<Save>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);


        /*Intent intent = getIntent();
        timeString = intent.getStringExtra(Intent.EXTRA_TEXT);
        TextView timeView = (TextView) findViewById(R.id.timeView);
        timeView.setText(timeString);*/
    }


    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Save> adapter = (ArrayAdapter<Save>) getListAdapter();
        Save save = null;
        switch (view.getId()) {
            case R.id.add:

                save = datasource.createSave(1,": Georg","2:01");
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


    /*void onSave(View v){
        EditText name = (EditText) findViewById(R.id.playerName);
        playerString = name.getText().toString();

    }

    void onRestartGame(View v){
        Intent i = new Intent(this, Start.class);
        startActivity(i);
    }*/


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
