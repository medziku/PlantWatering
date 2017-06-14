package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.Thermometer;


public class ThermometerImpl extends Thermometer implements Parcelable {

    public ThermometerImpl(String name, float temperature) {
        super(name, temperature);
    }

    private ThermometerImpl(Parcel in) {
        super(in.readString(), in.readFloat());
    }

    public static final Creator<ThermometerImpl> CREATOR = new Creator<ThermometerImpl>() {
        @Override
        public ThermometerImpl createFromParcel(Parcel in) {
            return new ThermometerImpl(in);
        }

        @Override
        public ThermometerImpl[] newArray(int size) {
            return new ThermometerImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeFloat(getTemperature());
    }
}