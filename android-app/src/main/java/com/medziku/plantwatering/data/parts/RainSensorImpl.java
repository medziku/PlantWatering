package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.RainSensor;


public class RainSensorImpl extends RainSensor implements Parcelable {

    public RainSensorImpl(String name, boolean isRaining) {
        super(name, isRaining);
    }

    private RainSensorImpl(Parcel in) {
        super(in.readString(), in.readByte() == 1);
    }

    public static final Creator<RainSensorImpl> CREATOR = new Creator<RainSensorImpl>() {
        @Override
        public RainSensorImpl createFromParcel(Parcel in) {
            return new RainSensorImpl(in);
        }

        @Override
        public RainSensorImpl[] newArray(int size) {
            return new RainSensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeByte(isRaining() ? (byte) 1 : (byte) 0);
    }
}