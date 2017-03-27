package com.medziku.plantwathering.station.parts;

import com.medziku.plantwathering.station.AbstractPlantStationPart;


public class RainSensor extends AbstractPlantStationPart {

    private boolean mIsRaining;

    public boolean isRaining() {
        return mIsRaining;
    }

    public void setRaining(boolean raining) {
        this.mIsRaining = raining;
    }
}
