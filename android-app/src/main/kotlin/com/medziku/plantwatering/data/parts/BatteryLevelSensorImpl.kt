package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.BatteryLevelSensor


class BatteryLevelSensorImpl : BatteryLevelSensor, Parcelable {

    constructor(name: String, batteryLevels: FloatArray) : super(name, batteryLevels)

    private constructor(`in`: Parcel) : super(`in`.readString(), floatArrayOf()) {
        val floats = FloatArray(`in`.readInt())
        `in`.readFloatArray(floats)
        batteryLevels = floats
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(batteryLevels.size)
        dest.writeFloatArray(batteryLevels)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<BatteryLevelSensorImpl> = object : Parcelable.Creator<BatteryLevelSensorImpl> {
            override fun createFromParcel(`in`: Parcel): BatteryLevelSensorImpl {
                return BatteryLevelSensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<BatteryLevelSensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}