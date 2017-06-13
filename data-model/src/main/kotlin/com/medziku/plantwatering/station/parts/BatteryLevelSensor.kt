package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.PasivePlantStationPart


abstract class BatteryLevelSensor(override var name: String, var batteryLevels: FloatArray = floatArrayOf()) : PasivePlantStationPart {

    val cellCount: Int
        get() = batteryLevels.size
}
