package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.PasivePlantStationPart


abstract class Thermometer(override var name: String, var temperature: Float = 0f) : PasivePlantStationPart
