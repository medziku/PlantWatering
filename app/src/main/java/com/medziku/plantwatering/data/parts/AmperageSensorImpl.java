package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.AmperageSensor;


public class AmperageSensorImpl extends AmperageSensor implements Parcelable {

    public AmperageSensorImpl(String name, float amperage) {
        this.mName = name;
        this.mAmperage = amperage;
    }

    private AmperageSensorImpl(Parcel in) {
        this.mName = in.readString();
        this.mAmperage = in.readFloat();
    }

    public static final Creator<AmperageSensorImpl> CREATOR = new Creator<AmperageSensorImpl>() {
        @Override
        public AmperageSensorImpl createFromParcel(Parcel in) {
            return new AmperageSensorImpl(in);
        }

        @Override
        public AmperageSensorImpl[] newArray(int size) {
            return new AmperageSensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeFloat(mAmperage);
    }
}
