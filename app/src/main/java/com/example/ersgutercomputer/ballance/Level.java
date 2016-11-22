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
    long time1;

    public Level(Context context) {
        super(context);
        startTime = System.currentTimeMillis();
    }

    public Level(Context context, AttributeSet attrs) {
        super(context, attrs);
        startTime = System.currentTimeMillis();
    }

    public Level(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onDraw(Canvas canvas) {


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
                this.time1 = millis;
                Log.d("asd",""+millis);
                levelCount = 2;
                level2.invalidate();
            }
        }
        else{
            if (level2.checkWin()){
                level2.checkWin();
                long millis = System.currentTimeMillis() - startTime-time1;
                int seconds = (int) (millis / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                String timeResult = String.format("%d:%02d", minutes, seconds);
                Log.d("test"," "+timeResult);
                Intent end = new Intent(this.getContext(), ResultScreen.class);
                end.setAction(Intent.ACTION_SEND);
                end.putExtra(Intent.EXTRA_TEXT, timeResult);
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
