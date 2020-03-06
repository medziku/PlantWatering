package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.WaterLevelSensor


class WaterLevelSensorImpl : WaterLevelSensor, Parcelable {

    constructor(name: String, waterLevel: Float) : super(name, waterLevel)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(waterLevel)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<WaterLevelSensorImpl> = object : Parcelable.Creator<WaterLevelSensorImpl> {
            override fun createFromParcel(`in`: Parcel): WaterLevelSensorImpl {
                return WaterLevelSensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<WaterLevelSensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
