package com.medziku.plantwathering.station.parts;


import com.medziku.plantwathering.station.AbstractPlantStationPart;

public class SoilMoisureSensor extends AbstractPlantStationPart {

    private float mSoilMoisureLevel;

    public float getSoilMoisureLevel() {
        return mSoilMoisureLevel;
    }

    public void setSoilMoisureLevel(float soilMoisureLevel) {
        this.mSoilMoisureLevel = soilMoisureLevel;
    }
}
