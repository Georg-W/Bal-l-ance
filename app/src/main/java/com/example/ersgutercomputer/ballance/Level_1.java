package com.example.ersgutercomputer.ballance;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static android.graphics.Color.RED;

/**
 * Created by ersgutercomputer on 10.11.2016.
 */

public class Level_1 extends View {

    public Level_1(Context context) {
        super(context);
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

        Paint p = new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setColor(RED);

        canvas.drawCircle(50,50,30,p);
    }
}
