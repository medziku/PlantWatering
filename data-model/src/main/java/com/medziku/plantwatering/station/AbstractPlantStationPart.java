package com.medziku.plantwatering.station;


public abstract class AbstractPlantStationPart implements PlantStationPart {

    protected String mName;

    public String getmName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        this.mName = name;
    }
}
