package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.PasivePlantStationPart


abstract class WaterLevelSensor(override var name: String, var waterLevel: Float = 0f) : PasivePlantStationPart
