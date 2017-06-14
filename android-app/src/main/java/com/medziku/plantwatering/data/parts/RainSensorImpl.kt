package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.RainSensor


class RainSensorImpl : RainSensor, Parcelable {

    constructor(name: String, isRaining: Boolean) : super(name, isRaining)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readByte().toInt() == 1)

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeByte(if (isRaining) 1.toByte() else 0.toByte())
    }

    companion object {

        val CREATOR: Parcelable.Creator<RainSensorImpl> = object : Parcelable.Creator<RainSensorImpl> {
            override fun createFromParcel(`in`: Parcel): RainSensorImpl {
                return RainSensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<RainSensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
