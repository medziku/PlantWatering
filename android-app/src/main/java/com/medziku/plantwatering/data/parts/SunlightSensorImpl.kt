package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.SunlightSensor


class SunlightSensorImpl : SunlightSensor, Parcelable {

    constructor(name: String, sunlightLevel: Float) : super(name, sunlightLevel)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(sunlightLevel)
    }

    companion object {

        val CREATOR: Parcelable.Creator<SunlightSensorImpl> = object : Parcelable.Creator<SunlightSensorImpl> {
            override fun createFromParcel(`in`: Parcel): SunlightSensorImpl {
                return SunlightSensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<SunlightSensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
