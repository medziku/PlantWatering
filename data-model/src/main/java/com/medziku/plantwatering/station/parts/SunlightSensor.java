package com.medziku.plantwatering.station.parts;


import com.medziku.plantwatering.station.AbstractPlantStationPart;
import com.medziku.plantwatering.station.PasivePlantStationPart;

public abstract class SunlightSensor extends AbstractPlantStationPart implements PasivePlantStationPart {

    protected float mSunlightLevel;

    public float getSunlightLevel() {
        return mSunlightLevel;
    }

    public void setSunlightLevel(float sunlightLevel) {
        this.mSunlightLevel = sunlightLevel;
    }
}
