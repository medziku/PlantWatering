package com.medziku.plantwatering.station.parts;


import com.medziku.plantwatering.station.AbstractPlantStationPart;

public abstract class Pump extends AbstractPlantStationPart {

    public static final int STATE_ON = 0x0;
    public static final int STATE_OFF = 0x1;

    protected int mState;

    protected float mSpeed;

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
