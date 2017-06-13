package com.medziku.plantwatering.station.parts


import com.medziku.plantwatering.station.PasivePlantStationPart

abstract class SunlightSensor(override var name: String, var sunlightLevel: Float = 0f) : PasivePlantStationPart
