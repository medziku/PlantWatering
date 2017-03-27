package com.medziku.plantwathering.station.parts;


import com.medziku.plantwathering.station.AbstractPlantStationPart;

public class Timer extends AbstractPlantStationPart {

    private String mTime; //FIXME tymczasowo

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }
}
