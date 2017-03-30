package com.medziku.plantwatering.station.parts;

import com.medziku.plantwatering.station.AbstractPlantStationPart;


public abstract class AmperageSensor extends AbstractPlantStationPart {

    protected float mAmperage;

    public float getAmperage() {
        return mAmperage;
    }

    public void setAmperage(float amperage) {
        this.mAmperage = amperage;
    }
}
