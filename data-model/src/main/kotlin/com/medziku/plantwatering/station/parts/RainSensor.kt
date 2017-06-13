package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.PasivePlantStationPart


abstract class RainSensor(override var name: String, var isRaining: Boolean = false) : PasivePlantStationPart
