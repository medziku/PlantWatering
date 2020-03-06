package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.Thermometer


class ThermometerImpl : Thermometer, Parcelable {

    constructor(name: String, temperature: Float) : super(name, temperature)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(temperature)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<ThermometerImpl> = object : Parcelable.Creator<ThermometerImpl> {
            override fun createFromParcel(`in`: Parcel): ThermometerImpl {
                return ThermometerImpl(`in`)
            }

            override fun newArray(size: Int): Array<ThermometerImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
