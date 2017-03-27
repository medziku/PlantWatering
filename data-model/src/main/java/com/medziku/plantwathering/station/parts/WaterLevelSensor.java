package com.medziku.plantwathering.station.parts;

import com.medziku.plantwathering.station.AbstractPlantStationPart;


public class WaterLevelSensor extends AbstractPlantStationPart {

    private float mWaterLevel;

    public float getWaterLevel() {
        return mWaterLevel;
    }

    public void setWaterLevel(float waterLevel) {
        this.mWaterLevel = waterLevel;
    }
}
