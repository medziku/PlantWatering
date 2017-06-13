package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.PasivePlantStationPart


abstract class VoltageSensor(override var name: String, var voltage: Float = 0f) : PasivePlantStationPart
