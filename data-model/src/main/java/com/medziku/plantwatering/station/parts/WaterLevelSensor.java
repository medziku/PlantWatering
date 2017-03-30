package com.medziku.plantwatering.station.parts;

import com.medziku.plantwatering.station.AbstractPlantStationPart;
import com.medziku.plantwatering.station.PasivePlantStationPart;


public abstract class WaterLevelSensor extends AbstractPlantStationPart implements PasivePlantStationPart {

    protected float mWaterLevel;

    public float getWaterLevel() {
        return mWaterLevel;
    }

    public void setWaterLevel(float waterLevel) {
        this.mWaterLevel = waterLevel;
    }
}
