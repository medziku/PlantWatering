package com.medziku.plantwatering.station.parts;

import com.medziku.plantwatering.station.AbstractPlantStationPart;
import com.medziku.plantwatering.station.PasivePlantStationPart;


public abstract class Thermometer extends AbstractPlantStationPart implements PasivePlantStationPart {

    protected float mTemperature;

    public float getTemperature() {
        return mTemperature;
    }

    public void setTemperature(float temperature) {
        this.mTemperature = temperature;
    }
}
