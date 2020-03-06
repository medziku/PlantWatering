package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.VoltageSensor


class VoltageSensorImpl : VoltageSensor, Parcelable {

    constructor(name: String, voltage: Float) : super(name, voltage)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(voltage)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<VoltageSensorImpl> = object : Parcelable.Creator<VoltageSensorImpl> {
            override fun createFromParcel(`in`: Parcel): VoltageSensorImpl {
                return VoltageSensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<VoltageSensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
