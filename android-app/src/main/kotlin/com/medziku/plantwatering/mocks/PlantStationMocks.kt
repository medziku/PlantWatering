package com.medziku.plantwatering.mocks

import com.medziku.plantwatering.data.PlantStationImpl
import com.medziku.plantwatering.data.parts.*
import com.medziku.plantwatering.station.PlantStation
import com.medziku.plantwatering.station.parts.Pump

object PlantStationMocks {

    private val mockStationNames = listOf("AAAA", "BBBB", "CCCC",
            "DDDD", "EEEE", "FFFF", "GGGG",
            "HHHH", "IIII", "JJJJ")

    fun mockPlantStations(): List<PlantStation> {
        val mockList: MutableList<PlantStation> = mutableListOf()
        for (s in mockStationNames) {
            val plantStation: PlantStation = PlantStationImpl(s, s, s, s)
            mockAllStationParts(plantStation)
            mockList.add(plantStation)
        }
        return mockList
    }

    private fun mockAllStationParts(station: PlantStation) {
        station.plantStationParts.add(AmperageSensorImpl("Amp", 33.31f))
        station.plantStationParts.add(BatteryLevelSensorImpl("Bat", floatArrayOf(33f, 32f, 88.3f)))
        station.plantStationParts.add(HumiditySensorImpl("Hum", 1.22f))
        station.plantStationParts.add(PumpImpl("Pump", Pump.Companion.STATE_ON, 32.5f))
        station.plantStationParts.add(RainSensorImpl("Rain", true))
        station.plantStationParts.add(SoilMoistureSensorImpl("Soil", 735.33f))
        station.plantStationParts.add(SunlightSensorImpl("Sun", 22.4f))
        station.plantStationParts.add(ThermometerImpl("Therm", 33.3f))
        station.plantStationParts.add(TimerImpl("Time", "NIEZNANY"))
        station.plantStationParts.add(VoltageSensorImpl("Volt", 54.3f))
        station.plantStationParts.add(WaterLevelSensorImpl("Water", 33.3f))
    }

}