package com.medziku.plantwatering.station.parts;


import com.medziku.plantwatering.station.AbstractPlantStationPart;
import com.medziku.plantwatering.station.PasivePlantStationPart;

public abstract class Timer extends AbstractPlantStationPart implements PasivePlantStationPart {

    protected String mTime; //FIXME tymczasowo

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }
}
