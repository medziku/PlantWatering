package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.HumiditySensor;


public class HumiditySensorImpl extends HumiditySensor implements Parcelable {

    public HumiditySensorImpl(String name, float humidity) {
        this.mName= name;
        this.mHumidity = humidity;
    }

    private HumiditySensorImpl(Parcel in) {
        this.mName = in.readString();
        this.mHumidity = in.readFloat();
    }

    public static final Creator<HumiditySensorImpl> CREATOR = new Creator<HumiditySensorImpl>() {
        @Override
        public HumiditySensorImpl createFromParcel(Parcel in) {
            return new HumiditySensorImpl(in);
        }

        @Override
        public HumiditySensorImpl[] newArray(int size) {
            return new HumiditySensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeFloat(mHumidity);
    }
}
