package com.medziku.plantwatering.data

import android.os.Parcel
import android.os.Parcelable
import com.medziku.plantwatering.station.PlantStation
import com.medziku.plantwatering.station.PlantStationPart
import java.util.*

class PlantStationImpl : PlantStation, Parcelable {

    override var deviceId: String
    override var deviceName: String
    override var bluetoothAddress: String
    override var ownerKey: String// ma jakoś wskazywać (nie bezpośrednio) na id właściciela
    //może to być jakieś invitationId czy cuś, ale narazie nieistotne
    override var plantStationParts: Collection<PlantStationPart> = ArrayList()

    constructor(deviceId: String, deviceName: String, bluetoothAddress: String, ownerKey: String) {
        this.deviceId = deviceId
        this.deviceName = deviceName
        this.bluetoothAddress = bluetoothAddress
        this.ownerKey = ownerKey
    }

    private constructor(`in`: Parcel) {
        deviceId = `in`.readString()
        deviceName = `in`.readString()
        bluetoothAddress = `in`.readString()
        ownerKey = `in`.readString()
        val size = `in`.readInt()
        for (i in 0..size - 1) {
            val plantStationPart = `in`.readParcelable<Parcelable>(javaClass.classLoader)
            if (plantStationPart is PlantStationPart) {
                plantStationParts = plantStationParts.plus(plantStationPart)
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(deviceId)
        parcel.writeString(deviceName)
        parcel.writeString(bluetoothAddress)
        parcel.writeString(ownerKey)
        parcel.writeInt(plantStationParts.size)
        for (part in plantStationParts) {
            if (part is Parcelable) {
                parcel.writeParcelable(part, 0)
            }
        }
    }

    fun addPlantStationPart(part: PlantStationPart) {
        plantStationParts = plantStationParts.plus(part)
    }

    fun removePlantStationPart(part: PlantStationPart) {
        plantStationParts = plantStationParts.minus(part)
    }

    fun containsPlantStationPart(part: PlantStationPart): Boolean {
        return plantStationParts.contains(part)
    }

    companion object {

        val CREATOR: Parcelable.Creator<PlantStationImpl> = object : Parcelable.Creator<PlantStationImpl> {

            override fun createFromParcel(`in`: Parcel): PlantStationImpl {
                return PlantStationImpl(`in`)
            }

            override fun newArray(size: Int): Array<PlantStationImpl?> {
                return arrayOfNulls(size)
            }
        }
    }
}
