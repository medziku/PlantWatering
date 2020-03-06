package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.SoilMoistureSensor


class SoilMoistureSensorImpl : SoilMoistureSensor, Parcelable {

    constructor(name: String, soilMoistureLevel: Float) : super(name, soilMoistureLevel)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(soilMoistureLevel)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<SoilMoistureSensorImpl> = object : Parcelable.Creator<SoilMoistureSensorImpl> {
            override fun createFromParcel(`in`: Parcel): SoilMoistureSensorImpl {
                return SoilMoistureSensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<SoilMoistureSensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
