package com.example.ersgutercomputer.ballance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import static android.graphics.Color.RED;

/**
 * Created by ersgutercomputer on 10.11.2016.
 */

public class Level_1 extends View {

    private int x;
    private int y;
    private ShapeDrawable bubble;
    private int diameter;


    public Level_1(Context context) {
        super(context);
        createBubble();
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

        bubble.draw(canvas);
    }

    void changePosition(float a, float b){
        x = (int) (x + a);
        y = (int) (y + b);
        Log.d("test", ""+x+" "+y);
        bubble.setBounds(x, y, x + diameter, y + diameter);
    }

    private void createBubble() {

        x = 200;
        y = 300;
        diameter = 100;
        bubble = new ShapeDrawable(new OvalShape());
        bubble.setBounds(x, y, x + diameter, y + diameter);
        bubble.getPaint().setColor(0xff74AC23);
    }
}
