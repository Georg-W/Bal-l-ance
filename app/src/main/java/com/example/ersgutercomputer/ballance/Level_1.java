package com.example.ersgutercomputer.ballance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;

/**
 * Created by ersgutercomputer on 10.11.2016.
 */

public class Level_1 extends View {

    private int xB;
    private int yB;
    private int xH;
    private int yH;
    private ShapeDrawable ball;
    private ShapeDrawable hole;
    private Drawable levelBackground;
    private int diameter;
    private int viewWidth;
    private int viewHeight;




    public Level_1(Context context) {
        super(context);
        createBall();
        createHole();
        createBackground();
    }

    public Level_1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Level_1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        viewHeight = canvas.getHeight();
        viewWidth = canvas.getWidth();

        levelBackground.setBounds(0,0,viewWidth,viewHeight);
        levelBackground.draw(canvas);

        hole.draw(canvas);

        ball.draw(canvas);

    }

    void changePosition(float a, float b){
        xB = (int) (xB + a*2);
        yB = (int) (yB - b*2);

        if ((xB+100 <= viewWidth && yB+100 <= viewHeight) && (xB >= 0 && yB >= 0)){
            ball.setBounds(xB, yB, xB + diameter, yB + diameter);
        }

    }

    private void createBall() {
        xB = 680;
        yB = 500;
        diameter = 100;
        ball = new ShapeDrawable(new OvalShape());
        ball.setBounds(xB, yB, xB + diameter, yB + diameter);
        ball.getPaint().setColor(BLUE);
    }
    private void createHole() {
        xH = 680;
        yH = 1750;
        diameter = 100;
        hole = new ShapeDrawable(new OvalShape());
        hole.setBounds(xH, yH, xH + diameter, yH + diameter);
        hole.getPaint().setColor(BLACK);
    }
    private void createBackground() {
        levelBackground = getResources().getDrawable(R.drawable.level_1);
    }




    boolean checkWin(){
        if ((xB >= xH-50 && xB <= xH+50)&& (yB >= yH-50) && (yB <= yH+50)){
            return true;
        }
        else {
            return false;
        }
    }
    boolean checkLose(){
        if ((xB >= 0 && xB <= 680-150) || (xB >= 680+150 && xB < viewWidth)){
            xB = 680;
            yB = 500;
            ball.setBounds(xB, yB, xB + diameter, yB + diameter);
            Log.d("test", "Lose!");
            return true;
        }
        else{
            return false;
        }
    }
}
