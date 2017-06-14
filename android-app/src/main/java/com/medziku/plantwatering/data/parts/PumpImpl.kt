package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.Pump


class PumpImpl : Pump, Parcelable {

    constructor(name: String, state: Int, speed: Float) : super(name, state, speed)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readInt(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(state)
        dest.writeFloat(speed)
    }

    companion object {

        val CREATOR: Parcelable.Creator<PumpImpl> = object : Parcelable.Creator<PumpImpl> {
            override fun createFromParcel(`in`: Parcel): PumpImpl {
                return PumpImpl(`in`)
            }

            override fun newArray(size: Int): Array<PumpImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
