package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.Pump;


public class PumpImpl extends Pump implements Parcelable {

    public PumpImpl(String name, int state, float speed) {
        super(name, state, speed);
    }

    private PumpImpl(Parcel in) {
        super(in.readString(), in.readInt(), in.readFloat());
    }

    public static final Creator<PumpImpl> CREATOR = new Creator<PumpImpl>() {
        @Override
        public PumpImpl createFromParcel(Parcel in) {
            return new PumpImpl(in);
        }

        @Override
        public PumpImpl[] newArray(int size) {
            return new PumpImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getState());
        dest.writeFloat(getSpeed());
    }
}
