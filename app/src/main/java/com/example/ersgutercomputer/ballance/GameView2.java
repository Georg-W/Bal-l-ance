package com.example.ersgutercomputer.ballance;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameView2 extends AppCompatActivity implements SensorEventListener {

    private Sensor mSensor;
    private SensorManager mSensorManager;
    Level_1 level1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        level1 = new Level_1(this);
        setContentView(level1);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mSensor,
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        level1.changePosition(event.values[0], event.values[1]);
        level1.invalidate();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor,
                SensorManager.SENSOR_DELAY_GAME);
    }
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}

