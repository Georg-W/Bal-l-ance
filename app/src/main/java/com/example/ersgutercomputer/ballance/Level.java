package com.example.ersgutercomputer.ballance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by georg on 17.11.2016.
 */

public class Level extends View {

    int levelCount = 1;
    Level_1 level1 = new Level_1(this.getContext());
    Level_2 level2 = new Level_2(this.getContext());
    private long startTime;
    String[] times = new String[2];
    String time1;

    public Level(Context context) {
        super(context);
    }

    public Level(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Level(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        startTime = System.currentTimeMillis();
        switch (levelCount){
            case 1:
                level1.onDraw(canvas);
                break;
            case 2:
                level2.onDraw(canvas);
                break;
            default:
                break;
        }
    }

    void changePosition(float a, float b){
        switch (levelCount){
            case 1:
                level1.changePosition(a,b);
                break;
            case 2:
                level2.changePosition(a,b);
                break;
            default:
                break;
        }
        checkLose();
        checkWin();
    }
    void checkWin(){

        if (levelCount==1){
            if (level1.checkWin()){
                level1.checkWin();
                long millis = System.currentTimeMillis() - startTime;
                int seconds = (int) (millis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                String timeResult = String.format("%d:%02d", minutes, seconds);
                times[0] = timeResult;
                Log.d("asd",""+timeResult+millis);
                levelCount = 2;
                level2.invalidate();
            }
        }
        else{
            if (level2.checkWin()){
                level2.checkWin();
                long millis = System.currentTimeMillis() - startTime;
                int seconds = (int) (millis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                String timeResult = String.format("%d:%02d", minutes, seconds);
                times[1] = timeResult;
                String timeString = times[0] + " " +times[1];
                Log.d("test"," "+times[0] + " " +times[1]);
                Intent end = new Intent(this.getContext(), ResultScreen.class);
                end.setAction(Intent.ACTION_SEND);
                end.putExtra(Intent.EXTRA_TEXT, timeString);
                end.setType("text/plain");
                this.getContext().startActivity(end);
            }
        }

    }
    void checkLose() {

        if (levelCount==1){
            if (level1.checkLose()) {
                level1.checkLose();
                startTime = System.currentTimeMillis();
            }
        }
        else{
            if (level2.checkLose()){
                level2.checkLose();
                startTime = System.currentTimeMillis();
            }
        }
    }
}
