package com.medziku.plantwatering.station.parts


import com.medziku.plantwatering.station.PasivePlantStationPart

abstract class Timer(override var name: String, var time: String? = null) : PasivePlantStationPart
