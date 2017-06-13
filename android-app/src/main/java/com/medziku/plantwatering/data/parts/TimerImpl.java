package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.Timer;


public class TimerImpl extends Timer implements Parcelable {

    public TimerImpl(String name, String time) {
        super(name, time);
    }

    private TimerImpl(Parcel in) {
        super(in.readString(), in.readString());
    }

    public static final Creator<TimerImpl> CREATOR = new Creator<TimerImpl>() {
        @Override
        public TimerImpl createFromParcel(Parcel in) {
            return new TimerImpl(in);
        }

        @Override
        public TimerImpl[] newArray(int size) {
            return new TimerImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeString(getTime());
    }
}
