package com.medziku.plantwatering.station.parts;


import com.medziku.plantwatering.station.AbstractPlantStationPart;

public abstract class HumiditySensor extends AbstractPlantStationPart {

    protected float mHumidity;

    public float getHumidity() {
        return mHumidity;
    }

    public void setHumidity(float humidity) {
        this.mHumidity = humidity;
    }
}
