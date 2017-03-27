package com.medziku.plantwathering.station.parts;

import com.medziku.plantwathering.station.AbstractPlantStationPart;


public class AmperageSensor extends AbstractPlantStationPart {

    private float mAmperage;

    public float getAmperage() {
        return mAmperage;
    }

    public void setAmperage(float amperage) {
        this.mAmperage = amperage;
    }
}
