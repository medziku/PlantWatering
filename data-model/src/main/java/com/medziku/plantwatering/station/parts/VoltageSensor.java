package com.medziku.plantwatering.station.parts;

import com.medziku.plantwatering.station.AbstractPlantStationPart;
import com.medziku.plantwatering.station.PasivePlantStationPart;


public abstract class VoltageSensor extends AbstractPlantStationPart implements PasivePlantStationPart {

    protected float mVoltage;

    public float getVoltage() {
        return mVoltage;
    }

    public void setVoltage(float voltage) {
        this.mVoltage = voltage;
    }
}
