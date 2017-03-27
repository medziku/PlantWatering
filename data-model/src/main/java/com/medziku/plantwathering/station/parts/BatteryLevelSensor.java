package com.medziku.plantwathering.station.parts;

import com.medziku.plantwathering.station.AbstractPlantStationPart;


public class BatteryLevelSensor extends AbstractPlantStationPart {

    private float[] mBatteryLevels;

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
