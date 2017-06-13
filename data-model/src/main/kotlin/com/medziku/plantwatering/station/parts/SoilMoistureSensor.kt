package com.medziku.plantwatering.station.parts


import com.medziku.plantwatering.station.PasivePlantStationPart

abstract class SoilMoistureSensor(override var name: String, var soilMoistureLevel: Float = 0f) : PasivePlantStationPart
