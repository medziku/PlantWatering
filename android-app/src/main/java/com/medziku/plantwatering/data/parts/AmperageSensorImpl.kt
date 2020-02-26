package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.AmperageSensor

class AmperageSensorImpl : AmperageSensor, Parcelable {

    constructor(name: String, amperage: Float) : super(name, amperage)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(amperage)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<AmperageSensorImpl> = object : Parcelable.Creator<AmperageSensorImpl> {
            override fun createFromParcel(`in`: Parcel): AmperageSensorImpl {
                return AmperageSensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<AmperageSensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
