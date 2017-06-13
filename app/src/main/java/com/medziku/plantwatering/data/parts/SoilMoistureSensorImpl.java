package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.SoilMoistureSensor;


public class SoilMoistureSensorImpl extends SoilMoistureSensor implements Parcelable {

    public SoilMoistureSensorImpl(String name, float soilMoistureLevel) {
        super(name, soilMoistureLevel);
    }

    private SoilMoistureSensorImpl(Parcel in) {
        super(in.readString(), in.readFloat());
    }

    public static final Creator<SoilMoistureSensorImpl> CREATOR = new Creator<SoilMoistureSensorImpl>() {
        @Override
        public SoilMoistureSensorImpl createFromParcel(Parcel in) {
            return new SoilMoistureSensorImpl(in);
        }

        @Override
        public SoilMoistureSensorImpl[] newArray(int size) {
            return new SoilMoistureSensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeFloat(getSoilMoistureLevel());
    }
}
