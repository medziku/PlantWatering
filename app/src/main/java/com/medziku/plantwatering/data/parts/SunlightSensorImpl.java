package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.SunlightSensor;


public class SunlightSensorImpl extends SunlightSensor implements Parcelable {

    public SunlightSensorImpl(String name, float sunlightLevel) {
        super(name, sunlightLevel);
    }

    private SunlightSensorImpl(Parcel in) {
        super(in.readString(), in.readFloat());
    }

    public static final Creator<SunlightSensorImpl> CREATOR = new Creator<SunlightSensorImpl>() {
        @Override
        public SunlightSensorImpl createFromParcel(Parcel in) {
            return new SunlightSensorImpl(in);
        }

        @Override
        public SunlightSensorImpl[] newArray(int size) {
            return new SunlightSensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeFloat(getSunlightLevel());
    }
}
