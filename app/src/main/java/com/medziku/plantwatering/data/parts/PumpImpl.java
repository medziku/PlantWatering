package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.Pump;


public class PumpImpl extends Pump implements Parcelable {

    public PumpImpl(String name, int state, float speed) {
        this.mName = name;
        this.mState = state;
        this.mSpeed = speed;
    }

    private PumpImpl(Parcel in) {
        this.mName = in.readString();
        this.mState = in.readInt();
        this.mSpeed = in.readFloat();
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
        dest.writeString(mName);
        dest.writeInt(mState);
        dest.writeFloat(mSpeed);
    }
}
