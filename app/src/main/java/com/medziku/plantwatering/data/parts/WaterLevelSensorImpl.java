package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.WaterLevelSensor;


public class WaterLevelSensorImpl extends WaterLevelSensor implements Parcelable {

    public WaterLevelSensorImpl(String name, float waterLevel) {
        this.mName = name;
        this.mWaterLevel = waterLevel;
    }

    private WaterLevelSensorImpl(Parcel in) {
        this.mName = in.readString();
        this.mWaterLevel = in.readFloat();
    }

    public static final Creator<WaterLevelSensorImpl> CREATOR = new Creator<WaterLevelSensorImpl>() {
        @Override
        public WaterLevelSensorImpl createFromParcel(Parcel in) {
            return new WaterLevelSensorImpl(in);
        }

        @Override
        public WaterLevelSensorImpl[] newArray(int size) {
            return new WaterLevelSensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeFloat(mWaterLevel);
    }
}
