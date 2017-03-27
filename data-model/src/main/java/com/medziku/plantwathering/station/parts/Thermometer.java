package com.medziku.plantwathering.station.parts;

import com.medziku.plantwathering.station.AbstractPlantStationPart;


public class Thermometer extends AbstractPlantStationPart {

    private float mTemperature;

    public float getTemperature() {
        return mTemperature;
    }

    public void setTemperature(float temperature) {
        this.mTemperature = temperature;
    }
}
