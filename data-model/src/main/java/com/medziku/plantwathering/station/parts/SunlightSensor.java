package com.medziku.plantwathering.station.parts;


import com.medziku.plantwathering.station.AbstractPlantStationPart;

public class SunlightSensor extends AbstractPlantStationPart {

    private float mSunlightLevel;

    public float getSunlightLevel() {
        return mSunlightLevel;
    }

    public void setSunlightLevel(float sunlightLevel) {
        this.mSunlightLevel = sunlightLevel;
    }
}
