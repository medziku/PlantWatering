package com.medziku.plantwathering.station;


public abstract class AbstractPlantStationPart implements PlantStationPart {

    private String mName;

    public String getmName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        this.mName = name;
    }
}
