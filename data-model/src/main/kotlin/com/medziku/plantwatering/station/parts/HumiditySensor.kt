package com.medziku.plantwatering.station.parts

import com.medziku.plantwatering.station.PasivePlantStationPart


abstract class HumiditySensor(override var name: String, var humidity: Float) : PasivePlantStationPart
