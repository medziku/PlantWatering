package com.medziku.plantwathering.station.parts;


import com.medziku.plantwathering.station.AbstractPlantStationPart;

public class Pump extends AbstractPlantStationPart {

    private int mState;

    private float mSpeed;

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        this.mState = state;
    }

    public float getSpeed() {
        return mSpeed;
    }

    public void setSpeed(float speed) {
        this.mSpeed = speed;
    }
}
