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
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

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
    private int diameter;
    private int viewWidth;
    private int viewHeight;


    public Level_1(Context context) {
        super(context);
        createBubble();
        createHole();
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
        hole.draw(canvas);
        ball.draw(canvas);

        Paint linePaint = new Paint();
        linePaint.setColor(BLACK);
        canvas.drawLine(550,0,550,700,linePaint);
    }

    void changePosition(float a, float b){
        xB = (int) (xB + a*2);
        yB = (int) (yB - b*2);
        if ((xB+100 <= viewWidth && yB+100 <= viewHeight) && (xB >= 0 && yB >= 0)){
            ball.setBounds(xB, yB, xB + diameter, yB + diameter);
        }
        checkLose();
        checkWin();
    }

    private void createBubble() {
        xB = 500;
        yB = 300;
        diameter = 100;
        ball = new ShapeDrawable(new OvalShape());
        ball.setBounds(xB, yB, xB + diameter, yB + diameter);
        ball.getPaint().setColor(BLUE);
    }
    private void createHole() {
        xH = 500;
        yH = 700;
        diameter = 100;
        hole = new ShapeDrawable(new OvalShape());
        hole.setBounds(xH, yH, xH + diameter, yH + diameter);
        hole.getPaint().setColor(BLACK);
    }

    void checkWin(){
        if ((xB >= xH-50 && xB <= xH+50)&& (yB >= yH-50) && (yB <= yH+50)){
            Log.d("test", "Win!");
        }
    }
    void checkLose(){
        if ((xB >= 0 && xB <= 550-200) || (xB >= 550+200 && xB < viewWidth)){
            Log.d("test", "Lose!");
        }
    }
}
