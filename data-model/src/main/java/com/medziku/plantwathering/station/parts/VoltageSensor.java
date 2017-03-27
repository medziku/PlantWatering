package com.medziku.plantwathering.station.parts;

import com.medziku.plantwathering.station.AbstractPlantStationPart;


public class VoltageSensor extends AbstractPlantStationPart {

    private float mVoltage;

    public float getVoltage() {
        return mVoltage;
    }

    public void setVoltage(float voltage) {
        this.mVoltage = voltage;
    }
}
