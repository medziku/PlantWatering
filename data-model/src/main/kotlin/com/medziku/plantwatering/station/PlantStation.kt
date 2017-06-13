package com.medziku.plantwatering.station

interface PlantStation {

    val deviceId: String

    val deviceName: String

    val bluetoothAddress: String

    val ownerKey: String

    val plantStationParts: Collection<PlantStationPart>

}
