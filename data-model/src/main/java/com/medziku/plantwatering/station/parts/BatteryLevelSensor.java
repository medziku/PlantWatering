package com.medziku.plantwatering.station.parts;

import com.medziku.plantwatering.station.AbstractPlantStationPart;


public abstract class BatteryLevelSensor extends AbstractPlantStationPart {

    protected float[] mBatteryLevels;

    public float[] getBatteryLevels() {
        return mBatteryLevels;
    }

    public void setBatteryLevels(float[] batteryLevels) {
        this.mBatteryLevels = batteryLevels;
    }

    public int getCellCount() {
        return mBatteryLevels.length;
    }
}
