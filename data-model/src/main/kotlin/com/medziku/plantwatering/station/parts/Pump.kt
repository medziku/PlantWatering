package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.ActivePlantStationPart


abstract class Pump(override var name: String, var state: Int, var speed: Float) : ActivePlantStationPart {

    companion object {

        val STATE_ON = 0x0
        val STATE_OFF = 0x1
    }
}
