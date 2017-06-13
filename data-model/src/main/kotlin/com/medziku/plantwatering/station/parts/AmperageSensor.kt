package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.PasivePlantStationPart

abstract class AmperageSensor(override var name: String, var amperage: Float = 0f) : PasivePlantStationPart