package com.medziku.plantwatering.station.parts;


import com.medziku.plantwatering.station.AbstractPlantStationPart;
import com.medziku.plantwatering.station.PasivePlantStationPart;

public abstract class SoilMoistureSensor extends AbstractPlantStationPart implements PasivePlantStationPart {

    protected float mSoilMoistureLevel;

    public float getSoilMoistureLevel() {
        return mSoilMoistureLevel;
    }

    public void setSoilMoistureLevel(float soilMoistureLevel) {
        this.mSoilMoistureLevel = soilMoistureLevel;
    }
}
