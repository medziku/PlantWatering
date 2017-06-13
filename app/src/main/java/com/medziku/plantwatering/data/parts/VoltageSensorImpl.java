package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.VoltageSensor;


public class VoltageSensorImpl extends VoltageSensor implements Parcelable {

    public VoltageSensorImpl(String name, float voltage) {
        super(name, voltage);
    }

    private VoltageSensorImpl(Parcel in) {
        super(in.readString(), in.readFloat());
    }

    public static final Creator<VoltageSensorImpl> CREATOR = new Creator<VoltageSensorImpl>() {
        @Override
        public VoltageSensorImpl createFromParcel(Parcel in) {
            return new VoltageSensorImpl(in);
        }

        @Override
        public VoltageSensorImpl[] newArray(int size) {
            return new VoltageSensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeFloat(getVoltage());
    }
}
