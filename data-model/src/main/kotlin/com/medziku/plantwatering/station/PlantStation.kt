package com.medziku.plantwatering.station

interface PlantStation {

    var deviceId: String

    var deviceName: String

    var bluetoothAddress: String

    var ownerKey: String

    var plantStationParts: Collection<PlantStationPart>

}
