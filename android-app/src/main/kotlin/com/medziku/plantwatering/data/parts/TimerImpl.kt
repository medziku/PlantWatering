package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.Timer


class TimerImpl : Timer, Parcelable {

    constructor(name: String, time: String) : super(name, time)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readString())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(time)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<TimerImpl> = object : Parcelable.Creator<TimerImpl> {
            override fun createFromParcel(`in`: Parcel): TimerImpl {
                return TimerImpl(`in`)
            }

            override fun newArray(size: Int): Array<TimerImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
