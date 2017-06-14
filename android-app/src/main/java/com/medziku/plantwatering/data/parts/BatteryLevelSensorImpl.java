package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.parts.BatteryLevelSensor;


public class BatteryLevelSensorImpl extends BatteryLevelSensor implements Parcelable {

    public BatteryLevelSensorImpl(String name, float[] batteryLevels) {
        super(name, batteryLevels);
    }

    private BatteryLevelSensorImpl(Parcel in) {
        super(in.readString(), new float[]{});
        float[] floats = new float[in.readInt()];
        in.readFloatArray(floats);
        setBatteryLevels(floats);
    }

    public static final Creator<BatteryLevelSensorImpl> CREATOR = new Creator<BatteryLevelSensorImpl>() {
        @Override
        public BatteryLevelSensorImpl createFromParcel(Parcel in) {
            return new BatteryLevelSensorImpl(in);
        }

        @Override
        public BatteryLevelSensorImpl[] newArray(int size) {
            return new BatteryLevelSensorImpl[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getBatteryLevels().length);
        dest.writeFloatArray(getBatteryLevels());
    }
}