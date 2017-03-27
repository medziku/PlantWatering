package com.medziku.plantwathering.station.parts;


import com.medziku.plantwathering.station.AbstractPlantStationPart;

public class HumiditySensor extends AbstractPlantStationPart {

    private float mHumidity;

    public float getHumidity() {
        return mHumidity;
    }

    public void setHumidity(float humidity) {
        this.mHumidity = humidity;
    }
}
