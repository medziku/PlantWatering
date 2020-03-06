package com.medziku.plantwatering.data.parts

import android.os.Parcel
import android.os.Parcelable

import com.medziku.plantwatering.station.parts.HumiditySensor


class HumiditySensorImpl : HumiditySensor, Parcelable {

    constructor(name: String, humidity: Float) : super(name, humidity)

    private constructor(`in`: Parcel) : super(`in`.readString(), `in`.readFloat())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeFloat(humidity)
    }

    companion object {

        @JvmField
        val CREATOR: Parcelable.Creator<HumiditySensorImpl> = object : Parcelable.Creator<HumiditySensorImpl> {
            override fun createFromParcel(`in`: Parcel): HumiditySensorImpl {
                return HumiditySensorImpl(`in`)
            }

            override fun newArray(size: Int): Array<HumiditySensorImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
