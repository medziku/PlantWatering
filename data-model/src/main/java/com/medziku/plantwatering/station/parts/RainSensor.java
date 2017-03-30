package com.medziku.plantwatering.station.parts;

import com.medziku.plantwatering.station.AbstractPlantStationPart;
import com.medziku.plantwatering.station.PasivePlantStationPart;


public abstract class RainSensor extends AbstractPlantStationPart implements PasivePlantStationPart {

    protected boolean mIsRaining;

    public boolean isRaining() {
        return mIsRaining;
    }

    public void setRaining(boolean raining) {
        this.mIsRaining = raining;
    }
}
